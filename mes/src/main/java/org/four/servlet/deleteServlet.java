package org.four.servlet;

import java.io.IOException;
import org.four.dao.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Servlet", urlPatterns = {"/deleteservlet"}, loadOnStartup = 1)
public class deleteServlet extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        //1.uid == ?uid
        int uid = Integer.parseInt(request.getParameter("uid"));

        //2.dao do something
        LoginDao ld = new LoginDao();
        int n = 0;
        n = ld.deleteLogin(uid);

        if(n > 0) {
            System.out.println("删除成功");
            response.sendRedirect("showVIPServlet");
        }
    }
}