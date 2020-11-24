<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ page import="java.sql.*" %>

<html>
    <head>
        <title>显示所有会员</title>
    </head>

    <body>
        <%
            //1.加载驱动类，连接数据库
            Class.forName("com.mysql.jdbc.Driver");
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

            //创建statement对象
            Statement stm = con.createStatement();
            String sql = "select * from login";

            //运行查询类sql语句,得到结果集，用循环语句
            ResultSet rs = null;
            rs = stm.executeQuery(sql);

            String pid;
            String pname;
            String ppwd;
            String pdes;
            %>

            <!--//用table表格显示每一行每一列-->
            <table width = "80%" align = "center" border = "1">
                <tr>
                    <td>学号</td>
                    <td>姓名</td>
                    <td>密码</td>
                    <td>简介</td>
                    <td>操作</td>
                </tr>
            <%
            while(rs.next()){//走行
            pid = rs.getString("uid");//暂定行，走列
            pname = rs.getString("uname");
            ppwd = rs.getString(3);
            pdes = rs.getString("udes");
            //out.println(pid+";"+pname+";"+ppwd+";"+pdes+";");
            //out.println("<tr><td>"+pid+"</td><td>"+pname+"</td><td>"+ppwd+"</td><td>"+pdes+"</td> <td><a href = 'doUpdate.jsp?uid = '+pid>修改</a> <a href = doUpdate.jsp>删除</a></td></tr>");
            %>

             <tr>
                    <td><%=pid%></td>
                    <td><%=pname%></td>
                    <td><%=ppwd%></td>
                    <td><%=pdes%></td>
                    <td><a href = "doUpdate.jsp?uid=<%=pid%>">修改</a><a href = "upDel.jsp?uid=<%=pid%>">删除</a></td>
                </tr>
        <%
            }
        %>
    </body>
</html>