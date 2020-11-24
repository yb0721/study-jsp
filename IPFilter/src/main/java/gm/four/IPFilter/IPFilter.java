package gm.four.IPFilter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(filterName = "IPFilter", urlPatterns = {"/*"})
public class IPFilter implements Filter {

    String blackIP = null;

    @Override
    public void destroy() {
        System.out.println("Start pull black IP filter to destroy!");
    }

    @Override
    public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2) throws IOException, ServletException {
        //Judging filtering 
        //Request object to get the client's IP
            String ip = arg0.getRemoteAddr();
            if(ip.equals(blackIP)) {
                //ip = blackIP
                PrintWriter out = arg1.getWriter();
                out.println("IP Restricted!");
            }
            else {
                arg2.doFilter(arg0, arg1);
            }
        
    
    
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
        // TODO Auto-generated method stub
        blackIP = "127.0.0.2";
        System.out.println("Start pull black IP filter"+blackIP);

    }
}

