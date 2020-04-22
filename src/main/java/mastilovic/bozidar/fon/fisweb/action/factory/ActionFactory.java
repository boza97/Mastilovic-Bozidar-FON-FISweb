/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mastilovic.bozidar.fon.fisweb.action.factory;

import com.sun.javafx.webkit.Accessor;
import mastilovic.bozidar.fon.fisweb.action.AbstractAction;
import mastilovic.bozidar.fon.fisweb.action.impl.AddDepartmentAction;
import mastilovic.bozidar.fon.fisweb.action.impl.AllDepartmentsAction;
import mastilovic.bozidar.fon.fisweb.action.impl.DeleteDepartmentAction;
import mastilovic.bozidar.fon.fisweb.action.impl.HomeAction;
import mastilovic.bozidar.fon.fisweb.action.impl.LoginAction;
import mastilovic.bozidar.fon.fisweb.action.impl.LogoutAction;
import mastilovic.bozidar.fon.fisweb.action.impl.SaveDepartmentAction;
import mastilovic.bozidar.fon.fisweb.action.impl.UpdateDepartmentAction;
import mastilovic.bozidar.fon.fisweb.constants.ActionConstants;

/**
 *
 * @author Dusan
 */
public class ActionFactory {

    public static AbstractAction createActionFactory(String actionName) {
        AbstractAction action = null;

        System.out.println("#############ACTION NAME##################");
        System.out.println(actionName);

        if (actionName.equals(ActionConstants.URL_LOGIN)) {
            action = new LoginAction();
        } else if (actionName.equals(ActionConstants.URL_ALL_DEPARTMENTS)) {
            action = new AllDepartmentsAction();
        } else if (actionName.equals(ActionConstants.URL_ADD_DEPARTMENT)) {
            action = new AddDepartmentAction();
        } else if (actionName.equals(ActionConstants.URL_DELETE_DEPARTMENT)) {
            action = new DeleteDepartmentAction();
        } else if (actionName.equals(ActionConstants.URL_UPDATE_DEPARTMENT)) {
            action = new UpdateDepartmentAction();
        } else if(actionName.equals(ActionConstants.URL_SAVE_DEPARTMENT)){
            action = new SaveDepartmentAction();
        } else if (actionName.equals(ActionConstants.URL_HOME)) {
            action = new HomeAction();
        } else if (actionName.equals(ActionConstants.URL_LOGOUT)) {
            action = new LogoutAction();
        }

        return action;
    }
}
