package com.hyh.dao;

import com.hyh.tools.DbManager;
import com.hyh.vo.UserInfo;

import java.sql.ResultSet;

public class UserInfoDAO {
    public int checkUserInfo(UserInfo userInfo){
        int flag = 0;
        String strSql = "select employeeName,employeeId from employee where " +
                "employeeName='"+userInfo.getUserName()+"' " +
                "and employeeId='"+userInfo.getUserPass()+"'";
        try {
            DbManager dbManager = new DbManager();
            ResultSet rs = dbManager.queryMethod(strSql);
            String username = null;
            String password = null;
            while (rs.next()) {
                username = rs.getString("employeeName");
                password = rs.getString("employeeId");
                if (username.equals(userInfo.getUserName()) && password.equals(userInfo.getUserPass())) {
                    flag = 1;
                    return flag;
                } else {
                    flag = 0;
                    return flag;
                }
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return flag;
    }
}
