package com.github.changehyh;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: secondriver
 * Created: 2019/6/29
 */
public class jdbcCase5 {


    public static List<MemoGroup> queryMemoGroup(Integer id, String name) {
        List<MemoGroup> list = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/memo", "root", "hyh1017");
                 PreparedStatement statement = connection.prepareStatement("select id, name, created_time, modify_time from memo_group " +
                         "where name = ? or id = ?")

            ) {
                statement.setString(1, name);
                statement.setInt(2, id);

                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        MemoGroup memoGroup = new MemoGroup();
                        memoGroup.setId(resultSet.getInt("id"));
                        memoGroup.setName(resultSet.getString("name"));
                        memoGroup.setCreatedTime(resultSet.getTimestamp("created_time").toLocalDateTime());
                        memoGroup.setModifyTime(resultSet.getTimestamp("modify_time").toLocalDateTime());
                        list.add(memoGroup);


                    }

                }

            }


        } catch (SQLException e) {

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        return list;
    }


    public static boolean createMemoGroup(MemoGroup1 memoGroup) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/memo", "root", "root");
                 PreparedStatement statement = connection.prepareStatement("insert into memo_group (name, created_time) values(?,?)")

            ) {
                statement.setString(1, memoGroup.getName());
                statement.setTimestamp(2, Timestamp.valueOf(memoGroup.getCreatedTime()));

                int effect = statement.executeUpdate();
                return effect == 1;
            }
        } catch (SQLException e) {

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {
//        Integer id = 3;
//        String name = "Java";
//        List<MemoGroup> memoGroups = queryMemoGroup(id, name);
//        for (MemoGroup memoGroup : memoGroups) {
//            System.out.println(memoGroup);
//        }

        MemoGroup1 memoGroup = new MemoGroup1();
        memoGroup.setName("笔记");
        memoGroup.setCreatedTime(LocalDateTime.now());

        boolean rs  = createMemoGroup(memoGroup);
        if(rs){
            System.out.println("创建便签组成功");
        }else {
            System.out.println("创建便签组识别");
        }
    }
}

//跟数据库表关联的Java类称之为Entity类
class MemoGroup1 {

    private Integer id;
    private String name;
    private LocalDateTime createdTime;
    private LocalDateTime modifyTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public LocalDateTime getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
    }

    @Override
    public String toString() {
        return "MemoGroup{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createdTime=" + createdTime +
                ", modifyTime=" + modifyTime +
                '}';
    }
}