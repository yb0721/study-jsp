package org.four.servlet;

import java.io.IOException;
import org.four.dao.*;
import org.four.bean.*;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "bodyServlet", urlPatterns = {"/body"}, loadOnStartup = 1)
public class findServlet extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        String x = request.getParameter("fx");

        List<LoginBean> llbs = new ArrayList<LoginBean>();
        LoginDao ld = new LoginDao();
        llbs=ld.findshow(x);
        llbs = ld.allshow();
        System.out.println("successful!");

        request.setAttribute("llbs", llbs);
        request.getRequestDispatcher("VIPShow.jsp").forward(request, response);
        
    }
}