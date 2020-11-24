package QQlog.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(filterName = "WordFilter", urlPatterns = {"/LogServlet"})
public class WordFilter implements Filter {
    String[] words = {"混蛋", "滚蛋", "沙雕"};

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2) throws IOException, ServletException {
        arg0.setCharacterEncoding("utf-8");
        arg1.setContentType("textml;charset=utf-8");

        String title = arg0.getParameter("ftitle");
        // title = new String(title.getBytes("iso-8859-1"), "utf-8");
        System.out.println(title);
        String content = arg0.getParameter("fcontent");
        // int i = 0;
        // for (i=0; i<words.length; i++) {
        //     if (title.indexOf(words[i]) != -1) {
        //         title = title.replaceAll(words[i], "***");
        //     }
        // }

        // for (i=0; i<words.length; i++) {
        //     if (content.indexOf(words[i]) != -1) {
        //         content = content.replaceAll(words[i], "***");
        //     }
        // }

        title = filter(title, words);
        content = filter(content, words);

        arg0.setAttribute("title", title);
        arg0.setAttribute("content", content);
        arg2.doFilter(arg0, arg1);
        
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
    }

    public String filter(String str, String[] words) {
        System.out.println(str);
        int i = 0;
        for (i=0; i<words.length; i++) {
            System.out.println(words[i]);
            if (str.indexOf(words[i]) != -1) {
                str = str.replaceAll(words[i], "***");
            }
        }
        System.out.println(str);
        return str;
    }
}