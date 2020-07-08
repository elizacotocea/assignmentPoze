package io.fxbits.assignment2.validators;

public class ValidatorException extends Exception {

    private String message;

    public ValidatorException(String message) {
        this.message = message;
    }

    public ValidatorException(String message, String message1) {
        super(message);
        this.message = message1;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
