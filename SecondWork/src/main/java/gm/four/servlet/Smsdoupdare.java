package gm.four.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gm.four.bean.LoginBean;
import gm.four.dao.LoginDao;

@WebServlet(name = "smsdoUpdate", urlPatterns = { "/doUpdate" }, loadOnStartup = 1)
public class Smsdoupdare extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        String uname = request.getParameter("fname");
        String upwd = request.getParameter("fpwd");

        LoginBean bb = new LoginBean();
        bb.setName(uname);
        bb.setPwd(upwd);

        // do something
        LoginDao bd = new LoginDao();

        // update
        int n = 0;
        try {
            n = bd.update(uname, bb);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        if(n > 0) {
            System.out.println("update successful");
            response.sendRedirect("SmsfindServlet");
        }
    }
}