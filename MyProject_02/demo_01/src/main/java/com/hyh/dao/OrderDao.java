package com.hyh.dao;

import com.hyh.common.OrderStatus;
import com.hyh.vo.Order;
import com.hyh.vo.OrderItem;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDao extends BaseDao{

    public boolean commitOrder(Order order) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        String insertOrderSql = "insert into `order`" +
                "(id, account_id, create_time, finish_time, " +
                "actual_amount, total_money, order_status, " +
                "account_name) values (?,?,now(),now(),?,?,?,?)";
        String insertOrderItemSql = "insert into order_item" +
                "(order_id, goods_id, goods_name," +
                "goods_introduce, goods_num, goods_unit," +
                " goods_price, goods_discount) values (?,?,?,?,?,?,?,?)";
        //插入订单
        try{
            connection = this.getConnection(false);
            preparedStatement = connection.prepareStatement(insertOrderSql);
            preparedStatement.setString(1,order.getId());
            preparedStatement.setInt(2,order.getAccount_id());
            preparedStatement.setInt(3,order.getActual_amount());
            preparedStatement.setInt(4,order.getTotal_money());
            preparedStatement.setInt(5,order.getOrder_status().getFlg());
            preparedStatement.setString(6,order.getAccount_name());

            if (preparedStatement.executeUpdate()==0){
                throw new RuntimeException("插入订单失败");
            }

            preparedStatement = connection.prepareStatement(insertOrderItemSql);

            for (OrderItem orderItem :order.orderItemList){
                preparedStatement.setString(1,orderItem.getOrder_id());
                preparedStatement.setInt(2,orderItem.getGoods_id());
                preparedStatement.setString(3,orderItem.getGoods_name());
                preparedStatement.setString(4,orderItem.getGoods_introduce());
                preparedStatement.setInt(5,orderItem.getGoods_num());
                preparedStatement.setString(6,orderItem.getGoods_unit());
                preparedStatement.setInt(7,orderItem.getGoods_price());
                preparedStatement.setInt(8,orderItem.getGoods_discount());
                //批量执行sql语句
                // 将每一个preparedStatement 保存好
                preparedStatement.addBatch();
            }
            ///提交一批要执行的更新命令/批量操作数据库
            int[] effect = preparedStatement.executeBatch();
            for(int i :effect){
                if (i==0){
                    throw new RuntimeException("插入订单明细失败");
                }
            }
            connection.commit();
        }catch (Exception ex){
            ex.printStackTrace();
            if (connection!=null){
                try {
                    connection.rollback();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            return false;
        }finally {
            this.closeResource(null,preparedStatement,connection);
        }
        return true;
    }

    public List<Order> queryOrderByAccount(Integer accountId) {

        List<Order> orderList = new ArrayList<>();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try{
            connection = this.getConnection(false);
            String sql = this.getSql("@query_order_by_account");

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1,accountId);
            //根据accountId 进行查询数据库结果 到resultSet 集合当中
            resultSet = preparedStatement.executeQuery();

            Order order = null;
            while (resultSet.next()){
                if (order == null){
                    order = new Order();
                    this.extractOrder(order,resultSet);
                    orderList.add(order);
                }
                String orderId = resultSet.getString("order_id");
                //不相同重新生成一个订单对象 添加到订单的List
                if (!orderId.equals(order.getId())){
                    order = new Order();
                    this.extractOrder(order,resultSet);
                    orderList.add(order);
                }
                //往当前订单内添加 具体的订单项 orderItem
                OrderItem orderItem = this.extractOrderItem(resultSet);
                order.getOrderItemList().add(orderItem);
            }
        }catch (Exception ex){
            ex.printStackTrace();
            if (connection!=null){
                try {
                    connection.rollback();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }finally {
            this.closeResource(resultSet,preparedStatement,connection);
        }
        return orderList;
    }

    private OrderItem extractOrderItem(ResultSet resultSet) throws SQLException {
        OrderItem orderItem = new OrderItem();
        orderItem.setId(resultSet.getInt("item_id"));
        orderItem.setGoods_id(resultSet.getInt("goods_id"));
        orderItem.setGoods_name(resultSet.getString("goods_name"));
        orderItem.setGoods_introduce(resultSet.getString("goods_introduce"));
        orderItem.setGoods_num(resultSet.getInt("goods_num"));
        orderItem.setGoods_unit(resultSet.getString("goods_unit"));
        orderItem.setGoods_price(resultSet.getInt("goods_price"));
        orderItem.setGoods_discount(resultSet.getInt("goods_discount"));
        return orderItem;
    }

    private void extractOrder(final Order order, ResultSet resultSet) throws SQLException {
        order.setId(resultSet.getString("order_id"));
        order.setAccount_id(resultSet.getInt("account_id"));
        order.setAccount_name(resultSet.getString("account_name"));
        order.setCreate_time(resultSet.getTimestamp("create_time").toLocalDateTime());
        Timestamp finishTime = resultSet.getTimestamp("finish_time");
        if (finishTime != null) {
            order.setFinish_time(finishTime.toLocalDateTime());
        }
        order.setActual_amount(resultSet.getInt("actual_amount"));
        order.setTotal_money(resultSet.getInt("total_money"));
        order.setOrder_status(OrderStatus.valueOf(resultSet.getInt("order_status")));

    }
}
