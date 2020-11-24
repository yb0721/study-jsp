<%@ page language="java" import="java.util.*" import="java.lang.*" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ page import="java.sql.*" %>

<html>
    <head>
        <title>搜索表单数据</title>
    </head>

    <body>
        <%
        //1.
            String ps = request.getParameter("fs");

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
            String sql = "select * from login where udes like '%"+ps+"%'";


            //2.4运行查询类语句,得到结果是一张虚拟表格-结果集resultset
            ResultSet rs = null;
            rs = stm.executeQuery(sql);
            %>

            <table>
                <caption>模糊查询的结果表</caption>
                <tr>
                    <td>学号</td>
                    <td>姓名</td>
                    <td>密码</td>
                    <td>简介</td>
                </tr>
            </table>
            <%
            String tid;
            String tname;
            String tpwd;
            String tdes;
            while(rs.next()){ //当数据表刚打开时，当前记录指针下移一行

            try{
                tid = rs.getString("uid");//类型和列名要和数据表中的列名相同
                tpwd = rs.getString("upwd");//得到结果集中当前记录指针的那行的upwd,空表抛异常
                tname = rs.getString("uname");
                tdes = rs.getString("udes");
                out.println("<tr><td>"+tid+"</td><td>"+tname+"</td><td>"+tpwd+"</td><td>"+tdes+"</td></tr>");
            }
            catch(Exception e){
                out.println("不存在！");
            }
            }

        %>
    </body>
</html>