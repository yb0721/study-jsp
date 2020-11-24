<%@ page language="java" import="java.util.*" pageEncoding="gbk" contentType="textml;charset=utf-8" %>
<%@ page import="java.sql.*" %>

<html>
    <head>
        <title>登录</title>
    </head>

    <body>
        <%  //利用数据库表的步骤
            //1.加载数据库驱动
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch(Exception e) {
                out.println("没有复制驱动程序！");
            }
            //2.连接数据库,四大参数：加载
            Connection con=null;
            String url="jdbc:mywql//localst:3306/jqe_school";
            String user="sa";
            String pwd="123456";
            try{
                con=DriverManager.getConnection(url,user,pwd);
            }
            catch(Exception e){
                out.println("连接数据库不成功！");
            }
            //3.设置SQL语句：statement对象
            Statement sql=null;
            sql=con.createStatement();
            //
            String sql=null;
            // sql="select * from login where name='' and password=''";
            String u=request.getParameter("u");
            String p=request.getParameter("p");

            //复习select语句
            //select * 列名 from 表名|视图名|查询名(select嵌套) [where 列名 = ‘值‘and|or 列名 = ‘值’]
            //select 汇总函数 (sum(),avg(),count(),min()) from 表名|视图名|查询名 [where 列名 = ‘值‘and|or 列名 = ‘值’]

            sql="select * from login where name='"+u+"' and password='"+p+"'";
            //4.执行SQL语句：1）查询：放入
            ResultSet rs = null;
            rs = stm.executeQuery(sql);
            String usr = null;
            while (rs.next()) {
                //获取当前游标所指行记录的某个列值
                usr = rs.getString("name");
                pwd = rs.getString("password");
            }
            if(rs!=null)
            {
            out.println("登入成功");}
            else{
            out.println("default");
            }
        %>

        <form name="form1" action="index.jsp" method="get">
        注册<input name="u"/><br/>
        登录<input name="p"/><br/>
        </form>
    </body>
</html>