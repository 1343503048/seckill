package org.seckill.service;

import org.seckill.dao.GoodsDao;
import org.seckill.entity.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsService {

  @Autowired private GoodsDao goodsDao;

  private List<Goods> list;

  public List<Goods> getGoodsList(long offset, long limit) {
    if (list != null) {
      return list;
    }
    list = goodsDao.getGoodsList(offset, limit);
    return list;
  }

  public Goods getGoodsById(long id) {
    Goods goods = goodsDao.getGoodsById(id);
    System.out.println(goods);
    return goods;
  }

  public int reduceStock(long id) {
    return goodsDao.reduceStock(id);
  }
}
