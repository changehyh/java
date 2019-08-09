package com.hyh.mapper;

import com.hyh.pack.OrderPack;
import com.hyh.po.Orders;
import com.hyh.po.OrdersEx;
import com.hyh.po.User;

import java.util.List;

public interface OrdersMapper {

    public List<OrdersEx> queryOrderToUser() throws Exception;

    public List<Orders> queryOrderToUser2() throws Exception;

    public List<Orders> queryOrderToOrderdetail() throws Exception;

    public List<Orders> queryOrderToItems() throws Exception;

    public List<User> queryUserToItems() throws  Exception;
}
