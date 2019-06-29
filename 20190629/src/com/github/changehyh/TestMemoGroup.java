package com.github.changehyh;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.List;

public class TestMemoGroup {
    public static void main(String[] args) {
        MemoGroup memoGroup = new MemoGroup();
        memoGroup.setName("个人笔记");
        memoGroup.setCreatedTime(LocalDateTime.now());
        boolean rs  = createMemoGroup(memoGroup);
        if(rs){
            System.out.println("创建便签组成功");
        }else {
            System.out.println("创建便签组识别");
        }
    }
    public static boolean createMemoGroup(MemoGroup memoGroup) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/memo","root","hyh1017");
                PreparedStatement statement = connection.prepareStatement("insert into memo_group (name,created_time) values (?,?)");
                    ) {
                statement.setString(1, memoGroup.getName());
                statement.setTimestamp(2, Timestamp.valueOf(memoGroup.getCreatedTime()));

                int effect = statement.executeUpdate();
                return effect == 1;
                     }
            }catch (SQLException e){
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }
}
class MemoGroup{
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
                ", ceeatedTime=" + createdTime +
                ", modifyTime=" + modifyTime +
                '}';
    }
}