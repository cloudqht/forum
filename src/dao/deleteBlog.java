package dao;

import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class deleteBlog {
    public boolean deleteBlog(String blogId){
        PreparedStatement ps = null;

        String sql = "delete from blogcontent where blogId=?";
        try {
            Connection conn = DBUtil.getConn();
            ps = conn.prepareStatement(sql);
            ps.setString(1,blogId);

            int count = ps.executeUpdate();
            if (count>0)
                return true;
            else
                return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


}
