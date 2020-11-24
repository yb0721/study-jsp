package gm.four.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import gm.four.bean.LoginBean;

public class RegDao extends BaseDao {

    PreparedStatement pstm;
    
    public int insertLogin(LoginBean gb) {
        int n = 0;
        try {
            openDB();
        } catch (ClassNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        String sql = "insert into login(name,pwd) values(?,?)";
        try {
            pstm = con.prepareStatement(sql);
            pstm.setString(1, gb.getName());
            pstm.setString(2, gb.getPwd());

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