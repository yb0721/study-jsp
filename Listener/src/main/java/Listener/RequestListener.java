package Listener;

import java.sql.Date;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class RequestListener implements ServletRequestListener {

    public RequestListener() {

    }

    public void requestDestroyed(ServletRequestEvent arg0) {
        // TODO Auto-generated method stub
        System.out.println("网站response响应后被监听到——网");

    }

    public void requestInitialized(ServletRequestEvent arg0) {
        // TODO Auto-generated method stub
        System.out.println("超链接点击时被监听到");
        //获取请求用户的IP和请求时间
        //通过“事件——get事件源对象——get方法”
        String ip = arg0.getServletRequest().getRemoteAddr();
        Date dd = new Date(0);
        String currTime = dd.toLocaleString();
        System.out.println("请求对象是："+ip+",请求时间是："+currTime);

    }

}