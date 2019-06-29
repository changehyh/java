package com.github.changehyh;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author: secondriver
 * Created: 2019/6/24
 */
public class jdbcCase4 {

    public static void main(String[] args) {

        //C++
        // name='  C++       '
        // name=' ' or 1=1 or name=' '
        // name in ("'Java', 'C++'")
        // in 不支持？表示多参数，字符串拼接，参数校验
        List<Map<String, Object>> data = queryMemoGroupByName("'Java', 'C++'");

        for (Map<String, Object> item : data) {
            System.out.println(item);
        }
    }


    public static List<Map<String, Object>> queryMemoGroupByName(String groupName) {
        List<Map<String, Object>> list = new ArrayList<>();
        try {
            //1.
            Class.forName("com.mysql.jdbc.Driver");
            //2. JDBC url协议
            String url = "jdbc:mysql://127.0.0.1:3306/memo?user=root&password=hyh1017";

            String sql = "select id,name,created_time,modify_time from memo_group where name in (?) ";

            //try-with-resource的方式关闭结果集，命令，连接
            try (
                    Connection connection = DriverManager.getConnection(url);
                    //通过Connection对象，根据参数化的SQL获取与编译命令
                    PreparedStatement statement = connection.prepareStatement(sql);

            ) {
                //参数赋值，下标从1开始（切记）
                statement.setString(1,groupName);;

                try (
                        ResultSet resultSet = statement.executeQuery()) {//预编译命令直接进行查询


                    //6.
                    while (resultSet.next()) {
                        int id = resultSet.getInt("id");
                        String name = resultSet.getString("name");
                        Timestamp createTime = resultSet.getTimestamp("created_time");
                        Timestamp modifyTime = resultSet.getTimestamp("modify_time");
                        Map<String, Object> row = new HashMap<>();
                        row.put("id", id);
                        row.put("name", name);
                        row.put("created_time", createTime);
                        row.put("modify_time", modifyTime);
                        list.add(row);
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
