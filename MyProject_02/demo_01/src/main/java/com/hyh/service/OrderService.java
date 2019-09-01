package com.hyh.service;

import com.hyh.dao.OrderDao;
import com.hyh.vo.Order;

import java.util.List;

public class OrderService {

    private OrderDao orderDao;

    public OrderService(){
        this.orderDao = new OrderDao();
    }

    public boolean commitOrder(Order order) {
        return orderDao.commitOrder(order);
    }

    public List<Order> queryOrderByAccount(Integer accountId) {
        return this.orderDao.queryOrderByAccount(accountId);
    }
}
