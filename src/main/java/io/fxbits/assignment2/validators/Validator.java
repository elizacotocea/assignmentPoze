package io.fxbits.assignment2.validators;

public interface Validator<T> {
    void validate(T entity) throws ValidatorException;
}
