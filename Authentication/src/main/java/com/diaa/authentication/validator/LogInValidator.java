package com.diaa.authentication.validator;


import com.diaa.authentication.models.LogIn;
import com.diaa.authentication.services.UserService;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class LogInValidator implements Validator {
    private final UserService userService;

    public LogInValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean supports(Class<?> logIn){
        return LogIn.class.equals(logIn);
    }
    @Override
    public void validate(Object target, Errors errors){
        LogIn logIn = (LogIn) target;
        if(userService.findByEmail(logIn.getRegisteredEmail()) == null){
            errors.rejectValue("registeredEmail", "Register");
        } else if(!userService.authenticateUser(logIn.getRegisteredEmail(), logIn.getRegisteredPassword())){
            errors.rejectValue("registeredPassword", "CorrectPassword");
        }
    }

}
