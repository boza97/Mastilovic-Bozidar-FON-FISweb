/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mastilovic.bozidar.fon.fisweb.action.impl;

import javax.servlet.http.HttpServletRequest;
import mastilovic.bozidar.fon.fisweb.action.AbstractAction;
import mastilovic.bozidar.fon.fisweb.constants.PageConstants;
import mastilovic.bozidar.fon.fisweb.model.User;

/**
 *
 * @author Bozidar
 */
public class HomeAction extends AbstractAction {

    @Override
    public String execute(HttpServletRequest request) {

        return PageConstants.VIEW_HOME;
    }

}
