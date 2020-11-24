package org.four.dao;

import java.sql.*;
import java.util.*;

import org.four.bean.LoginBean;
import org.four.bean.PageBean;

public class LoginDao extends BaseDao {

    public List<LoginBean> findshow(String x) {
        List<LoginBean> llbs = new ArrayList<LoginBean>();
        openDB();
        String sql = "Select * from login where uname like '?%'";
        try {
            pstm = con.prepareStatement(sql);
            pstm.setString(1, x);
            rs = pstm.executeQuery();

            while (rs.next()) {
                LoginBean lb = new LoginBean();
                lb.setUid(rs.getInt("uid"));
                lb.setUname(rs.getString("uname"));
                lb.setUpwd(rs.getNString("upwd"));
                lb.setUdes(rs.getString("udes"));
                lb.setUimg(rs.getString("uimg"));

                llbs.add(lb);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("Error!");
        }
        return llbs;
    }

    public List<LoginBean> allshow() {
        List<LoginBean> llbs = new ArrayList<LoginBean>();
        openDB();
        String sql = "Select * from login";
        try {
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                LoginBean lb = new LoginBean();
                lb.setUid(rs.getInt("uid"));
                lb.setUname(rs.getString("uname"));
                lb.setUpwd(rs.getNString("upwd"));
                lb.setUdes(rs.getString("udes"));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("Error!");
        }
        return llbs;
    }

    public int total() {
        int n = 0;
        openDB();
        String sql = "select * from login";
        try {
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();

            rs.last();
            n = rs.getRow();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return n;
    }

    public Map<String, Object> allShowPage(PageBean pb) {
        List<LoginBean> llbs = new ArrayList<LoginBean>();
        openDB();
        String sql = "select * from login limit ?,?";

        try {
            pstm = con.prepareStatement(sql);

            int pageCurrent = pb.getPageCurrent();
            int pageTotal = pb.getPageTotal();
            int a = (pageCurrent - 1) * pageTotal;
            int b = pageTotal;
            pstm.setInt(1, a);
            pstm.setInt(2, b);
            rs = pstm.executeQuery();
        }

        catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error");
        }

        Map<String, Object> m = new HashMap<String, Object>();
        m.put("pb", pb);
        m.put("llbs", llbs);
        return m;
    }

    public int deleteLogin(int uid) {
        int n = 0;
        openDB();
        String sql = "delete from login where uid=?";
        try {
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, uid);
            n = pstm.executeUpdate();
        }

        catch (SQLException e) {
            e.printStackTrace();
        }

        finally {
            closeDB();
        }
        return n;
    }

    public LoginBean findUid(int uid) {
        LoginBean lb = new LoginBean();
        openDB();
        String sql = "select * from login where uid=?";// *****
        try {
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, uid);
            rs = pstm.executeQuery();

            //result changes bean
            //result only one rou,remove 
            rs.next();

            lb.setUid(rs.getInt("uid"));
            lb.setUname(rs.getString("uname"));
            lb.setUpwd(rs.getString("upwd"));
            lb.setUdes(rs.getString("udes"));

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        finally {
            closeDB();
        }

        return lb;
    }
    public int update(int uid,LoginBean lb) {
        int n = 0;
        openDB();
        String sql = "update login set uname=?,upwd=?,udes=? where uid=?";
        try {
            pstm = con.prepareStatement(sql);
            pstm.setString(1, lb.getUname());
            pstm.setString(2, lb.getUpwd());
            pstm.setString(3, lb.getUdes());
            pstm.setInt(4, uid);
            n = pstm.executeUpdate();
        }

        catch (SQLException e) {
            e.printStackTrace();
        }

        finally {
            closeDB();
        }
        return n;
    }
}