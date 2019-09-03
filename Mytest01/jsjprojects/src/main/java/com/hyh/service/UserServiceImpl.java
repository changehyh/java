package com.hyh.service;

import com.hyh.dao.UserDao;
import com.hyh.po.Orders;
import com.hyh.po.OrdersEx;
import com.hyh.po.User;

import java.util.List;

public class UserServiceImpl implements UserService{
    private UserDao userDao;

    public UserServiceImpl(){
        this.userDao = new UserDao();
    }
    @Override
    public List<User> queryUserList() throws Exception {
        return this.userDao.queryUserList();
    }

    @Override
    public List<OrdersEx> queryOrderList() throws Exception {
        return this.userDao.queryOrderList();
    }
}
