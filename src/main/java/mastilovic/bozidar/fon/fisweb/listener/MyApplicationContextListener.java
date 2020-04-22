/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mastilovic.bozidar.fon.fisweb.listener;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import mastilovic.bozidar.fon.fisweb.model.User;

/**
 *
 * @author Bozidar
 */
@WebListener
public class MyApplicationContextListener implements ServletContextListener {

    public MyApplicationContextListener() {
        System.out.println("======================================================");
        System.out.println("========= MyApplicationContextListener=================");
        System.out.println("=======================================================");
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("======================================================");
        System.out.println("==============  contextInitialized  =================");
        System.out.println("=======================================================");

        sce.getServletContext().setAttribute("users", createUsers());
        sce.getServletContext().setAttribute("departments", new ArrayList<>());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("======================================================");
        System.out.println("===============  contextDestroyed  =================");
        System.out.println("=======================================================");
    }

    private List<User> createUsers() {
        return new ArrayList<User>() {
            {
                add(new User("Bozidar", "Mastilovic", "boza@gmail.com", "boza"));
                add(new User("Petar", "Petrovic", "petar@gmail.com", "petar"));
                add(new User("Marko", "Markovic", "marko@gmail.com", "marko"));
            }
        };
    }

}
