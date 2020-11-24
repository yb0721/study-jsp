package Listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextListener implements ServletContextListener {

    public ContextListener() {

    }

    @Override 
    public void contextInitialized(ServletContextEvent arg0) {
        System.out.println("application对象创建，实际上就是web应用启动:1125启动就被监听到");
        String name = arg0.getServletContext().getInitParameter("dogName");
        System.out.println(name);
    }

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
    }

}