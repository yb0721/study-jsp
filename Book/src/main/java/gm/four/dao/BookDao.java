package gm.four.dao;

import java.sql.SQLException;
import java.util.*;

import gm.four.bean.*;

public class BookDao extends BaseDao {
    // bean is same as ResultSet's a row, so ResultSet is bean's ArrayList

    public List<BookBean> allBooks() throws ClassNotFoundException {
        List<BookBean> lbbs = new ArrayList<BookBean>();
        openDB();
        String sql = "select * from book";
        try {
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();

            // put rs into bean
            while (rs.next()) {
                // rs's time must in one row
                BookBean bb = new BookBean();
                bb.setId(rs.getString("id"));
                bb.setBookname(rs.getString("bookname"));
                bb.setBookauthor(rs.getString("bookauthor"));
                bb.setBookdes(rs.getString("bookdes"));
                
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

    public List<BookBean> allBook(String x) throws ClassNotFoundException {
        List<BookBean> lbbs = new ArrayList<BookBean>();
        openDB();
        String sql = "select * from book where bookname like concat(?, '%')";
        try {
            pstm = con.prepareStatement(sql);
            pstm.setString(1, x);
            rs = pstm.executeQuery();

            // put rs into bean
            while (rs.next()) {
                // rs's time must in one row
                BookBean bb = new BookBean();
                bb.setId(rs.getString("id"));
                bb.setBookname(rs.getString("bookname"));
                bb.setBookauthor(rs.getString("bookauthor"));
                bb.setBookdes(rs.getString("bookdes"));
                
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

    public int total() throws ClassNotFoundException {
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
        } finally {closeDB();}

        return n;
    }

    public  Map<String, Object> allShowPage(PageBean pb) throws ClassNotFoundException {
        List<BookBean> lbbs = new ArrayList<BookBean>();
        openDB();
        int pageCurrent = pb.getPageCurrent();
        int pageTotal = pb.getPageTotal();
        String sql = "select top "+pageTotal+" * from book where id not in (select top "+pageTotal*(pageCurrent-1)+" id from book)";
        try {
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();

            // put rs into bean
            while (rs.next()) {
                // rs's time must in one row
                BookBean bb = new BookBean();
                bb.setId(rs.getString("id"));
                bb.setBookname(rs.getString("bookname"));
                bb.setBookauthor(rs.getString("bookauthor"));
                bb.setBookdes(rs.getString("bookdes"));
                
                // put bean into ArrayList
                lbbs.add(bb);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("prepared Error!");
        }

        Map<String, Object> m = new HashMap<String, Object>();
        m.put("pb", pb);
        m.put("lbbs", lbbs);
        return m;
    }

    public int delete(String id) throws ClassNotFoundException {
        int n = 0;
        openDB();
        // String sql = "delete from login where id=?";
        String sql = "delete from book where id=?";
        try {
            pstm = con.prepareStatement(sql);
            pstm.setString(1, id);
            n = pstm.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return n;
    }

    public int update(String id, BookBean bb) throws ClassNotFoundException {
        int n = 0;
        openDB();
        String sql = "update book set bookname=?, bookauthor=?, bookdes=? where id=?";
        try {
            pstm = con.prepareStatement(sql);
            pstm.setString(1, bb.getBookname());
            pstm.setString(2, bb.getBookauthor());
            pstm.setString(3, bb.getBookdes());
            pstm.setString(4, id);
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

    public BookBean findId(String id) throws ClassNotFoundException {
        BookBean bb = new BookBean();
        openDB();
        String sql = "select * from book where id=?";
        System.out.println(id);
        try {
            pstm = con.prepareStatement(sql);
            pstm.setString(1, id);
            rs = pstm.executeQuery();

            rs.next();

            bb.setId(rs.getString("id"));
            bb.setBookname(rs.getString("bookname"));
            bb.setBookauthor(rs.getString("bookauthor"));
            bb.setBookdes(rs.getString("bookdes"));

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        finally {
            closeDB();
        }

        return bb;
    }

}