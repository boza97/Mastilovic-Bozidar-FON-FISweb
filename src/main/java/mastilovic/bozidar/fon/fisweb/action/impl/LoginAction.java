/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mastilovic.bozidar.fon.fisweb.action.impl;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import mastilovic.bozidar.fon.fisweb.action.AbstractAction;
import mastilovic.bozidar.fon.fisweb.constants.PageConstants;
import mastilovic.bozidar.fon.fisweb.model.User;

/**
 *
 * @author Bozidar
 */
public class LoginAction extends AbstractAction{

    @Override
    public String execute(HttpServletRequest request) {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        User user = findUser(request, email);
        if(user == null){
            request.setAttribute("emailError", "User with entered email doesn't exist");
            return PageConstants.VIEW_LOGIN;
        } else if(!user.getPassword().equals(password)){
            request.setAttribute("pwError", "Password was incorrect");
            return PageConstants.VIEW_LOGIN;
        } else {
            request.getSession(true).setAttribute("user", user);
            return PageConstants.VIEW_HOME;
        }
    }

    private User findUser(HttpServletRequest request, String email) {
        List<User> users = (List<User>) request.getServletContext().getAttribute("users");
        
        for (User user : users) {
            if(user.getEmail().equals(email))
                return user;
        }
        return null;
    }
    
}
