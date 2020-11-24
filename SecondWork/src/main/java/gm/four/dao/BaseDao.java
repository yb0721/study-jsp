package gm.four.dao;

import java.sql.*;

public class BaseDao {
    Connection con;
    PreparedStatement pstm;
    ResultSet rs = null;

    public boolean openDB() throws ClassNotFoundException {
            String url = "jdbc:sqlserver://localhost:1433;databaseName=book";
            String user="sa";  //超级管理员
            String password="123456";  //密码
            try {
                    //1.加载驱动
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    System.out.println("加载驱动成功！");
                }catch(Exception e) {
                    e.printStackTrace();
                    System.out.println("加载驱动失败！");
                }
            try {  
                    //2.连接
                    con=DriverManager.getConnection( url,user,password);
                    System.out.println("连接数据库成功！");
                }catch(Exception e) {
                    e.printStackTrace();
                    System.out.println("连接数据库失败！");
                }
        return true;
    }

    public boolean closeDB() {
        if (rs != null) {
            try {
                rs.close();
                if (pstm!=null) {
                    pstm.close();
                }
                if (con!=null) {
                    con.close();
                }
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }
}