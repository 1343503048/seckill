package org.seckill.dao;

import org.apache.ibatis.annotations.Param;
import org.seckill.entity.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDao {

  /**
   * @param userId 用户ID
   * @param goodsId 商品ID
   */
  public int addOrder(@Param("userId") long userId, @Param("goodsId") long goodsId);

  public List<Order> getOrderList();

  public Order getOrderByUserIdAndGoodsId(
      @Param("userId") long userId, @Param("goodsId") long goodsId);
}
