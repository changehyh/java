package com.hyh.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/controller")
public class Controller extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //1，获取表单参数
        String username = req.getParameter("username");
        if (username.equals("showUser")) {
            UserController userController = new UserController();
            userController.doPost(req,resp);
        } else if (username.equals("showOrder")) {
            OrderController orderController = new OrderController();
            orderController.doPost(req, resp);
        }
    }
}
