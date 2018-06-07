package vn.danhgia24h.core.errors;

public class RoleHasNoPrivilegeException extends BadRequestAlertException {

    public RoleHasNoPrivilegeException() {
        super("Role has no privilege", "userManagement", "roleHasNoPrivilege");
    }
}
