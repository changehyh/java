package com.hyh.model;

import com.hyh.dao.UserInfoDAO;
import com.hyh.vo.UserInfo;

public class UserInfoServiceImpl implements IUserInfoService{
    private UserInfoDAO userInfoDAO = new UserInfoDAO();
    public int checkUserInfoService(UserInfo userInfo) {
        return userInfoDAO.checkUserInfo(userInfo);
    }
}
