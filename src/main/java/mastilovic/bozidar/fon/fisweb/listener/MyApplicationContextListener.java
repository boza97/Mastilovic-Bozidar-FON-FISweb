/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mastilovic.bozidar.fon.fisweb.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

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
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("======================================================");
        System.out.println("===============  contextDestroyed  =================");
        System.out.println("=======================================================");
    }
}
