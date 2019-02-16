package dao;

import domain.blogInfo;
import domain.forumInfo;
import domain.userInfo;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Cloudqht on 2018/3/29.
 */

public class getApproveFlag {

    public int getFlag(String openId, int blogId){
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select flag from approve where userid=? and blogid=?";
        String initSql =  "insert into approve values(?,?,?)";
        int flag = 0;
        try {
            Connection conn = DBUtil.getConn();
            ps = conn.prepareStatement(sql);
            ps.setString(1,openId);
            ps.setInt(2,blogId);
            rs = ps.executeQuery();

            if (!rs.next()){
                ps = conn.prepareStatement(initSql);
                ps.setInt(1,blogId);
                ps.setString(2,openId);
                ps.setInt(3,flag);
                ps.executeUpdate();
                System.out.println("kkkkk");
                return flag;

            }else
            {
                System.out.println("rrrrrr");
                return rs.getInt(1);}
//                flag = rs.getInt(1);
//
//            return flag;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }
    public void addFlag(String openId, int blogId){
        PreparedStatement ps = null;
        //ResultSet rs = null;
        String sql = "update approve set flag= 1 where userid=? and blogid=?";

        try {
            Connection conn = DBUtil.getConn();
            ps = conn.prepareStatement(sql);
            ps.setString(1,openId);
            ps.setInt(2,blogId);
            ps.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void subFlag(String openId, int blogId){
        PreparedStatement ps = null;
        //ResultSet rs = null;
        String sql = "update approve set flag= 0 where userid=? and blogid=?";

        try {
            Connection conn = DBUtil.getConn();
            ps = conn.prepareStatement(sql);
            ps.setString(1,openId);
            ps.setInt(2,blogId);
            ps.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
