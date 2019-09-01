package com.hyh.service;

import com.hyh.dao.GoodsDao;
import com.hyh.vo.Goods;

import java.util.List;

public class GoodsService {

    private GoodsDao goodsDao;

    public GoodsService(){
        this.goodsDao = new GoodsDao();
    }

    public boolean putAwayGoods(Goods goods){
        return this.goodsDao.putAwayGoods(goods);
    }
    public Goods getGoods(int goodsId){
        return this.goodsDao.getGoods(goodsId);
    }

    public List<Goods> queryAllGoods() {
        return this.goodsDao.queryAllGoods();
    }

    public boolean soldOutGoods(int goodsId) {
        return this.goodsDao.soldOutGoods(goodsId);
    }

    public boolean updateGoods(Goods goods) {
        return this.goodsDao.updateGoods(goods);
    }

    public boolean updateGoodsAfterPay(Goods goods,int goodsId) {
        return this.goodsDao.updateGoodsAfterPay(goods,goodsId);
    }
}
