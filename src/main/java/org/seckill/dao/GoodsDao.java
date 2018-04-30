package org.seckill.dao;

import org.apache.ibatis.annotations.Param;
import org.seckill.entity.Goods;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsDao {

  public List<Goods> getGoodsList(@Param("offset") long offset, @Param("limit") long limit);

  public Goods getGoodsById(@Param("id") long id);

  public int reduceStock(@Param("id") long id);
}
