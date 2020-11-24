package gm.four.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gm.four.bean.LoginBean;
import gm.four.dao.LoginDao;

@WebServlet(name = "SMSupdate", urlPatterns = { "/SMSUpdate" }, loadOnStartup = 1)
public class SMSupdate extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        // change uid
        String name = request.getParameter("name");
        System.out.println(name);
        // do somthing
        LoginDao bd = new LoginDao();

        // search
        LoginBean bb = new LoginBean();
        try {
            bb = bd.findName(name);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        request.setAttribute("bb", bb);
        request.getRequestDispatcher("SMSUpdate.jsp").forward(request, response);
    }
}