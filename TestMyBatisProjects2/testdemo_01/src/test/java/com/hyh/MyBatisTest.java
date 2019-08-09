package com.hyh;

import com.hyh.mapper.OrdersMapper;
import com.hyh.mapper.UserMapper;
import com.hyh.pack.UserPack;
import com.hyh.po.User;
import com.hyh.po.UserEx;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MyBatisTest {

    private SqlSessionFactory sqlSessionFactory = null;

    @Before
    public void testInfo(){
        String file = "sqlMapConfig.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(file);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Test
    public void testQueryUserByZH(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            UserEx userEx = new UserEx();
            userEx.setSex("2");
            userEx.setUsername("vin");
            UserPack userPack = new UserPack();
            userPack.setUserPack(userPack);
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<UserEx> userExList = userMapper.queryUserZH(null);
            System.out.println(userExList);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Test
    public void testQueryUserCount(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            UserPack userPack = new UserPack();
            userPack.setUserPack(userPack);
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            int flag =  userMapper.queryUserCount(null);
            System.out.println(flag);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Test
    public void testQueryUserByMoreIds(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            List<Integer> ids = new ArrayList<Integer>();
            ids.add(24);
            ids.add(25);
            ids.add(26);
            UserPack userPack = new UserPack();
            userPack.setMoreIds(ids);
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<UserEx> userExList = userMapper.queryUserByMoreIds(userPack);
            System.out.println(userExList);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
