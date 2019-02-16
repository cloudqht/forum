package servlet;

import com.google.gson.Gson;
import dao.getBlogData;
import dao.initBlog;
import dao.updateBlog;
import domain.userInfo;
import org.apache.commons.lang.StringUtils;
import util.openIdUtil;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Cloudqht on 2018/3/21.
 */
public class forumServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
//        getBlogData gbd = new getBlogData();
//        String jsonUser = gbd.getALLData();
        String openId = request.getParameter("openid");
        String session_key = request.getParameter("session_key");
        String nickName = request.getParameter("nickName");
        String userCity = request.getParameter("userCity");
        String blogTitle = request.getParameter("blogTitle");
        String blogContent = request.getParameter("blogContent");
        String imgUrls[] = request.getParameterValues("imgUrls");
        String avatarUrl = request.getParameter("avatarUrl");
//        if (imgUrls==null||imgUrls.length==0){}
        String imgUrlStr = StringUtils.join(imgUrls,"|");
        String time = request.getParameter("time");
        String edit = request.getParameter("edit");

        if(edit.equals("Success")){
            String blogId = request.getParameter("blogId");
            updateBlog ub = new updateBlog();
            boolean i = ub.updateBlogInfo(blogId,blogContent,time,imgUrlStr,blogTitle);
            if (i){
                out.write(edit);

            }else
                out.write("failure");
        }
        else{if(openId==null||openId=="") {
            String code = request.getParameter("code");
            openIdUtil openIdUtil = new openIdUtil();
            String openId2 = openIdUtil.getUserOpenId(code);
            Gson gson = new Gson();
            initBlog initBlog = new initBlog();
            boolean i = initBlog.initblog(openId2,nickName,avatarUrl,blogTitle,blogContent,imgUrlStr,time);
            if (i){
                out.write("Success2");

            }else
                out.write("failure");

        }else{
            Gson gson = new Gson();
            initBlog initBlog = new initBlog();
            boolean i = initBlog.initblog(openId,nickName,avatarUrl,blogTitle,blogContent,imgUrlStr,time);
            if (i){
                out.write("Success2");

            }else
                out.write("failure");}}

    }
}
