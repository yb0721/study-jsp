package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.four.bean.bodyBean;
import org.four.dao.bodyDao;

@WebServlet(name = "bodyServlet", urlPatterns = {"/body"}, loadOnStartup = 1)
public class bodyServlet extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        
        String uheight = request.getParameter("fheight");
        String uweight = request.getParameter("fweight");
        String sex1 = request.getParameter("fsex1");
        String sex2 = request.getParameter("fsex2");


        double pheight = Double.parseDouble(uheight);
        double pweight = Double.parseDouble(uweight);

        bodyBean bd = new bodyBean();
        bd.setH(pheight);
        bd.setW(pweight);
        bd.setMan(sex1);
        bd.setWoman(sex2);

        bodyDao db = new bodyDao();
        bd = db.mes(bd);

        request.setAttribute("bd",bd);
        request.getRequestDispatcher("index.jsp").forward(request,response);
        
        
    }

}