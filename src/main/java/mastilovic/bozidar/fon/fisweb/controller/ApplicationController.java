/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mastilovic.bozidar.fon.fisweb.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import mastilovic.bozidar.fon.fisweb.action.AbstractAction;
import mastilovic.bozidar.fon.fisweb.action.factory.ActionFactory;
import mastilovic.bozidar.fon.fisweb.constants.ActionConstants;
import mastilovic.bozidar.fon.fisweb.constants.PageConstants;
import mastilovic.bozidar.fon.fisweb.model.User;

/**
 *
 * @author Bozidar
 */
public class ApplicationController {

    public String processRequest(String pathInfo, HttpServletRequest request) {
        String nextPage = PageConstants.VIEW_DEFAULT_ERROR;

        if (userGuard(request, pathInfo)) {
            nextPage = PageConstants.VIEW_LOGIN;
        } else {
            AbstractAction action = ActionFactory.createActionFactory(pathInfo);
            if (action != null) {
                nextPage = action.execute(request);
            }
        }

        return nextPage;
    }

    private boolean userGuard(HttpServletRequest request, String pathInfo) {
        User user = (User) request.getSession(true).getAttribute("user");
        List<String> allowedActions = createNotLoggedAllowedActions();

        if (user == null && !allowedActions.contains(pathInfo)) {
            return true;
        }

        return false;
    }

    private List<String> createNotLoggedAllowedActions() {
        return new ArrayList<String>() {
            {
                add(ActionConstants.URL_LOGIN);
            }
        };
    }

}
