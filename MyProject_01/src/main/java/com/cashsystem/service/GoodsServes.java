package com.cashsystem.service;

import com.cashsystem.dao.GoodsDao;
import com.cashsystem.entity.Goods;

import java.util.List;

public class GoodsServes {

    public GoodsDao goodsDao;

    public GoodsServes() {
        this.goodsDao = new GoodsDao();
    }

    public List<Goods> quarryAllGoods(){
        return this.goodsDao.quarryAllGoods();
    }

    public boolean putAwayGoods(Goods goods){
        return this.goodsDao.putAwayGoods(goods);
    }
    public Goods getGoods(int goodsId){
        return this.goodsDao.getGoods(goodsId);
    }
    public boolean SoldOutGoods(Goods goods){
        return this.goodsDao.SoldOutGoods(goods);
    }

    public boolean modifyGoods(Goods goods){
        return this.goodsDao.modifyGoods(goods);
    }

    public boolean updateAfterPay(Goods goods,int GoodsBuyNum){
        return this.goodsDao.updateAfterPay(goods,GoodsBuyNum);
    }
}
