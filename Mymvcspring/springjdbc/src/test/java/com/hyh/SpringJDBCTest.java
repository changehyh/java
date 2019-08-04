package com.hyh;

import com.hyh.vo.Employee;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class SpringJDBCTest {
    private ApplicationContext context = null;
    private JdbcTemplate jdbcTemplate = null;

    @Before
    public void testInit() {
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
    }
    @Test
    //检测是否连接到数据库
    public void testDataSource(){
        DataSource dataSource =(DataSource) context.getBean("myDataSource");
        System.out.println("dataSource" + dataSource);
    }
    @Test
    public void testUpdataForSpringJDBC(){
        int flag = 0;
        try {
            jdbcTemplate = (JdbcTemplate)context.getBean("jdbcTemplate");
            String steSql =  "update employee set employeeName=? where employeeId=?";
            flag = jdbcTemplate.update(steSql,"HYH",1);
            System.out.println("flag = " + flag);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    @Test
    public void testInsertForSpringJDBC(){
        try {
            jdbcTemplate = (JdbcTemplate) context.getBean("jdbcTemplate");
            String strSql = "insert into employee (employeeName,departNum) values (?,?)";
            List<Object[]> listObjects = new ArrayList<Object[]>();
            listObjects.add(new Object[]{"arvin", 1});
            listObjects.add(new Object[]{"hyh", 1});
            listObjects.add(new Object[]{"meme", 2});
            jdbcTemplate.batchUpdate(strSql, listObjects);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    @Test
    public void testQueryForSpringJDBC(){
        try{
            jdbcTemplate = (JdbcTemplate)context.getBean("jdbcTemplate");
            String strSql = "select * from employee where employeeId=?";
            RowMapper rowMapper = new BeanPropertyRowMapper(Employee.class);
            Employee employee = (Employee)jdbcTemplate.queryForObject(strSql,rowMapper,4);
            System.out.println(employee);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
