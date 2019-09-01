package com.hyh.cmd.impl.order;

import com.hyh.cmd.Subject;
import com.hyh.cmd.annotation.CommandMete;
import com.hyh.cmd.annotation.CustomerCommand;
import com.hyh.cmd.impl.AbstractCommand;
import com.hyh.common.OrderStatus;
import com.hyh.vo.Goods;
import com.hyh.vo.Order;
import com.hyh.vo.OrderItem;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@CommandMete(
        name = "ZFDD",
        desc = "支付订单",
        group = "我的订单"
)
@CustomerCommand
public class OrderPayCommand extends AbstractCommand {
    @Override
    public void execute(Subject subject) {
        System.out.println("请输入你要购买的货物id以及数量，多个货物使用，隔开，格式1-8，3-5");
        String string = scanner.nextLine();
        String[] strings = string.split(",");

        List<Goods> goodsList = new ArrayList<>();

        for (String goodsString: strings){

            String[] strings1 = goodsString.split("-");

            Goods goods = this.goodsService.getGoods(Integer.parseInt(strings1[0]));

            goods.setBuyGoodsNum(Integer.parseInt(strings1[1]));

            goodsList.add(goods);
        }
        Order order = new Order();
        order.setId(String.valueOf(System.currentTimeMillis()));
        order.setAccount_id(subject.getAccount().getId());
        order.setAccount_name(subject.getAccount().getName());
        order.setCreate_time(LocalDateTime.now());
        order.setOrder_status(OrderStatus.PLAYING);

        int totalMoney = 0;
        int actualAmount = 0;
        //计算需要的总金额
        for (Goods goods : goodsList){
            OrderItem orderItem = new OrderItem();
            orderItem.setOrder_id(order.getId());
            orderItem.setGoods_id(goods.getId());
            orderItem.setGoods_name(goods.getName());
            orderItem.setGoods_unit(goods.getUnit());
            orderItem.setGoods_price(goods.getPrice());
            orderItem.setGoods_discount(goods.getDiscount());
            orderItem.setGoods_introduce(goods.getIntroduce());
            orderItem.setGoods_num(goods.getBuyGoodsNum());

            order.getOrderItemList().add(orderItem);

            int currentMoney = goods.getPrice()*goods.getBuyGoodsNum();
            totalMoney += currentMoney;
            actualAmount += currentMoney*goods.getDiscount()/100;
        }
        order.setActual_amount(actualAmount);
        order.setTotal_money(totalMoney);

        /*
        支付
         */
        System.out.println(order);
        System.out.println("以上为订单信息，请支付：zf");
        String confirm = scanner.next();
        if ("zf".equalsIgnoreCase(confirm)){
            order.setFinish_time(LocalDateTime.now());
            order.setOrder_status(OrderStatus.OK);

            boolean effect = this.orderService.commitOrder(order);
            if (effect){
                for (Goods goods : goodsList){
                    boolean isUpdate = this.goodsService.updateGoodsAfterPay(goods,goods.getBuyGoodsNum());
                    if (isUpdate){
                        System.out.println("库存已经更新");
                    }
                }
            }
        }else {
            warningPrintln("您未支付成功，请重新支付");
        }
    }
}
