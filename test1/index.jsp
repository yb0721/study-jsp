<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ page import="java.sql.*" %>

<html>
    <head>  
        <title></title>
    </head>
<body>
<%
    Class.forName("com.mysql.jdbc.Driver");

    String url="jdbc:mysql://localhost:3306/jqe_school";
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
%>
</body>
</html>