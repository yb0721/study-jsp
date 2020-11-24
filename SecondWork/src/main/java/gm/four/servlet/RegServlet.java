package gm.four.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gm.four.bean.LoginBean;
import gm.four.dao.RegDao;

@WebServlet(name = "reg", urlPatterns = { "/regServlet" }, loadOnStartup = 1)
public class RegServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("fname");
        String pwd = request.getParameter("fpwd");

        LoginBean bb = new LoginBean();
        bb.setName(name);
        bb.setPwd(pwd);

        // do something
        RegDao bd = new RegDao();

        // update
        int n = 0;
        n = bd.insertLogin(bb);

        if(n > 0) {
            System.out.println("reg successful!");
            response.sendRedirect("netizensLogin.jsp");
        }
        else {
            out.println("该用户已被注册！");
        }
    }
}