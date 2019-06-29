package com.github.changehyh;

import java.sql.*;

public class jdbcCase2 {

    /*
        1.加载数据库的JDBC驱动（JDBC API）+
        2.创建连接 +
        3.创建命令 +
        4.准备SQL语句
        5.执行SQL +
        6.处理结果 +
        7.关闭结果
        8.关闭命令
        9.关闭连接
     */
    public static void main(String[] args) {

        try {
            //1.
            Class.forName("com.mysql.jdbc.Driver");

            //2.JDBC url协议
            //jdbc:<databaseTape>:host:port/<databaseName>?<your user name>
            // =xxx&password=xxx
            //jdbc:mysql://127.0.0.1:3306/memo?user=root&password=hyh1017

            String url = "jdbc:mysql://127.0.0.1:3306/memo?user=root&password=hyh1017";

            String sql = "select id,name,created_time,modify_time from memo_group";

            //try-with-resource的方式关闭结果集，命令，连接
            try(
                    Connection connection = DriverManager.getConnection(url);
                 Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(sql);
                    ){
                //6.
                while (resultSet.next()){
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    Timestamp createTime = resultSet.getTimestamp("created_time");
                    Timestamp modifyTime = resultSet.getTimestamp("modify_time");
                    System.out.println(id + " " + name + " " +createTime + " " +modifyTime);
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
