package org.four.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.four.bean.LoginBean;
import org.four.dao.LoginDao;

@WebServlet(name = "Servlet", urlPatterns = {"/doUpdateservlet"}, loadOnStartup = 1)
public class doUpdateServlet extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        //change,id can not changed
        //request all
        int uid = Integer.parseInt(request.getParameter("fid"));
        String uname = request.getParameter("fname");
        String upwd = request.getParameter("fpwd");
        String udes = request.getParameter("fdes");

        LoginBean lb = new LoginBean();
        lb.setUid(uid);
        lb.setUname(uname);
        lb.setUpwd(upwd);
        lb.setUdes(udes);

        //do something
        LoginDao ld = new LoginDao();

        //update
        int n = 0;
        n = ld.update(uid,lb);

        if(n > 0) {
            System.out.println("修改成功");
            response.sendRedirect("showVIPServlet");
        }
    }
}