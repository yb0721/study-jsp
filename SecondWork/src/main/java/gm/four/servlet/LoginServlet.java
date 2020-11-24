package gm.four.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gm.four.bean.LoginBean;
import gm.four.dao.*;

@WebServlet(name = "login", urlPatterns = { "/loginServlet" }, loadOnStartup = 1)
public class LoginServlet extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

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
            System.out.println(lb.getPwd());

            if (lb.getName().equals("杨冰")) {
                response.sendRedirect("administrator.jsp"); //重定向至administrator.jsp
            }
            else{
                out.println("抱歉，您不是管理员身份！");
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}