package gm.four.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gm.four.dao.*;
import gm.four.bean.*;
import java.util.*;

@WebServlet(name = "Smsfind", urlPatterns = { "/SmsfindServlet" }, loadOnStartup = 1)
public class SfindServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        String fname = request.getParameter("name");

        List<LoginBean> lbbs = new ArrayList<LoginBean>();
        LoginDao bd = new LoginDao();
        try {
            System.out.println(fname);
            lbbs = bd.sms(fname);

        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        request.setAttribute("lbbs", lbbs);
        request.getRequestDispatcher("allShows.jsp").forward(request, response);
    }
}
