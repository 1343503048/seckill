package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:/spring-redis.xml"})
public class CacheDaoTest {

  @Autowired private CacheDao cacheDao;

  //    RedisTemplate redisTemplate;

  @Test
  public void set() {
    cacheDao.set("name", "zq123");
    System.out.println(cacheDao.get("name"));
  }
}
