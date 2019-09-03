package com.hyh.service;

import com.hyh.po.Orders;
import com.hyh.po.OrdersEx;
import com.hyh.po.User;

import java.util.List;

public interface UserService {
    public List<User> queryUserList() throws Exception;

    public List<OrdersEx> queryOrderList() throws Exception;
}
