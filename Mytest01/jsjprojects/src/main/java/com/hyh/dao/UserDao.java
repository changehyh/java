package com.hyh.dao;

import com.hyh.po.Orders;
import com.hyh.po.OrdersEx;
import com.hyh.po.User;
import com.hyh.tools.DbConfig;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    public List<User> queryUserList(){

        String sql = "select * from user";
        try {
            DbConfig dbConfig = new DbConfig();
            ResultSet  resultSet = dbConfig.querySomeList(sql);
            List<User> userList = new ArrayList<>();
            while (resultSet.next()){
                User user = new User();
                user.setUserId(resultSet.getInt("id"));
                user.setUserName(resultSet.getString("user_name"));
                user.setUserAddr(resultSet.getString("user_addr"));
                userList.add(user);
            }
            return userList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<OrdersEx> queryOrderList() {
        String sql = "select\n" +
                "    orders.*,\n" +
                "    user.user_name,\n" +
                "    user.user_addr\n" +
                "from\n" +
                "    orders,\n" +
                "    user\n" +
                "where\n" +
                "    orders.user_id = user.id";
        try {
            DbConfig dbConfig = new DbConfig();
            ResultSet  resultSet = dbConfig.querySomeList(sql);
            List<OrdersEx> ordersExList = new ArrayList<OrdersEx>();
            while (resultSet.next()){
                OrdersEx ordersEx = new OrdersEx();
                ordersEx.setId(resultSet.getInt("id"));
                ordersEx.setUser_id(resultSet.getInt("user_id"));
                ordersEx.setNumber(resultSet.getString("number"));
                ordersEx.setNote(resultSet.getString("note"));
                ordersEx.setUserName(resultSet.getString("user_name"));
                ordersEx.setUserAddr(resultSet.getString("user_addr"));
                ordersExList.add(ordersEx);
            }
            return ordersExList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
