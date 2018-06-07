package vn.danhgia24h.umgr.services;

import vn.danhgia24h.core.Constants;
import vn.danhgia24h.core.errors.InvalidCredentialsException;
import vn.danhgia24h.umgr.models.Privilege;
import vn.danhgia24h.umgr.models.Role;
import vn.danhgia24h.umgr.models.User;
import io.github.jhipster.config.JHipsterProperties;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by quocvi3t on 11/15/17.
 */
@Service
@Transactional
public class AuthService {


    private static Logger logger = LoggerFactory.getLogger(AuthService.class);

    private UserService userService;
    private JHipsterProperties jHipsterProperties;
    private long tokenValidityInMilliseconds;
    private long tokenValidityInMillisecondsForRememberMe;

    @Autowired
    public AuthService(UserService userService, JHipsterProperties jHipsterProperties) {
        this.userService = userService;
        this.jHipsterProperties = jHipsterProperties;
        this.tokenValidityInMilliseconds =
                1000 * jHipsterProperties.getSecurity().getAuthentication().getJwt().getTokenValidityInSeconds();
        this.tokenValidityInMillisecondsForRememberMe =
                1000 * jHipsterProperties.getSecurity().getAuthentication().getJwt().getTokenValidityInSecondsForRememberMe();
    }


    public String token(String email, String password, Boolean rememberMe) {
        logger.info("Generate token for user: {}", email);
        User user = userService.authenticate(email, password);

        if(user == null) {
            throw new InvalidCredentialsException();
        }

        Date validity;
        long now = (new Date()).getTime();
        if (rememberMe) {
            validity = new Date(now + this.tokenValidityInMillisecondsForRememberMe);
        } else {
            validity = new Date(now + this.tokenValidityInMilliseconds);
        }
        String token = Jwts.builder()
                .setSubject(user.getEmail())
                .setExpiration(validity)
                .claim(Constants.JWT_SCOPE,getAuthorities(user))
                .signWith(SignatureAlgorithm.HS512, Constants.JWT_SECRET)
                .compact();
        logger.info("Token generated for user {}, token: {}", email, token);
        return token;
    }

    public List<String> getAuthorities(User user) {
        List<String> authorities = new ArrayList<>();
        for(Role role : user.getRoles()) {
            authorities.add(role.getName());
            for(Privilege privilege : role.getPrivileges()) {
                authorities.add(privilege.getName());
            }
        }
        return authorities;
    }
}
