package vn.danhgia24h.core.errors;

public class UnauthorizedExpcetion extends BadRequestAlertException {

    public UnauthorizedExpcetion(String defaultMessage, String entityName, String errorKey) {
        super(defaultMessage, entityName, errorKey);
    }

    public UnauthorizedExpcetion(String errorKey) {
        super("You are not allow to perform this action","permission",errorKey);
    }
}
