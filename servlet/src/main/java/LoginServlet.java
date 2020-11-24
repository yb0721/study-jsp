import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "LoginServlet", urlPatterns = {"/login"}, loadOnStartup = 1)
public class LoginServlet extends HttpServlet {

	/**
     *
     */
    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");

		   String uid = request.getParameter("fuser");
		   String upwd = request.getParameter("fpwd");
		   String ucode = request.getParameter("fcode");
		   String umes = "";

		   if (! uid.equals("zs")) {
			   umes = "Name Error";
		   }

		   else if (! upwd.equals("123")) {
			   umes = "Password Error";
		   }

		   else if (! ucode.equals("234")) {
			   umes = "Code Error";
		   }
		   else {
			   umes = "Sucessful!";
		   }

		   request.setAttribute("user",uid);
		   request.setAttribute("upwd",upwd);
		   request.setAttribute("ucode",ucode);
		   request.setAttribute("umes",umes);

		   request.getRequestDispatcher("index.jsp").forward(request,response);


	}

}