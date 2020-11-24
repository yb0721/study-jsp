package gm.four.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gm.four.bean.BookBean;
import gm.four.dao.BookDao;

@WebServlet(name = "update", urlPatterns = { "/UpdateServlet" }, loadOnStartup = 1)
public class updateServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        // change uid
        String id = request.getParameter("id");
        System.out.println(id);
        // do somthing
        BookDao bd = new BookDao();

        // search
        BookBean bb = new BookBean();
        try {
            bb = bd.findId(id);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        request.setAttribute("bb", bb);
        request.getRequestDispatcher("update.jsp").forward(request, response);
    }
}