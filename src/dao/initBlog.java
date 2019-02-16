package dao;

import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Cloudqht on 2018/3/23.
 */
public class initBlog {
    public boolean initblog(String userID, String userName, String userHead,
                            String blogTitle, String blogContent,String imgUrlStr,
                            String time){
        PreparedStatement ps = null;
        //ResultSet rs = null;
        String sql = "insert into blogcontent(userID,userName,userHead,blogTitle," +
                "blogContent,userComment,approve,imgurls,time) values (?,?,?,?,?,?,?,?,?)";
        try {
            Connection conn = DBUtil.getConn();
            ps = conn.prepareStatement(sql);
            ps.setString(1,userID);
            ps.setString(2,userName);
            ps.setString(3,userHead);
            ps.setString(4,blogTitle);
            ps.setString(5,blogContent);
            ps.setString(6,null);
            ps.setInt(7,0);
            ps.setString(8,imgUrlStr);
            ps.setString(9,time);
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
