package com.hyh.cmd.impl.goods;

import com.hyh.cmd.Subject;
import com.hyh.cmd.annotation.AdminCommand;
import com.hyh.cmd.annotation.CommandMete;
import com.hyh.cmd.annotation.CustomerCommand;
import com.hyh.cmd.annotation.EntranceCommand;
import com.hyh.cmd.impl.AbstractCommand;
import com.hyh.vo.Goods;

import java.util.List;

@CommandMete(
        name = "LLSP",
        desc = "浏览商品",
        group = "商品信息"
)
@CustomerCommand
@AdminCommand
public class GoodsBrowseCommand extends AbstractCommand {

    @Override
    public void execute(Subject subject) {
        System.out.println("浏览商品");
        List<Goods> goodsList = this.goodsService.queryAllGoods();
        if (goodsList.isEmpty()){
            System.out.println("没有任何商品");
        }else {
            for (Goods goods : goodsList){
                System.out.println(goods);
            }
        }
    }
}
