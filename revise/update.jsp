<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ page import="java.sql.*" %>

<html>
    <head>
        <title>修改个人信息1.接受修改表单数据2.访问数据库，修改学号为接收的学号</title>
    </head>

    <body>
         <%
            //接受request
            String ppid = request.getParameter("fid");
            String pname = request.getParameter("fname");
            String ppwd = request.getParameter("fpwd");
            String pdes = request.getParameter("fdes");

            //远程访问
            //1.加载数据库的类
            Class.forName("com.mysql.jdbc.Driver");

            //2.创建数据库连接，三参数
            String url="jdbc:mysql://localhost:3306/people?characterEncoding = utf-8";
            String user="root";
            String pwd="123";
            Connection con=null;

            try{
                con = DriverManager.getConnection(url,user,pwd);
            }
            catch(Exception e){
                out.println("数据库连接不成功！");
            }

            //创建Statement对象，书写sql语句
            Statement stm = con.createStatement();
            String sql="update login set uid='"+ppid+"',uname='"+pname+"',upwd='"+ppwd+"',udes='"+pdes+"' where uid='"+ppid+"'";

            //执行非查询类sql语句，得到整数
            int n = 0;
            n = stm.executeUpdate(sql);
            //利用n是否为0来判断sql语句是否成功运行
            if(n != 0){
                out.print("修改成功");
            }
            else{
                out.println("修改不成功！");
            }
        %>
    </body>
</html>