package com.hyh;

import com.hyh.mapper.OrdersMapper;
import com.hyh.po.Orders;
import com.hyh.po.OrdersEx;
import com.hyh.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MyBatisTest2 {

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
    public void testQueryOrderToUser(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);
            List<OrdersEx> ordersExList = ordersMapper.queryOrderToUser();
            System.out.println(ordersExList);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }


    @Test
    public void testQueryOrderToUser2(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);
            List<Orders> ordersExList = ordersMapper.queryOrderToUser2();
            System.out.println(ordersExList);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }


    @Test
    public void testQueryOrderToOrderdetail(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);
            List<Orders> ordersExList = ordersMapper.queryOrderToOrderdetail();
            System.out.println(ordersExList);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }


    @Test
    public void testQueryOrderToItems(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);
            List<Orders> ordersExList = ordersMapper.queryOrderToItems();
            System.out.println(ordersExList);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Test
    public void testQueryUserToItems(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);
            List<User> userList = ordersMapper.queryUserToItems();
            System.out.println(userList);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

}
