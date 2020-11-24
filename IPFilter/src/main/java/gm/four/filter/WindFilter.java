package gm.four.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(filterName = "RegFilter", urlPatterns = {"/*"})
public class WindFilter implements Filter {

    String[] wz;
    @Override
    public void destroy() {
        
    }

    @Override
    public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2) throws IOException, ServletException {
        String say = arg0.getParameter("flog");
        int i = 0;
        for(i=0;i<wz.length;i++) {
            if(say.indexOf(wz[i]) != -1){

                say = say.replaceAll(wz[i], "***");
                arg0.setAttribute("say", say);
               
            }
        }
            arg2.doFilter(arg0, arg1);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // TODO Auto-generated method stub
        wz[0] = "b";
        wz[1] = "a";
        wz[2] = "black";
        wz[3] = "yellow";

    }
}
