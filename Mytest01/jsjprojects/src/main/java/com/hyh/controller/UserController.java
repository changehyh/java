package com.hyh.controller;

import com.hyh.po.User;
import com.hyh.service.UserService;
import com.hyh.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


@WebServlet(urlPatterns = "/showUser")
public class UserController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //2、调用业务逻辑 M(Service)
        UserService userService = new UserServiceImpl();

        try {
            List<User> userList = userService.queryUserList();
            req.setAttribute("userListKey",userList);
            //3、转向
            req.getRequestDispatcher("jsj.jsp").forward(req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
