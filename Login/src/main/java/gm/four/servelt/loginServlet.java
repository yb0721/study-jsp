package gm.four.servelt;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gm.four.bean.LoginBean;
import gm.four.dao.*;

@WebServlet(name = "loginServlet", urlPatterns = { "/loginServlet" }, loadOnStartup = 1)
public class loginServlet extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        String id = request.getParameter("fid");
        String pwd = request.getParameter("fpwd");

        LoginBean lb = new LoginBean();
        lb.setUid(id);
        lb.setUpwd(pwd);

        LoginDao ld = new LoginDao();
        try {
            ld.conDB();
            System.out.println("数据库连接成功");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        String sql = "select * from login where uid ="+lb.getUid()+" and upwd='"+lb.getUpwd()+"'";
        System.out.println(sql);
        try {
            lb = ld.login(sql);
            System.out.println(lb.getUpwd());
            request.setAttribute("lb", lb);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}