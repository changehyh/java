package com.hyh.po;

import java.util.List;

public class User {
    private int userId;
    private String userName;
    private String userAddr;

    private List<User> orders;

    public List<User> getOrders() {
        return orders;
    }

    public void setOrders(List<User> orders) {
        this.orders = orders;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAddr() {
        return userAddr;
    }

    public void setUserAddr(String userAddr) {
        this.userAddr = userAddr;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userAddr='" + userAddr + '\'' +
                ", orders=" + orders +
                '}';
    }
}
