package org.seckill.service;

import org.seckill.entity.Order;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SeckillService {

  @Autowired private GoodsService goodsService;

  @Autowired private OrderService orderService;

  @Transactional
  public Order doSeckill(long userId, long goodsId)
      throws RepeatKillException, SeckillCloseException {
    try {
      int insertCount = orderService.addOrder(userId, goodsId);
      if (insertCount <= 0) {
        throw new RepeatKillException("重复秒杀");
      } else {
        int updateCount = goodsService.reduceStock(goodsId);
        if (updateCount <= 0) {
          throw new RepeatKillException("秒杀活动结束");
        }
        return orderService.getOrderByUserIdAndGoodsId(userId, goodsId);
      }
    } catch (RepeatKillException e) {
      throw e;
    } catch (SeckillCloseException e) {
      throw e;
    }
  }
}
