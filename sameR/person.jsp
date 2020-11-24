<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ page import="java.sql.*" %>

<html>
    <head>
        <title>调用存储过程显示login表中会员人数：访问数据库1.加载数据库类2.连接数据库3.调用存储过程4.运行存储过程</title>
    </head>

    <body>
        <%
            //1.加载数据库类
            Class.forName("com.mysql.jdbc.Driver");

            //2.连接数据库
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

            //3.调用存储过程:创建CallableStatement对象,out模式的参数注册类型
            CallableStatement cstm = con.prepareCall("{call person(?)}");
            cstm.registerOutParameter(1,Types.INTEGER);

            //4.运行存储过程，如果结果放在out模式参数中
            cstm.execute();
            int n = cstm.getInt(1);
            out.println("本网站已有会员"+ n +"人");
        %>
    </body>
</html>