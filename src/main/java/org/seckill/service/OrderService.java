package org.seckill.service;

import org.seckill.dao.OrderDao;
import org.seckill.entity.Goods;
import org.seckill.entity.Order;
import org.seckill.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

  @Autowired private OrderDao orderDao;

  @Autowired private GoodsService goodsService;

  @Autowired private UserService userService;

  public int addOrder(long userId, long goodsId) {
    return orderDao.addOrder(userId, goodsId);
  }

  public Order getOrderByUserIdAndGoodsId(long userId, long goodsId) {
    Order order = orderDao.getOrderByUserIdAndGoodsId(userId, goodsId);
    User user = userService.getUserById(userId);
    Goods goods = goodsService.getGoodsById(goodsId);
    order.setUserName(user.getUserName());
    order.setUserPhone(user.getUserPhone());
    order.setGoodsName(goods.getGoodsName());
    return order;
  }
}
