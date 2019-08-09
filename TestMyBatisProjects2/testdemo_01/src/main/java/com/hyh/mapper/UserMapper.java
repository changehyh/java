package com.hyh.mapper;

import com.hyh.pack.UserPack;
import com.hyh.po.User;
import com.hyh.po.UserEx;

import java.util.List;

public interface UserMapper {

    public List<UserEx> queryUserZH (UserPack userPack) throws Exception;
    public int queryUserCount(UserPack userPack) throws Exception;
    public List<UserEx> queryUserByMoreIds(UserPack userPack) throws Exception;
}
