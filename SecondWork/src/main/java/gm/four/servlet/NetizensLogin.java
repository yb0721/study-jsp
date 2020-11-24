package gm.four.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gm.four.bean.LoginBean;
import gm.four.dao.*;

@WebServlet(name = "natizenslogin", urlPatterns = { "/NetizensLoginServlet" }, loadOnStartup = 1)
public class NetizensLogin extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        String name = request.getParameter("fname");
        String pwd = request.getParameter("fpwd");

        LoginBean lb = new LoginBean();
        lb.setName(name);
        lb.setPwd(pwd);

        LoginDao ld = new LoginDao();
        try {
            ld.conDB();
            System.out.println("数据库连接成功");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        String sql = "select * from login where name ='"+lb.getName() + "' and pwd='" + lb.getPwd() + "'";
        System.out.println(sql);
        try {
            lb = ld.login(sql);

            response.sendRedirect("netizens.jsp"); //重定向
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}