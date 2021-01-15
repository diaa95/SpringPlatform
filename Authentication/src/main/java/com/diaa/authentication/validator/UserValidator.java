package com.diaa.authentication.validator;

import com.diaa.authentication.models.User;
import com.diaa.authentication.services.UserService;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {
    private final UserService userService;

    public UserValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
     public boolean supports(Class<?> userClass){
         return User.class.equals(userClass);
     }

     @Override
    public void validate(Object target, Errors errors){
        User user = (User) target;
        if(!user.getPasswordConfirmation().equals(user.getPassword())){
            errors.rejectValue("passwordConfirmation", "Match");
        }else if(userService.findByEmail(user.getEmail()) != null){
            errors.rejectValue("email", "Registered");
        }
     }

}
