package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gm.four.bean.AreasBean;
import gm.four.dao.*;

@WebServlet(name = "AreaServlet", urlPatterns = {"/AreaServlet"}, loadOnStartup = 1)
public class AreasServlet extends HttpServlet {

	/**
     *
     */
    private static final long serialVersionUID = 1L;

    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

                request.setCharacterEncoding("utf-8");
                response.setContentType("text/html;charset=utf-8");
                // PrintWriter out = response.getWriter();
                
                int a = Integer.parseInt(request.getParameter("length"));
                int b = Integer.parseInt(request.getParameter("width"));

                AreasBean cb = new AreasBean();
                cb.setA(a);
                cb.setB(b);
     
                AreasDao md = new AreasDao();
                cb = md.are(cb);
                request.setAttribute("cb", cb);
                request.getRequestDispatcher("index.jsp").forward(request, response);
        
            }

}