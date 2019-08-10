package com.cashsystem.cmd.impl;

import com.cashsystem.cmd.Command;
import com.cashsystem.service.AccountService;
import com.cashsystem.service.GoodsServes;
import com.cashsystem.service.OrderService;

public abstract class AbstractCommand implements Command {
    //启动所有的服务
    public AccountService accountService;
    public GoodsServes goodsServes;
    public OrderService orderService;

    public AbstractCommand (){
        this.accountService = new AccountService();
        this.goodsServes = new GoodsServes();
        this.orderService = new OrderService();
    }
}
