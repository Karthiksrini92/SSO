package com.sso.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebServletConfiguration implements WebApplicationInitializer
{
    public void onStartup(ServletContext servletcontext) throws ServletException 
    {
        AnnotationConfigWebApplicationContext webApplicationContext = new AnnotationConfigWebApplicationContext();
        webApplicationContext.register(MVCConfiguration.class);
        webApplicationContext.setServletContext(servletcontext);
        ServletRegistration.Dynamic servlet =  servletcontext.addServlet("dispatcher", new DispatcherServlet(webApplicationContext));
        servlet.setLoadOnStartup(1);
        servlet.addMapping("/");
    }
}