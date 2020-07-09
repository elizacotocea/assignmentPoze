package io.fxbits.assignment2.validators;

import io.fxbits.assignment2.entities.User;
import org.springframework.stereotype.Component;

@Component
public class UserValidator implements Validator<User>{
    @Override
    public void validate(User entity) throws ValidatorException {
        if (entity.getUsername().length()>100)
            throw new ValidatorException("Username too long!");
    }
}
