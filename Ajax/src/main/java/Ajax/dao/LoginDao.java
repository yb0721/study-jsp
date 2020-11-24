package Ajax.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import Ajax.bean.LoginBean;

public class LoginDao extends BaseDao{
    //增加在表login中查找用户名的功能
    //查询数据表只有结果集：一行（表bean）还是多行（表bean数组）？
    public LoginBean findByUsername(String username) throws ClassNotFoundException {
        LoginBean lb = new LoginBean();
        openDB();
        String sql = "select * from login where uname=?";
        try {
            pstm=con.prepareStatement(sql);
            pstm.setString(1, username);

            rs = pstm.executeQuery();

            if (rs.next()) {
                lb.setUid(rs.getInt("uid"));
                lb.setUname(rs.getString("uname"));
                lb.setUpwd(rs.getString("upwd"));
                lb.setUdes(rs.getString("udes"));
                lb.setUimg(rs.getString("uimg"));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            closeDB();
        }

        return lb;
    }

    public ArrayList<LoginBean> findsByUsername(String username) {
        ArrayList<LoginBean> ls = new ArrayList<LoginBean>();
        openDB();
        String sql = "select * from login where uname=?";
        try {
            pstm=con.prepareStatement(sql);
            pstm.setString(1, username);

            rs = pstm.executeQuery();
            //因为封装，要把rs多行变成bean数组

            while (rs.next()) {
                LoginBean lb = new LoginBean();
                lb.setUid(rs.getInt("uid"));
                lb.setUname(rs.getString("uname"));
                lb.setUpwd(rs.getString("upwd"));
                lb.setUdes(rs.getString("udes"));
                lb.setUimg(rs.getString("uimg"));

                ls.add(lb);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            closeDB();
        }

        return ls;
    }
    public ArrayList<LoginBean> findNames(String username) {
        ArrayList<LoginBean> ls = new ArrayList<LoginBean>();
        //访问数据库表五步
        openDB();
        String sql = "select * from login where uname like concat('%', ?, '%')";
        try {
            pstm = con.prepareStatement(sql);
            pstm.setString(1, username);
            rs = pstm.executeQuery();

            while (rs.next()) {
                LoginBean gb = new LoginBean();
                gb.setUid(rs.getInt("uid"));
                gb.setUname(rs.getString("uname"));
                gb.setUpwd(rs.getString("upwd"));
                gb.setUdes(rs.getString("udes"));
                gb.setUimg(rs.getString("uimg"));

                ls.add(gb);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally {
            closeDB();
        }
            


        return ls;
    }

    public boolean login(String name, String pwd) {
        System.out.println("dao");
        boolean f = false;
        openDB();
        String sql = "select * from login where uname=? and upwd=?";
        try {
            pstm=con.prepareStatement(sql);
            pstm.setString(1, name);
            pstm.setString(2, pwd);
            rs = pstm.executeQuery();

            if(rs.next()) {
                //表示rs非空
                f = true;
            }
            else {
                f = false;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally {
            closeDB();
        }
        return f;
    }

}