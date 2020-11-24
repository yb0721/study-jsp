<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ page import="java.sql.*" %>

<html>
    <head>
        <title>注册提交过来的注册表单数据：1)接收request对象的数据；2)远程访问数据库：2-1加载数据库的驱动类 2-2连接数据库
               2-3创建statement，书写sql语句 2-4执行sql语句 2-5关库 3)响应信息</title>
    </head>

    <body>
        <%
            //接受request
            String pid = request.getParameter("fid");
            String pname = request.getParameter("fname");
            String ppwd = request.getParameter("fpwd");
            String pdes = request.getParameter("fdes");

            //加入数据检验：类型，长度，非空
            int ppid = Integer.parseInt(pid);

            //远程访问
            //1.加载数据库的类
            Class.forName("com.mysql.jdbc.Driver");

            //2.创建数据库连接，三参数
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

            //创建Statement对象，书写sql语句
            Statement stm = con.createStatement();
            String sql = "insert into login(uid,uname,upwd,udes) values("+ppid+",'"+pname+"','"+pwd+"','"+pdes+"')";

            //执行非查询类sql语句，得到整数
            int n = 0;
            n = stm.executeUpdate(sql);
            //利用n是否为0来判断sql语句是否成功运行
            if(n != 0){
                out.print("注册会员成功");
            }
            else{
                out.println("创建Statement对象不成功！");
            }
        %>
    </body>
</html>