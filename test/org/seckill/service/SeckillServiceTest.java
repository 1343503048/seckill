package org.seckill.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:/spring-service.xml", "classpath:/spring-dao.xml"})
public class SeckillServiceTest {

    @Autowired
    private SeckillService seckillService;

    @Test
    public void doSeckill() {
        seckillService.doSeckill(1004, 10001);
    }
}