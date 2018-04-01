package org.seckill.service;

import org.seckill.dao.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    private OrderDao orderDao;

    public void addOrder(long userId, long goodsId) {
        orderDao.addOrder(userId, goodsId);
    }
}
