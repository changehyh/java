package com.biitech.jcf.mr;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;

/**
 * Author: secondriver
 * Created: 2019/6/1
 */
public class TestMapReduce {
    
    public static void main(String[] args) {
        List<Order> orderList = new ArrayList<>();
        orderList.add(new Order("Iphone", 8999.99, 10));
        orderList.add(new Order("外星人笔记本", 12999.99, 5));
        orderList.add(new Order("MacBookPro", 18999.99, 5));
        orderList.add(new Order("Java从入门到放弃.txt", 9.99, 20000));
        orderList.add(new Order("中性笔", 1.99, 200000));


//        double totalPrice = 0.0D;
//        for (Order order : orderList){
//            totalPrice+= order.getPrice()*order.getAmount();
//        }
//        System.out.println("总金额："+totalPrice);
        //  a, b , c, d, e
        //  r =  apply(x,y)
        // r = 0
        // r a => a
        // r b => r + b => a + b
        // r c => r + c => a + b + c
//        Double totalPrice = orderList.stream().map(order -> order.getAmount() * order.getPrice()).reduce((sum, x) -> sum + x).get();
//        Double totalPrice = orderList.stream().map(order -> order.getAmount() * order.getPrice()).reduce(Double::sum).orElseGet(()->0.0D);
//        Double totalPrice =
//                orderList.stream().mapToDouble(order -> order.getAmount() * order.getPrice()).reduce(Double::sum).orElseGet(()->0.0D);
//        System.out.println(totalPrice);
        
        
        //1. 订单个数   5
        //2. 总金额     847799.8
        //3. 最大订单
        //4. 最小订单
        //5. 平均

//        double totalPrice = 0.0D;
//        double maxPrice = Double.MIN_VALUE;
//        double minPrice = Double.MAX_VALUE;
//        double totalCount = 0;
//        double avgPrice = 0.0D;
//        for (Order order : orderList) {
//            double orderPrice = order.getPrice() * order.getAmount();
//            if (orderPrice > maxPrice) {
//                maxPrice = orderPrice;
//            }
//            if (orderPrice < minPrice) {
//                minPrice = orderPrice;
//            }
//            totalPrice += orderPrice;
//            totalCount++;
//        }
//        avgPrice = totalPrice / totalCount;
//
//        System.out.println("总订单数：" + totalCount);
//        System.out.println("总金额：" + totalPrice);
//        System.out.println("最大金额：" + maxPrice);
//        System.out.println("最小金额：" + minPrice);
//        System.out.println("平均金额：" + avgPrice);
        
        DoubleSummaryStatistics statistics = orderList.stream().mapToDouble(order -> order.getPrice() * order.getAmount()).summaryStatistics();
        System.out.println("总订单数：" + statistics.getCount());
        System.out.println("总金额：" + statistics.getSum());
        System.out.println("最大金额：" + statistics.getMax());
        System.out.println("最小金额：" + statistics.getMin());
        System.out.println("平均金额：" + statistics.getAverage());
        
    }
}
