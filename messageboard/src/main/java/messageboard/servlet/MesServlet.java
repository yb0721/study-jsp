package messageboard.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Servlet", urlPatterns = {"/MessageServlet"}, loadOnStartup = 1)
public class MesServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

        String title = request.getParameter("ftitle");
		String content = request.getParameter("fcontent");
		out.println("<h2>替换前的留言</h2>");
		out.println("title is :"+title+"<br/>");
		out.println("content is :"+content);

		out.println("<h2>替换后的留言</h2>");
		out.println("title is :"+request.getAttribute("title")+"<br/>");
		out.println("content is :"+request.getAttribute("content"));
	}

}