package com.hyh;

import com.hyh.mapper.IUserMapper;
import com.hyh.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class MybatisTest2 {
    private SqlSessionFactory sqlSessionFactory = null;

    @Before
    public void testInit(){
        String file = "sqlMapConfig.xml";
        InputStream in = null;
        try{
            in = Resources.getResourceAsStream(file);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Test
    public void testQueryUserById(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try{
            IUserMapper iUserMapper = sqlSession.getMapper(IUserMapper.class);
            System.out.println(iUserMapper.queryUserById(4));
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }
    @Test
    public void testQueryUserByName(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try{
            IUserMapper iUserMapper = sqlSession.getMapper(IUserMapper.class);
            System.out.println(iUserMapper.queryUserByName("vin"));
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }
    @Test
    public void testAddUser(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try{
            IUserMapper iUserMapper = sqlSession.getMapper(IUserMapper.class);
            User user = new User();
            user.setUserName("Alice");
            user.setUserAddr("Beijing");
            iUserMapper.addUser(user);
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void testModifyUser(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try{
            IUserMapper iUserMapper = sqlSession.getMapper(IUserMapper.class);
            User user = new User();
            user.setUserId(9);
            user.setUserName("TOM");
            user.setUserAddr("America");
            iUserMapper.modifyUser(user);
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void testDelUser(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try{
            IUserMapper iUserMapper = sqlSession.getMapper(IUserMapper.class);
            iUserMapper.delUser(2);
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }
}
