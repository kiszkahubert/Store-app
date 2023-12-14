package com.kiszka.BookStore.validation;

import com.kiszka.BookStore.security.UserRegistration;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches,Object> {
    @Override
    public void initialize(PasswordMatches constraintAnnotation) {
    }

    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext constraintValidatorContext) {
        UserRegistration user = (UserRegistration) obj;
        return user.getPassword().equals(user.getMatchingPassword());
    }
}
