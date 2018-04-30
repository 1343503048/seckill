package org.seckill.dao;

import org.seckill.entity.User;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
  public User getUserByPhone(@Param("phone") long phone);

  public User getUserById(@Param("userId") long userId);
}
