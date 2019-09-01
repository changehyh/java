package com.hyh.cmd.impl.order;

import com.hyh.cmd.Subject;
import com.hyh.cmd.annotation.CommandMete;
import com.hyh.cmd.annotation.CustomerCommand;
import com.hyh.cmd.impl.AbstractCommand;
import com.hyh.vo.Order;

import java.util.List;

@CommandMete(
        name = "CKDD",
        desc = "查看订单",
        group = "我的订单"
)
@CustomerCommand
public class OrderBrowseCommand extends AbstractCommand {

    @Override
    public void execute(Subject subject) {
        System.out.println("我的订单表");

        List<Order> orderList = this.orderService.queryOrderByAccount(subject.getAccount().getId());
        if(orderList.isEmpty()){
            System.out.println("暂时没有订单");
        }else {
            for (Order order: orderList){
                System.out.println("==================开始==================");
                System.out.println(order);
                System.out.println("==================结束==================");
            }
        }
    }

}
