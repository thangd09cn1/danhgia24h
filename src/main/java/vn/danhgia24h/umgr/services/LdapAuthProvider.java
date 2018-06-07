package vn.danhgia24h.umgr.services;

import vn.danhgia24h.ldap.LdapClient;
import vn.danhgia24h.config.ApplicationProperties;
import vn.danhgia24h.umgr.models.Role;
import vn.danhgia24h.umgr.models.User;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
@EnableConfigurationProperties(ApplicationProperties.class)
public class LdapAuthProvider implements AuthenticationProvider {

    private LdapClient ldapClient;
    private UserService userService;
    private RoleService roleService;

    private final ApplicationProperties applicationProperties;

    public LdapAuthProvider(LdapClient ldapClient, UserService userService, RoleService roleService, ApplicationProperties applicationProperties) {
        this.ldapClient = ldapClient;
        this.userService = userService;
        this.roleService = roleService;
        this.applicationProperties = applicationProperties;
    }

    public User authenticate(String email, String password) {
        User user = handleLDAP(email, password);
        return user;
    }

    public User handleLDAP(String email, String password) {
        if(!applicationProperties.getLdap().isEnabled()) {
            return null;
        }

        User userLDAP = null;
        String checkLDAP = ldapClient.authenticate(email, password);
        if(checkLDAP != null) {
                // inser new user
                List<Role> roleList = roleService.search("name==ROLE_USER", null).getContent();
                Set<Role> roles = new HashSet<>();
                roles.add(roleList.get(0));

                userLDAP = new User();
                userLDAP.setEmail(email);
                userLDAP.setEncryptedPassword(password);
                userLDAP.setActive(1);
                userLDAP.setRoles(roles);

                if(!StringUtils.isEmpty(checkLDAP)) {
                    String userName[] = checkLDAP.split(" ");
                    userLDAP.setLastName(userName[0]);
                    String firstName = "";
                    for(int i = 1; i < userName.length; i++) {
                        firstName = firstName + userName[i] + " ";
                    }
                    if(!("").equals(firstName)){
                        firstName = firstName.substring(0, firstName.length() - 1);
                        userLDAP.setFirstName(firstName);
                    }
                }

                userLDAP = userService.create(userLDAP);
        }
        return userLDAP;
    }

}
