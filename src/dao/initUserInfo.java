package dao;

import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Cloudqht on 2018/3/23.
 */
public class initUserInfo {
    public boolean initUserinfo(String userID, String userName,String userHead){
        PreparedStatement ps = null;
        //ResultSet rs = null;
        String sql = "insert into userinfo (userID,userName,userHead,blogNumber," +
                "approveNumber,previousBlogs) values (?,?,?,?,?,?)";
        try {
            Connection conn = DBUtil.getConn();
            ps = conn.prepareStatement(sql);
            ps.setString(1,userID);
            ps.setString(2,userName);
            ps.setString(3,userHead);
            ps.setInt(4,0);
            ps.setInt(5,0);
            ps.setString(6,null);
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
