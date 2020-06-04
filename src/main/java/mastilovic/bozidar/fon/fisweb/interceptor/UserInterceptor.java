/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mastilovic.bozidar.fon.fisweb.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mastilovic.bozidar.fon.fisweb.dto.UserDto;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 *
 * @author Bozidar
 */
public class UserInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        UserDto user = (UserDto) request.getSession(true).getAttribute("user");

        if (user == null) {
            String context = request.getContextPath();
            response.sendRedirect(context + "/login");
            return false;
        }
        return true;
    }
}
