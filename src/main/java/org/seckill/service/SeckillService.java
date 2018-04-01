package org.seckill.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeckillService {

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private OrderService orderService;

    public void doSeckill(long userId, long goodsId) {
        goodsService.reduceStock(goodsId);
        orderService.addOrder(userId, goodsId);
    }
}
