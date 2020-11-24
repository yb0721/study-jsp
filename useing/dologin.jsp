<%@ page language="java" import="java.util.*" import="java.lang.*" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ page import="java.sql.*" %>

<html>
    <head>
        <title>处理表单数据</title>
    </head>

    <body>
        <%
        //1.
            String pid = request.getParameter("fid");
            String ppwd = request.getParameter("fpwd");

        //按规定转换数据
            int ppid = Integer.parseInt(pid);

        //2.连接数据库
            Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/people?characterEncoding = utf-8";
            String user="root";
            String pwd="123";
            Connection con=null;

            try{
                con = DriverManager.getConnection(url,user,pwd);
                out.println("数据库连接成功");
            }
            catch(Exception e){
                out.println("数据库连接不成功！");
            }

            //创建Statement对象
            Statement stm = con.createStatement();
            String sql = "select * from login where uid = "+ppid+" and upwd = '"+ppwd+"'";

            //2.4运行查询类语句,得到结果是一张虚拟表格-结果集resultset
            ResultSet rs = null;
            rs = stm.executeQuery(sql);
            rs.next(); //当数据表刚打开时，当前记录指针下移一行

            String tpwd = null;
            try{
                tpwd = rs.getString("upwd");//得到结果集中当前记录指针的那行的upwd,空表抛异常
            }
            catch(Exception e){
                out.println("不存在！");
            }
            if(tpwd != null){
                out.println("存在");
                //response.sendRedirect("index.jsp");
            }

        %>
    </body>
</html>