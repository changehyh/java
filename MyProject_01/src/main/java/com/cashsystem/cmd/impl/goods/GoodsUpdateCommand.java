package com.cashsystem.cmd.impl.goods;

import com.cashsystem.cmd.Subject;
import com.cashsystem.cmd.annotation.AdminCommand;
import com.cashsystem.cmd.annotation.CommandMeta;
import com.cashsystem.cmd.impl.AbstractCommand;
import com.cashsystem.entity.Goods;

@CommandMeta(
        name = "GXSP",
        desc = "更新商品",
        group = "商品信息"
)
@AdminCommand
public class GoodsUpdateCommand extends AbstractCommand {
    @Override
    public void execute(Subject subject) {
        System.out.println("更新商品");
        System.out.println("请t输入更新商品的编号：");

        int goodsId = Integer.parseInt(scanner.nextLine());

        Goods goods = this.goodsServes.getGoods(goodsId);

        if (goods == null){
            System.out.println("没有此编号的货物");
            return;
        }else {
            System.out.println("商品信息如下：");
            System.out.println(goods);
        }
        ;
        System.out.println("请输入需要跟新的商品简介：");
        String introduce = scanner.nextLine();

        System.out.println("商品名称");
        String name = scanner.nextLine();
        System.out.println("商品库存");
        //强转
        int stock = Integer.parseInt(scanner.nextLine());

        System.out.println("商品单位：包，个，箱，瓶...");
        String unit = scanner.nextLine();

        System.out.println("请输入商品折扣：75表示75折");
        int discount = Integer.parseInt(scanner.nextLine());

        System.out.println("请输入商品价格：单位(元) 保留小数点后2位");
        int price = new Double(100 * scanner.nextDouble()).intValue();


        System.out.println("请确认是否更新：y/n");
        String flg = scanner.next();
        if ("y".equalsIgnoreCase(flg)){
            goods.setName(name);
            goods.setIntroduce(introduce);
            goods.setStock(stock);
            goods.setUnit(unit);
            goods.setPrice(price);
            goods.setDiscount(discount);
            boolean effect = this.goodsServes.modifyGoods(goods);
            if (effect){
                System.out.println("商品更新成功");
            }else {
                System.out.println("商品更新失败");
            }
        }else {
            System.out.println("您选择不更新");
        }
    }
}
