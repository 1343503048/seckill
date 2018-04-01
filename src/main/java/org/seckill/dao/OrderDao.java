package org.seckill.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDao {


    /**
     * @param userId       用户ID
     * @param goodsId       商品ID
     */
    public void addOrder(@Param("userId") long userId, @Param("goodsId") long goodsId);

    public void getOrderList();
}
