package io.fxbits.assignment2.validators;
import io.fxbits.assignment2.controller.UserController;
import io.fxbits.assignment2.entities.User;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
@Component
public class UsernameValidator implements ConstraintValidator<UserConstraint,User> {
    @Override
    public void initialize(UserConstraint constraintAnnotation) {

    }

    @Override
    public boolean isValid(User value, ConstraintValidatorContext context) {
        return value.getUsername().length()<=100;
    }
}
