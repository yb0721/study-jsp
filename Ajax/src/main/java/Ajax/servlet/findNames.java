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

@WebServlet(name = "findName", urlPatterns = { "/findNames" }, loadOnStartup = 1)
public class findNames extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        //doGet()3步——异步请求
        //1.接收open里面或send里面的
        String username = request.getParameter("username");
        //2.处理 因为要用表dao查找，叫别人做事
        LoginDao ld = new LoginDao();
        ArrayList<LoginBean> ls = new ArrayList<LoginBean>();
        ls = ld.findNames(username);
        //3.异步请求的结果回送js，回送格式有2种：字符串，XML格式
        //JavaBean数组转化为字符串（传统的是串加，到js那里要分割）
        //JavaBean数组转换成json对象，再转化成json对象字符串
        //JSONArray json = JSONArray.fromObject(ls);
        //json对象格式：{"uid":"1","uname":"q"}
        //String jsonStr = json.toString();
        //System.out.println(jsonStr);
    }
}