package com.zhuxiaoxue.service;

import com.zhuxiaoxue.dao.UserDao;
import com.zhuxiaoxue.pojo.User;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class UserService {

    @Inject
    private UserDao userDao;

    public List<User> findAll(){
        return userDao.findAll();
    }
}
