package org.four.dao;

import java.sql.SQLException;

import org.four.bean.LoginBean;

public class LoginDao extends BeseDao {

    public int insertLogin(LoginBean gb) {
        int n = 0;
        openDB();
        String sql = "insert into login(uid,uname,upwd,udes,uimg) values(?,?,?,?,?)";
        try {
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, gb.getUid());
            pstm.setString(2, gb.getUname());
            pstm.setString(3, gb.getUpwd());
            pstm.setString(4, gb.getUdes());
            pstm.setString(5, gb.getUimg());

            n = pstm.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        finally {
            closeDB();
        }
        return n;
        
    }
}