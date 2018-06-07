package vn.danhgia24h.core.errors;

public class InvalidCredentialsException extends BadRequestAlertException {
    public InvalidCredentialsException() {
        super(ErrorConstants.INVALID_CREDENTIALS_TYPE,"Wrong email or password","login","invalidcredentials");

    }
}
