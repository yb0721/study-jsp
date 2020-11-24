package QQlog.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

@WebFilter(filterName = "RequestWordFilter", urlPatterns = { "/LogServlet" })
public class RequestWordFilter implements Filter {

    // 全局变量
    String[] words = new String[] { "混蛋", "滚蛋", "沙雕" };

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
            throws IOException, ServletException {
            arg0.setCharacterEncoding("utf-8");
            arg1.setContentType("textml;charset=utf-8");
        // 改写Request的getParameter（）方法，叫它去接收，查找
            HttpServletRequest httpreq = (HttpServletRequest)arg0;
            MyRequest myreq = new MyRequest(httpreq);
            System.out.println(myreq.getParameter("ftitle"));

            //******因为getParameter被改写
            arg2.doFilter(myreq, arg1);
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {

    }

    public class MyRequest extends HttpServletRequestWrapper {

        HttpServletRequest request;

        public MyRequest(HttpServletRequest request) {
            super(request);
            // TODO Auto-generated constructor stub
        }

        @Override
        public String getParameter(String name) {

            //name就是表单元素的名字，这个方法的结果就是表单元素的值
            String str = super.getParameter(name);
            System.out.println("2"+str);
            //在str中查找替换违规字眼
            for(int i = 0;i<words.length;i++) {
                if(str.indexOf(words[i]) != -1) {
                    //找到就替换
                    str = str.replaceAll(words[i], "***");
                }
            }
            System.out.println("2"+str);
            return str;
        }
        
    }
}