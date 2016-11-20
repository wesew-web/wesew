package com.wesew.admin;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * @author vladyslav.yemelianov
 */
public class AdminAppInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext context) throws ServletException {
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();

        context.addListener(new ContextLoaderListener(rootContext));

        AnnotationConfigWebApplicationContext dispatcherServlet = new AnnotationConfigWebApplicationContext();
        dispatcherServlet.register(AdminAppConfig.class);

        ServletRegistration.Dynamic dispatcher = context.addServlet("dispatcher", new DispatcherServlet(dispatcherServlet));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
    }
}
