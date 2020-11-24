<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ page import="java.sql.*" %>

<html>
    <head>
        <title></title>
    </head>

    <body>
        <%

            //0.接受姓氏
            String pname = request.getParameter("fname");

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

            //3.调用存储过程:创建CallableStatement对象,out模式的参数注册类型，in模式的参数要设置值
            CallableStatement cstm = con.prepareCall("{call personw(?,?)}");
            cstm.setString(1,pname);
            cstm.registerOutParameter(2,Types.INTEGER);
            

            //4.运行存储过程，如果结果放在out模式参数中
            cstm.execute();
            int n = cstm.getInt(2);
            out.println("本网站已有"+ pname +"姓会员"+ n +"人");
        %>
    </body>
</html>