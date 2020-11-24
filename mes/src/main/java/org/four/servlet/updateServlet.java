package org.four.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.four.bean.LoginBean;
import org.four.dao.LoginDao;

@WebServlet(name = "Servlet", urlPatterns = {"/updateservlet"}, loadOnStartup = 1)
public class updateServlet extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        //change uid
        int uid = Integer.parseInt(request.getParameter("uid"));

        //do somthing
        LoginDao ld = new LoginDao();

        //search
        LoginBean lb = new LoginBean();
        lb = ld.findUid(uid);

        request.setAttribute("lb", lb);
        request.getRequestDispatcher("updateForm.jsp").forward(request, response);
    }
}