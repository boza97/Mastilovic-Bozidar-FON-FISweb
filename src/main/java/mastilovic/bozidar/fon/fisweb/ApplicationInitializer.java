/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mastilovic.bozidar.fon.fisweb;

import java.util.EnumSet;
import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import mastilovic.bozidar.fon.fisweb.config.WebContextConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.DispatcherServlet;

/**
 *
 * @author Bozidar
 */
public class ApplicationInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        System.out.println("======================================================");
        System.out.println("============= MyWebApplicationInitializer ============");
        System.out.println("======================================================");

        AnnotationConfigWebApplicationContext webAppContext = new AnnotationConfigWebApplicationContext();
        webAppContext.register(WebContextConfig.class);
        webAppContext.setServletContext(servletContext);

//        FilterRegistration.Dynamic hiddenHttpMethodFilter = servletContext
//                .addFilter("hiddenHttpMethodFilter", new HiddenHttpMethodFilter());
//        hiddenHttpMethodFilter.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");

        ServletRegistration.Dynamic dispatcherServlet = servletContext.addServlet("DispatcherServlet", new DispatcherServlet(webAppContext));
        dispatcherServlet.addMapping("/");
        dispatcherServlet.setLoadOnStartup(1);
    }
}
