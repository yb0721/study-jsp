<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ page import="java.sql.*" %>

<html>
    <head>
        <title>处理删除行记录 1.从request接受要删除的学号2.访问数据库，删除学号</title>
    </head>

    <body>
        <%
            //接受request
            String ppid;
            ppid = request.getParameter("uid");


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

            out.println(ppid);
            //创建Statement对象，书写sql语句
            String sql="delete from login where uid= ? ";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1,ppid);
            

            //执行非查询类sql语句，得到整数
            int n=0;
            n=pstm.executeUpdate(sql);
            //利用n是否为0来判断SQL语句是否成功运行
            if(n!=0){
                System.out.println("删除成功!");
             
            }
            else{
                System.out.println("删除不成功！");
            }
        %>
    </body>
</html>