package Listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextAttributeListener implements ServletContextListener {

    public ContextAttributeListener() {

    }

    public void attributeAddeds(ServletContextAttributeEvent arg0) {
        System.out.println("监听到pplication的attributeAddeds");

        String name = arg0.getName();
        String value = (String)arg0.getValue();
        System.out.println("小狗变量名："+name+"小狗变量值："+value);
    }

    public void attributeReplaced(ServletContextAttributeEvent arg0) {
    }

    public void attributeRemoved(ServletContextAttributeEvent arg0) {
        System.out.println("监听到1125到有application");

        String value = (String)arg0.getValue();
        System.out.println("小狗变量名："+value+"去外太空了");
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // TODO Auto-generated method stub

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // TODO Auto-generated method stub

    }

}