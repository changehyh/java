package com.hyh.util;

import com.hyh.exception.SystemException;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDao {

    private static final String URL = "jdbc:mysql://localhost:3306/blogdemo";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "hyh1017";

    private static volatile DataSource dataSource;

    private BaseDao(){

    }

    //类的加载机制
    public static DataSource getDataSource(){
        if (dataSource == null){
//          synchronized (dataSource.getClass()){
//          synchronized (dataSource){
            synchronized (BaseDao.class){
                if (dataSource == null){
                    dataSource = new MysqlDataSource();//对象的产生需要三步
                    ((MysqlDataSource) dataSource).setUrl(URL);
                    ((MysqlDataSource) dataSource).setUser(USER_NAME);
                    ((MysqlDataSource) dataSource).setPassword(PASSWORD);
                }
            }
        }
        return dataSource;
    }

    public static Connection getConnection() {
        try {
            return getDataSource().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void close(Connection connection,
                             PreparedStatement preparedStatement,
                             ResultSet resultSet){
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null){
                preparedStatement.close();
            }
            if (connection != null){
                connection.close();
            }
        } catch (SQLException e) {
           e.printStackTrace();
           throw new SystemException("数据库异常");
        }
    }
}
