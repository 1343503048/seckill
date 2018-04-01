package org.seckill.service;

import org.seckill.dao.UserDao;
import org.seckill.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public boolean login(long phone, String password) {
        User user = userDao.getUserByPhone(phone);
        System.out.println(user);
        if (user!= null && phone == user.getUserPhone() && password.equals(user.getUserPassword())) {
            return true;
        }
        else {
            return false;
        }
    }
}
