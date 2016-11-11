package com.framework.jeBouquine.config;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
 
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;


 


public class SpringWebAppInitializer implements WebApplicationInitializer {
 
    @Override
    public void onStartup(ServletContext container) throws ServletException {
    	AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
    	appContext.register(ApplicationContextConfig.class);
         
// 
//        container.addListener(new RequestContextListener());
        ServletRegistration.Dynamic dispatcher = container.addServlet(
                "SpringDispatcher", new DispatcherServlet(appContext));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
//    	ServletRegistration.Dynamic facesServlet = container.addServlet("Faces Servlet", new FacesServlet());
//        facesServlet.setLoadOnStartup(2);
//        facesServlet.addMapping("/*.xhtml");
    	container.addListener(new ContextLoaderListener(appContext));
        
        
        
        
        
    }
 
}