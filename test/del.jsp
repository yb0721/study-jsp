<%@ page language="java" import="java.util.*" pageEncoding="gbk" contentType="textml;charset=utf-8" %>
<%@ page import="java.sql.*" %>
<%
String path = request.getContextPa
String basePath = request.getSche
%>
<html>
  <head>
     <title>对数据表删除记录</title>
  </head>

  <body>
  <%
    //1.加载驱动类
     try{
         Class.ForName("com.mysql.jdbc.java.Diver");
     }
     catch(Exception e){
         out.println("没有成功加载相应的驱动类");
     }

    // 2.连接数据库:Connection,url等
     Connection con = null;
     String url = "jdbc:mysql://localhost:3306/jqe_scool";
     String user = "sa";
     String pwd = "123456";
     try{
         con = DriverManager.getConnection(url,user,pwd);
     }
     catch(Exception e){
         out.println("没有成功连接数据库！")
     }

     //3.创建statement对象
     Statement stm = null;
     try{
         stm = con.createStatement();
     }
     catch(Exception e){
         out.println("没有成功创建statement对象！");
     }

     //3.准备sql语句
     //复习：删除语句
     //delete into 表名where 条件
     String sql = null;
     //sql = "delete from 表名 login where";
     
     sql =  "insert into login values(7,'"+ru+"','"+rp+"','"+rd+"')";

     //4.statement对象运行sql语句，增是非查询语句
     try{
         int n = 0;
         n = stm.executeUpdate(sql);
     }
     catch(Exception e){
         out.println("注册失败!")
     }

  %>
  </body>
</html>