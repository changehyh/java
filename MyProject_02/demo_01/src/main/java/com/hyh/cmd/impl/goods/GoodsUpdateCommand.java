package com.hyh.cmd.impl.goods;

import com.hyh.cmd.Subject;
import com.hyh.cmd.annotation.AdminCommand;
import com.hyh.cmd.annotation.CommandMete;
import com.hyh.cmd.impl.AbstractCommand;
import com.hyh.vo.Goods;

@CommandMete(
        name = "GXSP",
        desc = "更新商品",
        group = "商品信息"
)
@AdminCommand
public class GoodsUpdateCommand extends AbstractCommand {

    @Override
    public void execute(Subject subject) {
        System.out.println("更新商品");
        System.out.println("请输入需要更新的商品编号：");
        int goodsId = scanner.nextInt();
        Goods goods = this.goodsService.getGoods(goodsId);
        if (goods == null){
            warningPrintln("您输入的编号不存在");
        }else {
            System.out.println("商品信息如下：");
            System.out.println(goods);

            hitPrintln("请输入跟新商品的简介：");
            String introduce = scanner.next();

            hitPrintln("请输入更新商品库存：");
            int stock = scanner.nextInt();

            hitPrintln("请输入更新的商品单位：个，包，箱，瓶，千克");
            String unit = scanner.next();

            hitPrintln("请输入更新商品价格：单位：元");
            int price = new Double(100 * scanner.nextDouble()).intValue();

            hitPrintln("请输入更新商品折扣：75表示75折");
            int discount = scanner.nextInt();

            System.out.println("请输入是否更新(y/n)");
            String confirm = scanner.next();

            if ("y".equalsIgnoreCase(confirm)){
                goods.setIntroduce(introduce);
                goods.setUnit(unit);
                goods.setStock(stock);
                goods.setPrice(price);
                goods.setDiscount(discount);

                boolean effect = this.goodsService.updateGoods(goods);
                if (effect){
                    System.out.println("商品更新成功");
                }else {
                    errorPrintln("跟新失败");
                }
            }
        }
    }
}
