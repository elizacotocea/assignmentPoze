package io.fxbits.assignment2.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UsernameValidator.class)
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface UserConstraint {
    String message() default "Username longer than 100 chars";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default{};
}
