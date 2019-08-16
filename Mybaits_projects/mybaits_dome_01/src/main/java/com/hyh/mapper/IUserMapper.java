package com.hyh.mapper;

import com.hyh.po.User;

import java.util.List;

public interface IUserMapper {
    public User queryUserById(int myId) throws Exception;

    public List<User> queryUserByName(String myStr) throws Exception;

    public void addUser(User user) throws Exception;

    public void modifyUser(User user) throws Exception;

    public void delUser(int myInt) throws Exception;

}
