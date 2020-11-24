package gm.four.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gm.four.bean.BookBean;
import gm.four.dao.BookDao;

@WebServlet(name = "doUpdate", urlPatterns = { "/doUpdateServlet" }, loadOnStartup = 1)
public class doUpdateServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        String id = request.getParameter("fid");
        String uname = request.getParameter("fbookname");
        String uauthor = request.getParameter("fbookauthor");
        String udes = request.getParameter("fbookdes");

        BookBean bb = new BookBean();
        bb.setId(id);
        bb.setBookname(uname);
        bb.setBookauthor(uauthor);
        bb.setId(uauthor);
        bb.setBookdes(udes);
        bb.setBookauthor(uauthor);

        // do something
        BookDao bd = new BookDao();

        // update
        int n = 0;
        try {
            n = bd.update(id, bb);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        if(n > 0) {
            System.out.println("update successful");
            response.sendRedirect("findServlet");
        }
    }
}