package servlet;

import dao.changeApproveNumber;
import dao.getApproveFlag;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Cloudqht on 2018/3/29.
 */
@WebServlet(name = "approveServlet")
public class approveServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        String openId = request.getParameter("openId");
        int blogId = Integer.parseInt(request.getParameter("blogId"));
        String init = request.getParameter("init");
        getApproveFlag getApproveFlag = new getApproveFlag();
        if(init.equals("init")){

            int flag = getApproveFlag.getFlag(openId,blogId);
            String ff = String.valueOf(flag);
            out.write(ff);
        }else{
            int flag = getApproveFlag.getFlag(openId,blogId);
            if(flag!=1){
                changeApproveNumber changeApproveNumber = new changeApproveNumber();
                changeApproveNumber.CAN(blogId);
                getApproveFlag.addFlag(openId,blogId);
                out.write("1");
            }else {
                changeApproveNumber changeApproveNumber = new changeApproveNumber();
                changeApproveNumber.DAN(blogId);
                getApproveFlag.subFlag(openId,blogId);
                out.write("0");
            }
        }



    }
}
