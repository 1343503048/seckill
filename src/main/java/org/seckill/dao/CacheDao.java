package org.seckill.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.JedisPool;

@Repository
public class CacheDao {
  private static final String PREFIX_GOODS_LIST = "pgl.";
  private static final String PREFIX_PAGE = "pp.";

  @Autowired private JedisPool jedisPool;

  public void set(final String key, final String val) {
    jedisPool.getResource().set(key, val);
  }

  public Object get(String key) {
    return jedisPool.getResource().get(key);
  }
}
