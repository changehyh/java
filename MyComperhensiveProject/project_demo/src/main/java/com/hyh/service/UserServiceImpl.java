package com.hyh.service;

import com.hyh.dao.UserDAO;
import com.hyh.po.User;
import com.hyh.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public List<User> queryUserService() throws Exception {
        return userDAO.queryUserDAO();
    }
}
