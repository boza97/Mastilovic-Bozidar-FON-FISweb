/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mastilovic.bozidar.fon.fisweb.action.viewresolver;

import java.util.HashMap;
import java.util.Map;
import mastilovic.bozidar.fon.fisweb.constants.PageConstants;

/**
 *
 * @author Dusan
 */
public class ViewResolver {
    private final Map<String, String> viewPageMap;
    
    public ViewResolver(){
        viewPageMap=new HashMap<String, String>(){
            {   
                put(PageConstants.VIEW_HOME,PageConstants.PAGE_HOME );
                put(PageConstants.VIEW_LOGIN,PageConstants.PAGE_LOGIN );
                put(PageConstants.VIEW_DEFAULT_ERROR,PageConstants.PAGE_DEFAULT_ERROR );
                put(PageConstants.VIEW_ALL_DEPARTMENTS, PageConstants.PAGE_ALL_DEPARTMENTS);
                put(PageConstants.VIEW_ADD_DEPARTMENT, PageConstants.PAGE_ADD_DEPARTMENT);
            }
        };
    }
    public String getPage(String view) {
        return viewPageMap.get(view);
    }
    
}
