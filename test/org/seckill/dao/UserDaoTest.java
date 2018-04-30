package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:/spring-dao.xml"})
public class UserDaoTest {

  @Autowired private UserDao userDao;

  @Test
  public void getUserByPhone() {
    long phone = 132225650001l;
    System.out.println(userDao.getUserByPhone(phone));
  }
}
