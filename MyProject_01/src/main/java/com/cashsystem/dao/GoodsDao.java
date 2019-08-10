package com.cashsystem.dao;

import com.cashsystem.entity.Goods;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GoodsDao extends BaseDao{
    public List<Goods> quarryAllGoods() {
        Connection connection = null;//连接数据可
        ResultSet resultSet = null;//
        PreparedStatement preparedStatement = null;//预处理你的sql语句

        List<Goods> list = new ArrayList<>();
        try {
             connection = this.getConnection(true);
             String strSql = "select id,name,introduce,stock,unit,price,discount from goods";

             preparedStatement = connection.prepareStatement(strSql);
             resultSet = preparedStatement.executeQuery();
             while (resultSet.next()){
                 Goods goods = this.extractGoods(resultSet);
                 if (goods != null){
                     list.add(goods);
                 }
             }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }
    public Goods extractGoods(ResultSet resultSet) throws SQLException {
        Goods goods = new Goods();
        goods.setId(resultSet.getInt("id"));
        goods.setName(resultSet.getString("name"));
        goods.setIntroduce(resultSet.getString("introduce"));
        goods.setStock(resultSet.getInt("stock"));
        goods.setUnit(resultSet.getString("unit"));
        goods.setPrice(resultSet.getInt("price"));
        goods.setDiscount(resultSet.getInt("discount"));
        return goods;
    }

    public boolean putAwayGoods(Goods goods){
        Connection connection = null;//连接数据可
        ResultSet resultSet = null;//
        PreparedStatement preparedStatement = null;//预处理你的sql语句
        boolean effect = false;

        try{
            connection = this.getConnection(true);
            String strSql = "insert into goods(name,introduce,stock,unit,price,discount) values(?,?,?,?,?,?)";

            preparedStatement = connection.prepareStatement(strSql,Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1,goods.getName());
            preparedStatement.setString(2,goods.getIntroduce());
            preparedStatement.setInt(3,goods.getStock());
            preparedStatement.setString(4,goods.getUnit());
            preparedStatement.setInt(5,goods.getPrice());
            preparedStatement.setInt(6,goods.getDiscount());

            effect = (preparedStatement.executeUpdate() == 1);

            resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()){
                Integer id = resultSet.getInt(1);
                goods.setId(id);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            this.closeResource(resultSet,preparedStatement,connection);
        }
        return effect;
    }

    public Goods getGoods(int goodsId){
        Connection connection = null;//连接数据可
        ResultSet resultSet = null;//
        PreparedStatement preparedStatement = null;//预处理你的sql语句

        Goods goods = null;
        try{
            connection = this.getConnection(true);
            String strSql = "select * from goods where id=?";
            preparedStatement = connection.prepareStatement(strSql);

            preparedStatement.setInt(1,goodsId);

            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                goods = this.extractGoods(resultSet);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            this.closeResource(resultSet,preparedStatement,connection);
        }
        return goods;
    }
    public boolean modifyGoods(Goods goods){
        Connection connection = null;//连接数据可
        PreparedStatement preparedStatement = null;//预处理你的sql语句
        boolean effect = false;
        try{
            connection = this.getConnection(true);
            String strSql = "update goods set name=?,introduce=?,stock=?,unit=?,price=?,discount=? where id=?";
            preparedStatement = connection.prepareStatement(strSql);
            preparedStatement.setString(1,goods.getName());
            preparedStatement.setString(2,goods.getIntroduce());
            preparedStatement.setInt(3,goods.getStock());
            preparedStatement.setString(4,goods.getUnit());
            preparedStatement.setInt(5,goods.getPrice());
            preparedStatement.setInt(6,goods.getDiscount());
            preparedStatement.setInt(7,goods.getId());
            effect = (preparedStatement.executeUpdate() == 1);

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            this.closeResource(null,preparedStatement,connection);
        }
        return effect;
    }
    public boolean SoldOutGoods(Goods goods){
        Connection connection = null;//连接数据可
        ResultSet resultSet = null;//
        PreparedStatement preparedStatement = null;//预处理你的sql语句
        boolean effect = false;

        try{
            connection = this.getConnection(true);
            String strSql = "delete from goods where id=?";
            preparedStatement = connection.prepareStatement(strSql);
            preparedStatement.setInt(1,goods.getId());

            effect = (preparedStatement.executeUpdate() == 1);

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            this.closeResource(null,preparedStatement,connection);
        }
        return effect;
    }

    public boolean updateAfterPay(Goods goods,int GoodsBuyNum){
        Connection connection = null;//连接数据可
        PreparedStatement preparedStatement = null;//预处理你的sql语句
        boolean effect =false;
        try{
            connection = this.getConnection(true);
            String sql = "update goods set stock=? where id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,goods.getStock()-GoodsBuyNum);
            preparedStatement.setInt(2,goods.getId());

            if (preparedStatement.executeUpdate() == 1){
                effect = true;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            this.closeResource(null,preparedStatement,connection);
        }
        return effect;
    }
}

