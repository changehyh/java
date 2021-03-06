package com.hyh.servlet;

import com.hyh.model.IUserInfoService;
import com.hyh.model.UserInfoServiceImpl;
import com.hyh.vo.UserInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        //1获取表单参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UserInfo userInfo = new UserInfo();
        userInfo.setUserName(username);
        userInfo.setUserPass(password);

        //2调用业务逻辑 M(Service)
        IUserInfoService userInfoService = new UserInfoServiceImpl();
        int flag = userInfoService.checkUserInfoService(userInfo);

        if(flag == 1){
            //3转向
            request.setAttribute("userinfokey",userInfo);
            request.getRequestDispatcher("success.jsp").forward(request,response);
        }else{
            request.getRequestDispatcher("failure.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
