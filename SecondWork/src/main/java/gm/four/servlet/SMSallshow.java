package gm.four.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gm.four.bean.*;
import gm.four.dao.*;
import java.util.*;

@WebServlet(name = "SMS", urlPatterns = { "/SMSallshow" }, loadOnStartup = 1)
public class SMSallshow extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        List<LoginBean> lbbs = new ArrayList<LoginBean>();
        LoginDao bd = new LoginDao();
        try {
            lbbs = bd.allshows();
            
            request.setAttribute("lbbs", lbbs);
            request.getRequestDispatcher("allShows.jsp").forward(request, response);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
