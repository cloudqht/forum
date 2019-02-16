package dao;

import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Cloudqht on 2018/3/29.
 */
public class changeApproveNumber {
    public void CAN(int blogId){
        PreparedStatement ps = null;
        //ResultSet rs = null;
        String sql = "update blogcontent set approve = approve + 1 where blogid=?";
        int nb = 0;
        try {
            Connection conn = DBUtil.getConn();
            ps = conn.prepareStatement(sql);

            ps.setInt(1,blogId);
            ps.executeUpdate();


            //return nb;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // return nb;
    }
    public void DAN(int blogId){
        PreparedStatement ps = null;
        //ResultSet rs = null;
        String sql = "update blogcontent set approve = approve - 1 where blogid=?";
        int nb = 0;
        try {
            Connection conn = DBUtil.getConn();
            ps = conn.prepareStatement(sql);

            ps.setInt(1,blogId);
            ps.executeUpdate();
            //selectApproveNumber selectApproveNumber = new selectApproveNumber();
            //nb = selectApproveNumber.SAN(blogId);


            //return nb;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // return nb;
    }
}
