package com.hyh.controller;

import com.hyh.po.Orders;
import com.hyh.po.OrdersEx;
import com.hyh.po.User;
import com.hyh.service.UserService;
import com.hyh.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/showOrder")
public class OrderController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //2、调用业务逻辑 M(Service)
        UserService userService = new UserServiceImpl();

        try {
            List<OrdersEx> ordersExList = userService.queryOrderList();
            req.setAttribute("orderListKey",ordersExList);
            //3、转向
            req.getRequestDispatcher("orders.jsp").forward(req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}