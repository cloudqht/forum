package dao;

import com.google.gson.Gson;
import domain.blogInfo;
import domain.forumInfo;
import domain.userInfo;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cloudqht on 2018/3/23.
 */
public class getBlogData {
    public String getALLData(){

        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from blogcontent";
        List<forumInfo> list = new ArrayList<forumInfo>();

        try {
            Connection conn = DBUtil.getConn();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()){

                forumInfo forumInfo = new forumInfo();
                blogInfo blogInfo = new blogInfo();
                userInfo userInfo = new userInfo();
                userInfo.setUserID(rs.getString(1));
                userInfo.setUserName(rs.getString(2));
                userInfo.setUserHead(rs.getString(3));
                blogInfo.setBlogTitle(rs.getString(4));
                blogInfo.setBlogContent(rs.getString(5));
                blogInfo.setUserComment(rs.getString(6));
                blogInfo.setApprove(rs.getInt(7));
                String imgUrlStr = (rs.getString(8));
                blogInfo.setBlogId(rs.getInt(9));
                blogInfo.setTime(rs.getString(10));

                //String [] imgUrl = imgUrlStr.split("|");
//                imgUrlStr = imgUrlStr.replace("\"","");
//                imgUrlStr = imgUrlStr.replace("[","");
//                imgUrlStr = imgUrlStr.replace("","");
                forumInfo.setUserInfo(userInfo);
                forumInfo.setBlogInfo(blogInfo);
                forumInfo.setImgUrl(imgUrlStr);
                list.add(forumInfo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        return gson.toJson(list);
     }
}
