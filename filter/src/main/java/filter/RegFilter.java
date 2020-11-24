package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(filterName = "RegFilter", urlPatterns = {"/*"})
public class RegFilter implements Filter {
    @Override
    public void destroy() {
        System.out.println("filter of login will be destroyed");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse rep, FilterChain filter) throws IOException, ServletException {
        
        //***Filter to judge the place, in line with the filter on the release, otherwise intercepted
        String username = null;

        //******session = httpSession
        //Expand servlet-http
        HttpServletRequest httpreq = (HttpServletRequest)req;
        HttpServletResponse httprep = (HttpServletResponse)rep;
        HttpSession session = httpreq.getSession();

        username = (String)session.getAttribute("username");

        if(username == null) {
            System.out.println("Please register!");
            httprep.sendRedirect("reg.jsp");
        }
        else {
            //Conditions meet,release
            filter.doFilter(req,rep);
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // TODO Auto-generated method stub

    }
}
