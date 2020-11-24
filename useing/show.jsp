<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>

<html>
    <head>  
        <title>修改表单</title>
    </head>
<body>
    <%
        int pid = 2;

        lass.forName("com.mysql.jdbc.Driver");
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
            String sql = "select * from login where uid ="+pid;

        //运行查询类sql语句，结果集一行，所以不循环
            ResultSet rs = null;
            rs = stm.executeQuery(sql);
            rs.next();
            int pid;
            String pname;
            String ppwd;
            String pdes;
            try{
                pid = rs.getInt("uid");
                pname = rs.getString("uname");
                ppwd = rs.getString("upwd");
                pdes = rs.getString("udes");
            }
            catch(Exception e){
                out.println("不存在");
            }

    %>
    <form name = "form1" action = "doReg.jsp" methon = "get">
    *学号:<input type = "text" name = "fid" value = "<%=pid%>"/><br/>
    *姓名:<input type = "text" name = "fname" value = "<%=pname%>"/><br/>
    *密码:<input type = "text" name = "fpwd" value = "<%=ppwd%>"/><br/>
    简介：<input type = "text" name = "fdes" value = "<%=pdes%>"/><br/>
</body>
</html>