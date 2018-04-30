package org.seckill.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:/spring-service.xml", "classpath:/spring-dao.xml"})
public class GoodsServiceTest {

  @Autowired private GoodsService goodsService;

  @Test
  public void getGoodsList() {
    System.out.println(goodsService.getGoodsList(0, 4));
  }

  @Test
  public void getGoodsById() {}

  @Test
  public void reduceStock() {}
}
