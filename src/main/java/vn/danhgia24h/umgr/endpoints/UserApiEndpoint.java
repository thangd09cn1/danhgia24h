package vn.danhgia24h.umgr.endpoints;

import vn.danhgia24h.config.ApplicationProperties;
import vn.danhgia24h.umgr.models.User;
import vn.danhgia24h.umgr.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.*;
import vn.danhgia24h.core.CrudApiEndpoint;
import vn.danhgia24h.umgr.endpoints.vm.ResetPasswordVM;
import vn.danhgia24h.umgr.utils.SecurityUtils;

/**
 * Created by quocvi3t on 11/14/17.
 */
@RestController
@RequestMapping("/api/users")
@EnableConfigurationProperties(ApplicationProperties.class)
public class UserApiEndpoint extends CrudApiEndpoint<User,Long> {

    private static Logger logger = LoggerFactory.getLogger(UserApiEndpoint.class);
    private UserService userService;

    @Autowired
    public UserApiEndpoint(UserService service) {
        super(service);
        this.userService = service;
        this.baseUrl = "/api/users";
    }

    @RequestMapping(path="{id}/change-password", method = RequestMethod.POST)
    public void changePassword(@PathVariable("id") Long id,
                               @RequestParam("password") String password,
                               @RequestParam("confirmPassword") String confirmPassword) {
        userService.changePassword(id,password,confirmPassword);
    }

    @RequestMapping(path = "/current", method = RequestMethod.GET)
    public User currentUser() {
        String email = SecurityUtils.getCurrentUserLogin();
        return userService.findUserWithAuthorities(email);
    }

    @RequestMapping(path = "/forgot-password/init", method = RequestMethod.POST)
    public void requestForgotPassword(@RequestParam("email") String email) {
        userService.requestForgotPassword(email);
    }

    @RequestMapping(path = "/forgot-password/finish", method = RequestMethod.POST)
    public void changeForgotPassword(@RequestBody ResetPasswordVM resetPasswordVM) {
        userService.changeForgotPassword(resetPasswordVM);
    }

    @RequestMapping(path = "{userId}/activate", method = RequestMethod.POST)
    public void activateUser(@PathVariable("userId") Long userId, @RequestParam("token") String activationToken) {
        userService.activeUser(userId, activationToken);
    }
}
