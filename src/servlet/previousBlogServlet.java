package servlet;

import dao.getBlogData;
import dao.getPreviousData;
import util.openIdUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Cloudqht on 2018/3/24.
 */
@WebServlet(name = "previousBlogServlet")
public class previousBlogServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        String openId = request.getParameter("openid");
        if(openId==null||openId==""){
        String code = request.getParameter("code");
        openIdUtil openIdUtil = new openIdUtil();
        String openId2 = openIdUtil.getUserOpenId(code);
        getPreviousData getPreviousData = new getPreviousData();
        String forumJson = getPreviousData.getUserPrevious(openId2);

        out.write(forumJson);}
        else {
            getPreviousData getPreviousData = new getPreviousData();
            String forumJson = getPreviousData.getUserPrevious(openId);
            out.write(forumJson);
        }


    }
}
