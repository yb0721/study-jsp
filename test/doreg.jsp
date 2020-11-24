<%@ page language="java" import="java.util.*" pageEncoding="gbk" contentType="textml;charset=utf-8" %>
<%@ page import="java.sql.*" %>
<%
String path = request.getContextPa
String basePath = request.getSche
%>
<html>
  <head>
     <title></title>
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
     //复习：注册就是增
     //insert into 表名[(列名，列名)，values]
     String sql = null;
     // sql = "insert into login values(7,'ls','123','路人二')";
     String ru = request.getParament("ru");
     String rp = request.getParament("rp");
     String rd = request.getParament("rd");
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