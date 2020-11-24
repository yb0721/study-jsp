package Ajax.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Ajax.bean.LoginBean;
import Ajax.dao.LoginDao;

@WebServlet(name = "checkServlet", urlPatterns = { "/checkLoginServlet" }, loadOnStartup = 1)
public class checkLoginServlet extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        // 针对异步请求
        // doGet()3步
        // 1.接收
        String username = request.getParameter("username");
        // 2.处理 自己做事或叫别人
        LoginDao ld = new LoginDao();
        LoginBean lb = new LoginBean();
        try {
            lb = ld.findByUsername(username);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        String res = "";
        res = lb.getUname();
        //验证用户名是否找到，给出响应信息到Ajax的回调函数
        if (res != null) {
            out.println("用户名已占用");//响应信息到Ajax
        }
        else {
            out.println("用户名可以使用");
        }
    }
}