package com.hyh.tools;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;

import java.util.Properties;


public class DbConfig {
    //获取数据连接
    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;
    ClassLoader classLoader = DbConfig.class.getClassLoader();

    public Connection getConnection() throws IOException {

        InputStream in = classLoader.getResourceAsStream("db.properties");
        Properties p = new Properties();
        p.load(in);
        String driver = p.getProperty("jdbc.driver");
        String url = p.getProperty("jdbc.url");
        String username = p.getProperty("jdbc.username");
        String password = p.getProperty("jdbc.password");
        try {
            Class.forName(driver);
             connection = DriverManager.getConnection(url,username,password);
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ResultSet querySomeList(String strSql)  {
        try {
            connection = this.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(strSql);
            return resultSet;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultSet;
    }
}
