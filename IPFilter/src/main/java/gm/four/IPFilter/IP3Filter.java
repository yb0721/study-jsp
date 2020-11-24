package gm.four.IPFilter;


import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Properties;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(filterName = "IPFilter", urlPatterns = { "/*" })
public class IP3Filter implements Filter {

    String bip = "";

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
            throws IOException, ServletException {
            String ip = arg0.getRemoteAddr();
            if(ip.equals(bip)) {
            //ip = blackIP
            PrintWriter out = arg1.getWriter();
            out.println("IP Restricted!3");
            }
            else {
                arg2.doFilter(arg0, arg1);
            }
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
        Properties p = new Properties();
        InputStream is = IP3Filter.class.getClassLoader().getResourceAsStream("ip.properties");

        try {
            p.load(is);
            bip = p.getProperty("blackIP");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}

