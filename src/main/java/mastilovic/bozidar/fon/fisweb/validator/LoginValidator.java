/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mastilovic.bozidar.fon.fisweb.validator;

import mastilovic.bozidar.fon.fisweb.dto.UserDto;
import mastilovic.bozidar.fon.fisweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author Bozidar
 */
@Component
public class LoginValidator implements Validator {

    private final UserService userService;

    @Autowired
    public LoginValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean supports(Class<?> type) {
        return UserDto.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        UserDto userDto = (UserDto) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", null, "Email must not be empty.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", null, "Password must not be empty.");

        if (errors.hasErrors()) {
            return;
        }

        UserDto user = userService.findByEmail(userDto.getEmail());
        if (user == null) {
            errors.rejectValue("email", null, "User with enterred email doesn't exist.");
        } else if (!user.getPassword().equals(userDto.getPassword())) {
            errors.rejectValue("password", null, "Incorrect password");
        }
    }
}
