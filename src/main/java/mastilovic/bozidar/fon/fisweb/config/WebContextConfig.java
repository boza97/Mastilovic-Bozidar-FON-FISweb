/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mastilovic.bozidar.fon.fisweb.config;

import mastilovic.bozidar.fon.fisweb.interceptor.UserInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 *
 * @author Bozidar
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {
    "mastilovic.bozidar.fon.fisweb.controller",
    "mastilovic.bozidar.fon.fisweb.service",
    "mastilovic.bozidar.fon.fisweb.validator",
    "mastilovic.bozidar.fon.fisweb.repository"
})
public class WebContextConfig implements WebMvcConfigurer {

    @Bean
    public ViewResolver createViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/pages/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
    
    @Bean
    public UserInterceptor userInterceptor(){
        return new UserInterceptor();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/webjars/**").addResourceLocations("/webjars/");
        registry.addResourceHandler("/assets/**").addResourceLocations("/assets/");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(userInterceptor()).addPathPatterns("/department/**", "/home/**", "/");
    }
}
