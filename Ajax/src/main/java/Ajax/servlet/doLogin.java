package Ajax.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Ajax.dao.LoginDao;

@WebServlet(name = "doLogin", urlPatterns = { "/doLoginServlet" }, loadOnStartup = 1)
public class doLogin extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        //doPost()3步：异步请求，看open和send
        //1.接收
        String name = request.getParameter("username");
        String pwd = request.getParameter("userpwd");
        System.out.println("servlet:"+pwd);

        //2.处理 叫别人（表bean）做事
        LoginDao ld = new LoginDao();
        boolean flag;
        flag = ld.login(name, pwd);
        
        //3.回送响应信息给js
        if(flag) {
            out.println("恭喜，登录成功！");
        }
        else {
            out.println("用户名或密码出错！");
        }
    }
}