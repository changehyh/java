package com.hyh.dao;

import com.hyh.po.User;
import com.hyh.tools.DbManager;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


@Component
public class UserDAO {

    public List<User> queryUserDAO(){
        List<User> userList = new ArrayList<User>();
        try {
            String strSql = "select * from user";
            ResultSet rs = new DbManager().queryExecute(strSql);
            while(rs.next()){
                User user = new User();
                user.setUserId(rs.getInt("userid"));
                user.setUserName(rs.getString("username"));
                user.setUserAddr(rs.getString("useraddr"));
                userList.add(user);
            }
            return userList;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return userList;
    }
}
