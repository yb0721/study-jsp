<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ page import="java.sql.*" %>

<html>
    <head>
        <title>修改某个会员的信息 1.接受会员学号2.查找该学号，找到后回显信息至修改表单3.提交修改信息</title>
    </head>
    
    <body>
        <%
            //1.接受request对象的信息******？相当于method=get的表单
            String ppid = null;
            ppid = request.getParameter("uid");
            out.println(ppid);
            

            //加载驱动类，连接数据库
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
            String sql="select * from login where uid="+ppid;

            //运行查询类sql语句，得到结果集
            ResultSet rs = null;
            rs = stm.executeQuery(sql);
            %>

            <%!  //全局变量表现方式
            //定义ppid，pname，ppwd，pdes回显找到的行中的列值
            String pname;
            String ppwd;
            String pdes;
            %>
            <%
            rs.next();
            try{
                //找到了学号所在行
                ppid = rs.getString("uid");
                pname = rs.getString("uname");
                ppwd = rs.getString("upwd");
                pdes = rs.getString("udes");
            }
            catch(Exception e){
                //当结果集是空表时，rs.next()会抛异常
                out.println("学号不在表中");
            }
        %>
        <form name = "form1" action = "update.jsp" method = "get">
            *学号:<input type = "text" name = "fid" value = "<%=ppid%>" required placeholder = "学号必须是整数，范围是1-1000"/><br/>
            *姓名:<input type = "text" name = "fname" value = "<%=pname%>" required placeholder = "姓名只能10位或5个汉字" maxlength = "10"/><br/>
            *密码:<input type = "text" name = "fpwd" value = "<%=ppwd%>" required placeholder = "密码只能10位或5个汉字" maxlength = "10"/><br/>
            简介：<input type = "text" name = "fdes" value = "<%=pdes%>" required placeholder = "个人简介只能50个汉字" maxlength = "50"/><br/>
            <input type = "submit" name ="submit" value = "修改会员信息"/>
        </form>
    </body>
</html>