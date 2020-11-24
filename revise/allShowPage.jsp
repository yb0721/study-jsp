<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ page import="java.sql.*" %>

<html>
    <head>
        <title>分页显示所有会员</title>
    </head>

    <body>
        <%
            //规定每页显示行数
            int pt = 3;//每页行数
            int total;//结果集的总行数
            int pp;//总页数
            int pc = 1;//当前页面行数

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
            //计算某数据表的总行数
            rs.last();//快速将游标移到最后一行
            total = rs.getRow();//获取结果集的当前行号（游标停留的位置）的行号

            //分页
            //计算总页数
            if(total%pt==0){
                pp = total/pt;
            }
            else{
                pp = (total/pt)+1;
            }

            //***分页查询
            if(request.getParameter("pc")!=null){
                pc=Integer.parseInt(request.getParameter("pc"));
            }
            String sql2 = "select * from login limit "+(pc-1)*pt+","+pt;
            rs = stm.executeQuery(sql2);

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
        </table>
        <!--显示页码-->
        <%for (int i =1;i<=pp;i++){%>
                    <a href = "allShowPage.jsp?pc=<%=i%>"><%=i%></a>
        <%}%>
        <br/>
        <a href="allShowPage.jsp?pc=1">首页</a>
        <%if(pc>1) {%>
        <a href = "allShowPage.jsp?pc=<%=pc-1%>">上一页</a>
        <%}%>
        <%if(pc<pp) {%>
        <a href = "allShowPage.jsp?pc=<%=pc+1%>">下一页</a>
        <%}%>
        <a href = "allShowPage.jsp?pc=<%=pp%>">末页</a>
        <form name ="form1" action = "allShowPage.jsp" method = "get"></form>
        <input type = "text" name = "pc"/>
        <input type = "submit" name = "submit" value = "跳转"/>
    </body>
</html>