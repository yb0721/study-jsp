package gm.four.servlet;

import java.io.IOException;
import gm.four.dao.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "delete", urlPatterns = {"/deleteServlet"}, loadOnStartup = 1)
public class deleteServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        // 1.id == ?id
        String id = request.getParameter("id");
        System.out.println(id);

        // 2.dao do something
        BookDao bd = new BookDao();
        int n = 0;
        try {
            n = bd.delete(id);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        if(n != 0) {
            System.out.println("delete successful");
            response.sendRedirect("findServlet");
        }
    }
}