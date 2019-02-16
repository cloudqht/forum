package dao;

import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Cloudqht on 2018/3/23.
 */

public class updateBlog {
    //更新标题
    public boolean updateBlogInfo(String blogId, String blogContent, String time, String imgUrls,String blogTitle){
        PreparedStatement ps = null;

        String sql = "update  blogcontent set blogTitle=?,blogContent=?,time=?,imgUrls=? where blogId=?";
        try {
            Connection conn = DBUtil.getConn();
            ps = conn.prepareStatement(sql);
            ps.setString(1,blogTitle);
            ps.setString(2,blogContent);
            ps.setString(3,time);
            ps.setString(4,imgUrls);
            ps.setString(5,blogId);

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

    public boolean updateBlogTitle(String blogId, String blogTitle){
        PreparedStatement ps = null;

        String sql = "update  blogcontent set blogTitle=? where blogId=?";
        try {
            Connection conn = DBUtil.getConn();
            ps = conn.prepareStatement(sql);
            ps.setString(1,blogTitle);
            ps.setString(2,blogId);

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
    public boolean updateBlogTime(String blogId, String time){
        PreparedStatement ps = null;

        String sql = "update  blogcontent set time=? where blogId=?";
        try {
            Connection conn = DBUtil.getConn();
            ps = conn.prepareStatement(sql);
            ps.setString(1,time);
            ps.setString(2,blogId);

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
    public boolean updateBlogImg(String blogId, String imgurls){
        PreparedStatement ps = null;

        String sql = "update  blogcontent set imgurls=? where blogId=?";
        try {
            Connection conn = DBUtil.getConn();
            ps = conn.prepareStatement(sql);
            ps.setString(1,imgurls);
            ps.setString(2,blogId);

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
    //更新内容
    public boolean updateBlogContent(String blogId, String blogContent){
        PreparedStatement ps = null;

        String sql = "update  blogcontent set blogContent=? where blogId=?";
        try {
            Connection conn = DBUtil.getConn();
            ps = conn.prepareStatement(sql);
            ps.setString(1,blogContent);
            ps.setString(2,blogId);

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
