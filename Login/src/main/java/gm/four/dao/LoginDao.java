package gm.four.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import gm.four.bean.LoginBean;

public class LoginDao {
    public LoginDao() {}

    Connection con;
    Statement stm; 
    ResultSet rs = null;

    public Connection conDB() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/people?characterEncoding=utf-8";
        String user = "root";
        String pwd = "1234";

        con = DriverManager.getConnection(url, user, pwd);
        return con;
    }

    public LoginBean login(String sql) throws SQLException {
        LoginBean lb = new LoginBean();

        stm = con.createStatement();
        

        rs = stm.executeQuery(sql);
        rs.next();
        if(rs.getString("upwd")!=null) {
            lb.setUid(rs.getString("uid"));
            lb.setUpwd(rs.getString("upwd"));
            lb.setUname(rs.getString("uname"));
            lb.setUdes(rs.getString("udes"));
        }
        return lb;
    }

}