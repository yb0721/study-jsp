package Ajax.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Ajax.bean.LoginBean;
import Ajax.dao.LoginDao;

@WebServlet(name = "findServlet", urlPatterns = { "/findLoginServlet" }, loadOnStartup = 1)
public class findLoginServlet extends HttpServlet {

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
        ArrayList<LoginBean> ls = new ArrayList<LoginBean>();
        ls = ld.findsByUsername(username);

        String str ="";
        for(int i = 0;i<ls.size();i++) {
            //List数组取元素值ls。get（i）
            str = str + ls.get(i).getUname()+";";
            out.println(str);
        }
    }
}