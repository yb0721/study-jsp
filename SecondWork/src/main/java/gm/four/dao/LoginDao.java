package gm.four.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import gm.four.bean.LoginBean;

public class LoginDao {

    Connection con;
    Statement stm;
    PreparedStatement pstm;
    ResultSet rs = null;

    public Connection conDB() throws ClassNotFoundException, SQLException {
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
            return con;
    }

    public LoginBean login(String sql) throws SQLException {
        LoginBean lb = new LoginBean();

        stm = con.createStatement();
        

        rs = stm.executeQuery(sql);
        rs.next();
        if(rs.getString("pwd")!=null) {
            lb.setPwd(rs.getString("pwd"));
            lb.setName(rs.getString("name"));
        }
        return lb;
    }

    public List<LoginBean> allshows() throws ClassNotFoundException {
        List<LoginBean> lbbs = new ArrayList<LoginBean>();
        try {
            conDB();
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        String sql = "select * from login";
        try {
            pstm = con.prepareStatement(sql);

            rs = pstm.executeQuery();
            // put rs into bean
            while (rs.next()) {
                // rs's time must in one row
                LoginBean bb = new LoginBean();
                bb.setName(rs.getString("name"));
                bb.setPwd(rs.getString("pwd"));

                // put bean into ArrayList
                lbbs.add(bb);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("prepared Error!");
        }
        return lbbs;
    }

    public LoginBean findName(String name) throws ClassNotFoundException {
        LoginBean bb = new LoginBean();
        try {
            conDB();
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        String sql = "select * from login where name=?";
        try {
            stm = con.createStatement();

            rs = stm.executeQuery(sql);

            rs.next();

            LoginBean f = new LoginBean();
            f.setName(rs.getString("name"));
            f.setPwd(rs.getString("pwd"));

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return bb;
    }

    public int update(String name, LoginBean bb) throws ClassNotFoundException {
        int n = 0;
        try {
            conDB();
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        String sql = "update login set pwd=? where name=?";
        try {
            pstm = con.prepareStatement(sql);
            pstm.setString(1, bb.getPwd());
            pstm.setString(2, name);
            n = pstm.executeUpdate();
        }

        catch (SQLException e) {
            e.printStackTrace();
        }
        return n;
    }

    public List<LoginBean> sms(String x) throws ClassNotFoundException {
        List<LoginBean> lbbs = new ArrayList<LoginBean>();
        try {
            conDB();
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        String sql = "select * from login where name like concat(?, '%')";
        try {
            pstm = con.prepareStatement(sql);
            pstm.setString(1, x);
            rs = pstm.executeQuery();

            // put rs into bean
            while (rs.next()) {
                // rs's time must in one row
                LoginBean bb = new LoginBean();
                bb.setName(rs.getString("name"));
                bb.setPwd(rs.getString("pwd"));
                
                // put bean into ArrayList
                lbbs.add(bb);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("prepared Error!");
        }
        return lbbs;
    }

    
    public int delete(String name) throws ClassNotFoundException {
        int n = 0;
        try {
            conDB();
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        // String sql = "delete from login where id=?";
        String sql = "delete from login where name=?";
        try {
            pstm = con.prepareStatement(sql);
            pstm.setString(1, name);
            n = pstm.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return n;
    }

}