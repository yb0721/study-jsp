package Ajax.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "checkServlet", urlPatterns = {"/checkServlet"}, loadOnStartup = 1)
public class checkServlet extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        //针对异步请求
        //doGet()3步
        //1.接收
        String username = request.getParameter("username");
        System.out.println(username);
        //2.处理，自己处理
        if (username.equals("zs")) {
            //out.println在异步请求中不马上显示在网页上，而是作为回调函数的结果返回该函数
            out.println("该用户名已占用！");
        }
        else {
            out.println("该用户名可以使用");
        }
    }
}