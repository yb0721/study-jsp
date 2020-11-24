<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ page import="java.sql.*" %>

<html>
    <head>
        <title>用预处理SQL语句，注册</title>
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
                out.println("数据库连接成功");
            }
            catch(Exception e){
                out.println("数据库连接不成功！");
            }

            //3.创建带预处理，带参数的SQL语句的PreparedStatement对象，依次设置参数值

            String sql = "insert into login(uid,uname,upwd,udes) values(?,?,?,?)";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1,ppid);    //set数据类型
            pstm.setString(2,pname);
            pstm.setString(3,ppwd);
            pstm.setString(4,pdes);
            

            //4.运行预处理的非查询sql语句，得到整数结果
            int n = 0;
            n = pstm.executeUpdate();
            //利用n是否为0来判断sql语句是否成功运行
            if(n != 0){
                out.print("注册会员成功");
                response.sendRedirect("index.jsp");
            }
        %>
    </body>
</html>