package com.hyh.dao;

import com.hyh.vo.Goods;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GoodsDao extends BaseDao{
    //浏览商品，
    public List<Goods> queryAllGoods() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Goods> goodsList = new ArrayList<>();
        try{
            connection = this.getConnection(true);
            String sql = "select id,name,introduce,stock,unit,price,discount from goods";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Goods goods = this.extractGoods(resultSet);
                if (goods != null){
                    goodsList.add(goods);
                }
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            this.closeResource(resultSet,preparedStatement,connection);
        }
        return goodsList;
    }

    //将集合中的数据进行解析
    private Goods extractGoods(ResultSet resultSet) throws SQLException {
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

    //上架商品
    public boolean putAwayGoods(Goods goods){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        boolean effect = false;
        try {
            String sql = "insert into goods (name,introduce,stock,unit,price,discount) values (?,?,?,?,?,?);";
            connection = this.getConnection(true);
            preparedStatement = connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,goods.getName());
            preparedStatement.setString(2,goods.getIntroduce());
            preparedStatement.setInt(3,goods.getStock());
            preparedStatement.setString(4,goods.getUnit());
            preparedStatement.setInt(5,goods.getPrice());
            preparedStatement.setInt(6,goods.getDiscount());

            effect = preparedStatement.executeUpdate() ==1;
            resultSet = preparedStatement.getGeneratedKeys();

            if (resultSet.next()){
                goods.setId(resultSet.getInt(1));
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            this.closeResource(resultSet,preparedStatement,connection);
        }
        return effect;
    }
    //根据ID查询商品
    public Goods getGoods(int goodsId){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            String sql = "select id,name,introduce,stock,unit,price,discount from goods where id=?";
            connection = this.getConnection(true);
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,goodsId);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                return extractGoods(resultSet);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            this.closeResource(resultSet,preparedStatement,connection);
        }
        return null;
    }

    //下架商品
    public boolean soldOutGoods(int goodsId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
//        ResultSet resultSet = null;
        try{
            String sql = "delete from goods where id=?";
            connection =this.getConnection(true);
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,goodsId);
            return preparedStatement.executeUpdate()==1;
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            this.closeResource(null,preparedStatement,connection);
        }
        return false;
    }

    //更新商品
    public boolean updateGoods(Goods goods) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try{
            String sql = "update goods set name=? , introduce =?,  stock=? , price=?, discount =? where  id= ?";
            connection = this.getConnection(true);
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,goods.getName());
            preparedStatement.setString(2,goods.getIntroduce());
            preparedStatement.setInt(3,goods.getStock());
            preparedStatement.setInt(4,goods.getPrice());
            preparedStatement.setInt(5,goods.getDiscount());
            preparedStatement.setInt(6,goods.getId());
            return preparedStatement.executeUpdate()==1;

        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            this.closeResource(null,preparedStatement,connection);
        }
        return false;
    }

    public boolean updateGoodsAfterPay(Goods goods, int goodsId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try{
            String sql = "update goods set stock=? where id=?";
            connection = this.getConnection(true);
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,goods.getStock()-goodsId);
            preparedStatement.setInt(2,goods.getId());
            return preparedStatement.executeUpdate()==1;
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            this.closeResource(null,preparedStatement,connection);
        }
        return false;
    }
}
