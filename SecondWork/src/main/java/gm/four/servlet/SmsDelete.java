package gm.four.servlet;

import java.io.IOException;
import gm.four.dao.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "smsdelete", urlPatterns = {"/SMSDelete"}, loadOnStartup = 1)
public class SmsDelete extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        // 1.name = ?name
        String name = request.getParameter("name");
        System.out.println(name);            

        // 2.dao do something
        LoginDao bd = new LoginDao();
        int n = 0;
        try {
            n = bd.delete(name);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        if(n != 0) {
            System.out.println("delete successful");
            response.sendRedirect("SmsfindServlet");
        }
    }
}