package com.hyh;

import com.hyh.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import javax.jws.soap.SOAPBinding;
import java.io.InputStream;
import java.util.List;


public class MybatisTest {
    private SqlSessionFactory sqlSessionFactory = null;

    @Before
    public void testInit(){
        String file = "sqlMapConfig.xml";
        InputStream is = null;
        try{
            is = Resources.getResourceAsStream(file);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    @Test
    public void  testQueryUserById(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try{
            User user = sqlSession.selectOne("test.queryUserById",5);
            System.out.println(user);
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }
    @Test
    public void  testQueryUserByName(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try{
            List<User> userList = sqlSession.selectList("test.queryUserByName","vin");

            System.out.println(userList);
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void  testAddUser(){
        int flag = 0;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try{
            User user = new User();
            user.setUserName("MonkeyFather");
            user.setUserAddr("LT");
            flag = sqlSession.insert("test.addUser",user);
            sqlSession.commit();
            System.out.println("flag = " + flag);
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void testMofiyUser(){
        int flag = 0;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            // how do i to do it?
            User user = new User();
            user.setUserId(18); // id is must
            user.setUserName("Animal2");
            user.setUserAddr("LT");
            flag = sqlSession.update("test.modifyUser",user);
            sqlSession.commit();//commit transaction
            System.out.println("flag = " + flag);

        }catch (Exception ex){
            sqlSession.rollback();
            ex.printStackTrace();
        }finally{
            sqlSession.close();
        }
    }
    @Test
    public void testDelUser(){
        int flag = 0;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try{
            flag = sqlSession.delete("test.delUser",1);
            sqlSession.commit();
            System.out.println("flag = " + flag);
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }
}
