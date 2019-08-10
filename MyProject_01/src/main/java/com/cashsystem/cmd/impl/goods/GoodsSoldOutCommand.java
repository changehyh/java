package com.cashsystem.cmd.impl.goods;

import com.cashsystem.cmd.Subject;
import com.cashsystem.cmd.annotation.AdminCommand;
import com.cashsystem.cmd.annotation.CommandMeta;
import com.cashsystem.cmd.impl.AbstractCommand;
import com.cashsystem.entity.Goods;

@CommandMeta(
        name = "XJSP",
        desc = "下架商品",
        group = "商品信息"
)
@AdminCommand
public class GoodsSoldOutCommand extends AbstractCommand {
    @Override
    public void execute(Subject subject) {
        System.out.println("下架商品");
        System.out.println("请输入要下架的商品编号");
        int id = scanner.nextInt();
        Goods goods = new Goods();
        goods.setId(id);
        boolean effect = this.goodsServes.SoldOutGoods(goods);
        if (effect) {
            System.out.println("下架成功");
        } else {
            System.out.println("下架失败");
        }
    }
}
