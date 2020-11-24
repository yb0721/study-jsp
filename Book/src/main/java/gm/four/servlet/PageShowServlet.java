package gm.four.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gm.four.dao.*;
import gm.four.bean.*;

@WebServlet(name = "showPages", urlPatterns = { "/PageShowServlet" }, loadOnStartup = 1)
public class PageShowServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        int pageCurrent;
        if (request.getParameter("pageCurrent") != null) {
            pageCurrent = Integer.parseInt(request.getParameter("pageCurrent"));
        } else {
            pageCurrent = 1;
        }

        int n = 0;
        BookDao bd = new BookDao();
        try {
            n = bd.total();
        } catch (ClassNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        PageBean pb = new PageBean();
        pb.setTotal(n);
        int pageTotal = 3;
        pb.setPageTotal(pageTotal);
        pb.setPageCurrent(pageCurrent);
        // int pages = pb.getPages();
        // System.out.println(pages);

        Map<String, Object> m = new HashMap<String, Object>();
        try {
            m = bd.allShowPage(pb);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        request.setAttribute("m", m);
        request.getRequestDispatcher("showPages.jsp").forward(request, response);
    }
}
