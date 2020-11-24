package org.four.servelt;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.jsp.JspFactory;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;

import com.jspsmart.upload.SmartUpload;

import org.four.bean.LoginBean;
import org.four.dao.LoginDao;

@WebServlet(name = "reg", urlPatterns = { "/doRegServlet" }, loadOnStartup = 1)
public class doRegServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        SmartUpload su = new SmartUpload();
        JspFactory fac = JspFactory.getDefaultFactory();
        PageContext pageContext=fac. getPageContext(this, request, response, null,
        false, JspWriter.DEFAULT_BUFFER, true);

        su.initialize(pageContext);

        com.jspsmart.upload.File file = null;
        String allowed = "gif, jpg, doc, rar";
        String denied = "jsp, asp, php, aspx, html, htm, exe, bat";
        com.jspsmart.upload.Request req = null;

        int file_size = 2 * 1024 * 1024;
        String exceptionMsg = null;
        int i = 0;
        try {
            su.setAllowedFilesList(allowed);
            su.setDeniedFilesList(denied);
            su.setMaxFileSize(file_size);
            su.upload();

            com.jspsmart.upload.Request surequest = su.getRequest();
            int uid = Integer.parseInt(surequest.getParameter("fid"));
            String uname = surequest.getParameter("fname");
            String upwd = surequest.getParameter("fpwd");
            String udes = surequest.getParameter("fdes");

            file = su.getFiles().getFile(0);
            String filepath = null;
            if(!file.isMissing()) {
                // filepath = "/WEB-INF/upload/";
                filepath = "show/";
                filepath += file.getFileName();
                System.out.println(filepath);
                String uimg = filepath;

                file.saveAs(filepath, SmartUpload.SAVE_VIRTUAL);

                LoginBean gb = new LoginBean();
                gb.setUid(uid);
                gb.setUname(uname);
                gb.setUpwd(upwd);
                gb.setUdes(udes);
                gb.setUimg(uimg);

                LoginDao gd = new LoginDao();
                int n = gd.insertLogin(gb);

                if (n>0) {
                    out.println("注册成功");
                }
                request.setAttribute("gb", gb);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        } catch (Exception e) {
            exceptionMsg = e.getMessage() ;
            e. printStackTrace();
        }
    }
}