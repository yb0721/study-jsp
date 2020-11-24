package org.four.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.four.dao.*;
import org.four.bean.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Servlet", urlPatterns = {"/allShowPage"}, loadOnStartup = 1)
public class allShowPage extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        int pageCurrent;
        if(request.getParameter("pageCurrent")!=null){
            pageCurrent = Integer.parseInt(request.getParameter("pageCurrent"));
        }
        else{
            pageCurrent = 1;
        }

        //Get login's total rows
        int n = 0;
        LoginDao ld = new LoginDao();
        // n = ld.total();
        // System.out.println(n);

        //bean
        PageBean pb = new PageBean();
        pb.setTotal(n);
        int pageTotal = 3;
        pb.setPageTotal(pageTotal);

        pb.setPages(pageCurrent);

        int pages = pb.getPages();
        System.out.println(pages);

        Map<String ,Object> m = new HashMap<String,Object>();
        m = ld.allShowPage(pb);
        request.setAttribute("m", m);
        request.getRequestDispatcher("loginShowPage.jsp").forward(request, response);
    }
}