/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mastilovic.bozidar.fon.fisweb.controller;

import javax.servlet.http.HttpServletRequest;
import mastilovic.bozidar.fon.fisweb.dto.UserDto;
import mastilovic.bozidar.fon.fisweb.service.UserService;
import mastilovic.bozidar.fon.fisweb.validator.LoginValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Bozidar
 */
@Controller
public class AuthController {

    private final UserService userService;
    private final LoginValidator validator;

    @Autowired
    public AuthController(LoginValidator validator, UserService userService) {
        this.validator = validator;
        this.userService = userService;
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(validator);
    }

    @GetMapping("login")
    public String showLogin() {
        return "login";
    }

    @PostMapping("login")
    public String login(@ModelAttribute(name = "userDto") @Validated UserDto userDto,
            BindingResult result,
            HttpServletRequest request) {
        if (result.hasErrors()) {
            return "login";
        } else {
            UserDto user = userService.findByEmail(userDto.getEmail());
            request.getSession(true).setAttribute("user", user);
            return "redirect:/home";
        }
    }
    
    @GetMapping(value = "logout")
    public String logout(HttpServletRequest request){
        request.getSession(true).setAttribute("user", null);
        return "redirect:/login";
    }

    @ModelAttribute(name = "userDto")
    private UserDto getUserDto() {
        return new UserDto();
    }
}