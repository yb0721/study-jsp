package org.gradle.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.gradle.dao.*;

@WebServlet(name = "bodyServlet", urlPatterns = {"/body"}, loadOnStartup = 1)
public class bodyServlet extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        
        String uheight = request.getParameter("fheight");
        String uweight = request.getParameter("fweight");
        String sex1 = request.getParameter("fsex1");
        String sex2 = request.getParameter("fsex2");

        String umes = "";
        double weight = 0.0;
        String sex = "";


        double pheight = Double.parseDouble(uheight);
        double pweight = Double.parseDouble(uweight);

        bodyDao bd = new bodyDao();
        umes = bd.mes(sex,pheight,pweight,weight,umes,sex1,sex2);

        request.setAttribute("uheight",pheight);
        request.setAttribute("uweight", pweight);
        request.setAttribute("sex",sex);
        request.setAttribute("umes", umes);
        request.getRequestDispatcher("index.jsp").forward(request,response);
        
        
    }

}