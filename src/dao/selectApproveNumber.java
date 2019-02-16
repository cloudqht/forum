package dao;

import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Cloudqht on 2018/3/29.
 */
public class selectApproveNumber {
    public int SAN(int blogId){
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select approve from blogcontent where blogid = ?";
        int nb = 0;
        try {
            Connection conn = DBUtil.getConn();
            ps = conn.prepareStatement(sql);

            ps.setInt(1,blogId);
            rs = ps.executeQuery();

            while (rs.next()){

                nb = rs.getInt(1);
            }
            return nb;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nb;
    }
}
