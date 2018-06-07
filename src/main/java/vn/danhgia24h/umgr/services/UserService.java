package vn.danhgia24h.umgr.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;
import vn.danhgia24h.config.ApplicationProperties;
import vn.danhgia24h.core.errors.*;
import vn.danhgia24h.umgr.endpoints.vm.ResetPasswordVM;
import vn.danhgia24h.umgr.utils.StringUtils;
import vn.danhgia24h.core.CrudService;
import vn.danhgia24h.umgr.models.Privilege;
import vn.danhgia24h.umgr.models.Role;
import vn.danhgia24h.umgr.repositories.UserRepository;
import vn.danhgia24h.umgr.models.User;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

/**
 * Created by quocvi3t on 11/14/17.
 */
@Service
@Transactional
@EnableConfigurationProperties(ApplicationProperties.class)
public class UserService extends CrudService<User,Long>{

    private static Logger logger = LoggerFactory.getLogger(UserService.class);

    private UserRepository userRepository;
    private MailService mailService;

    private final ApplicationProperties applicationProperties;
    private List<AuthenticationProvider> authenticationProviders;

    @Autowired
    public void setAuthenticationProviders(List<AuthenticationProvider> authenticationProviders) {
        this.authenticationProviders = authenticationProviders;
    }

    public UserService(UserRepository userRepository, MailService mailService, ApplicationProperties applicationProperties) {
        this.repository = this.userRepository = userRepository;
        this.mailService = mailService;
        this.applicationProperties = applicationProperties;
    }

    public Boolean changePassword(Long id, String password, String confirmPassword) {
        logger.debug("Resetting password for user #{}",id);
        if(password == null || !password.equals(confirmPassword)) {
            throw new InvalidPasswordException();
        }
        User user = get(id);
        user.setEncryptedPassword(password);
        this.repository.save(user);
        logger.debug("Successfully reset password for user #{}",id);
        return true;
    }

    public User authenticate(String email, String password) {
        User user;
        try {
            user = findByEmail(email);
            if(user.authenticate(password)) {
                return user;
            }
        } catch(EmailNotFoundException ex) {
            user = null;
        }

        if (user == null) {
            for (AuthenticationProvider authenticationProvider : authenticationProviders) {
                user = authenticationProvider.authenticate(email, password);
                if (user != null) {
                    break;
                }
            }
        }

        if(user == null) {
            throw new InvalidCredentialsException();
        }
        return user;
    }


    public User findByEmail(String email) {
        User user = this.userRepository.findOneByEmailIgnoreCase(email);
        if(user == null) {
            throw new EmailNotFoundException();
        }
        return user;
    }

    public User findUserWithAuthorities(String email) {
        User user = this.userRepository.findOneWithRolesByEmail(email);
        if(user == null) {
            throw new EmailNotFoundException();
        }
        for(Role role : user.getRoles()) {
            user.getAuthorities().add(role.getName());
            for(Privilege privilege : role.getPrivileges()) {
                user.getAuthorities().add(privilege.getName());
            }
        }
        return user;
    }

    public User findOneWithRoles(Long id) {
        return this.userRepository.findOneWithRolesById(id);
    }

    public void activeUser(Long userId, String activationToken) {
        User user = userRepository.findOne(userId);
        if(user == null) {
            throw new EmailNotFoundException();
        }

        if(user.getActivationToken() != null && activationToken.equals(user.getActivationToken()) && StringUtils.checkExpireTime(user.getActivationTokenCreated(), applicationProperties.getActivation().getExpirePeriod())) {
            user.setActive(1);
            user.setActivationToken(null);
            user.setActivated(System.currentTimeMillis());
            update(userId, user);
            logger.debug("Activated user: #{}", userId);
        } else throw new TokenExpireTimeException();
    }

    public void requestForgotPassword(String email) {
        User user = this.userRepository.findOneByEmailIgnoreCase(email);
        if(user == null) {
            throw new EmailNotFoundException();
        }

        user.setForgotPasswordToken(UUID.randomUUID().toString());
        user.setForgotPasswordTokenCreated(System.currentTimeMillis());
        update(user.getId(), user);
        if(applicationProperties.getActivation().isEnableMail()) mailService.sendPasswordResetMail(user);
        logger.debug("Request forgot password user: #{}", user.getId());
    }

    public void changeForgotPassword(ResetPasswordVM resetPasswordVM) {
        User user = userRepository.findOneByEmailIgnoreCase(resetPasswordVM.getEmail());
        if(user == null) throw new EmailNotFoundException();
        if(!resetPasswordVM.getNewPassword().equals(resetPasswordVM.getConfirmPassword())) throw new ConfirmPasswordException();

        if(user.getForgotPasswordToken() != null && resetPasswordVM.getForgotPasswordToken().equals(user.getForgotPasswordToken()) && StringUtils.checkExpireTime(user.getForgotPasswordTokenCreated(), applicationProperties.getActivation().getExpirePeriod())) {
            user.setPassword(resetPasswordVM.getNewPassword());
            user.setForgotPasswordToken(null);
            update(user.getId(), user);
            logger.debug("Change forgot password user: #{}", user.getId());
        } else throw new TokenExpireTimeException();
    }

    @Override
    protected void beforeCreate(User entity) {
        super.beforeCreate(entity);
        //hash password before saving
        if(entity.getPassword() == null || entity.getPassword().isEmpty()) {
            throw new InvalidPasswordException();
        }
        entity.setEncryptedPassword(entity.getPassword());
        if(!entity.isActive()) {
            entity.setActivationToken(UUID.randomUUID().toString());
            entity.setActivationTokenCreated(System.currentTimeMillis());
            entity.setActive(0);
        }

        // check email is exist
        User user = this.userRepository.findOneByEmailIgnoreCase(entity.getEmail());
        if(user != null) {
            throw new EmailAlreadyUsedException();
        }
    }

    @Override
    protected void afterCreate(User entity) {
        if(entity.getActive()!=null && entity.getActive() == 0 && applicationProperties.getActivation().isEnableMail()) {
            mailService.sendCreationEmail(entity);
        }
    }

    @Override
    protected void beforeUpdate(User entity) {
        super.beforeUpdate(entity);
        User old = get(entity.getId());
        //password is not allowed to update here
        entity.setPassword(old.getPassword());
    }

    @Override
    public User get(Long id) {
        return this.userRepository.findOneWithRolesById(id);
    }
}
