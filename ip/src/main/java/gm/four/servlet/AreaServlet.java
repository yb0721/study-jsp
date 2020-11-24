package gm.four.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gm.four.dao.*;

@WebServlet(name = "AreaServlet", urlPatterns = {"/AreaServlet"}, loadOnStartup = 1)
public class AreaServlet extends HttpServlet {

	/**
     *
     */
    private static final long serialVersionUID = 1L;

    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String model = request.getParameter("model");

        if(model.equals("cfx")){
                request.setCharacterEncoding("utf-8");
                response.setContentType("text/html;charset=utf-8");
                // PrintWriter out = response.getWriter();
                
                int a = Integer.parseInt(request.getParameter("length"));
                int b = Integer.parseInt(request.getParameter("width"));
        
                int c;
                areaDao md = new areaDao();
                c = md.are(a,b);
                request.setAttribute("length", a);
                request.setAttribute("width", b);
                request.setAttribute("area", c);
                request.getRequestDispatcher("index.jsp").forward(request, response);
        
            }

            else if(model.equals("square")) {
                request.setCharacterEncoding("utf-8");
                response.setContentType("text/html;charset=utf-8");
                
                int d = Integer.parseInt(request.getParameter("length"));
        
                int s;
                areaDao md = new areaDao();
                s = md.are1(d);
        
                request.setAttribute("length", d);
                request.setAttribute("area", s);
                request.getRequestDispatcher("square.jsp").forward(request, response);
            }

            else if(model.equals("circle")) {
                request.setCharacterEncoding("utf-8");
                response.setContentType("text/html;charset=utf-8");
                
                int a = Integer.parseInt(request.getParameter("length"));
        
                int s;
                areaDao md = new areaDao();
                s = md.are1(a);
        
                request.setAttribute("length", a);
                request.setAttribute("area", s);
                request.getRequestDispatcher("square.jsp").forward(request, response);
            }
    }

}