package org.four.dao;

import java.sql.*;

public class BaseDao {
    Connection con;
    PreparedStatement pstm;
    ResultSet rs;

    public boolean openDB() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        String url = "jdbc:mysql://localhost:3306/people?characterEncoding=utf-8";
        String user = "root";
        String pwd = "1234";
        try {
            con = DriverManager.getConnection(url, user, pwd);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean closeDB() {
        if (rs != null) {
            try {
                rs.close();
                if(pstm!=null) {
                    pstm.close();
                }
                if(con!=null) {
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