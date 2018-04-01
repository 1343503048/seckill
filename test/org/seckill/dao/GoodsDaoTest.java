package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:/spring-dao.xml"})
public class GoodsDaoTest {

    @Autowired
    private GoodsDao goodsDao;

    @Test
    public void getGoodsList() {
        List<Goods> list = goodsDao.getGoodsList(0, 4);
        for (Goods goods : list) {
            System.out.println(goods);
        }
    }

    @Test
    public void getGoodsById() {
        long id = 10001;
        System.out.println(goodsDao.getGoodsById(id));
    }
}