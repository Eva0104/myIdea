package com.zhuxiaoxue.service;

import com.zhuxiaoxue.mapper.UserMapper;
import com.zhuxiaoxue.pojo.User;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class UserService {

    @Inject
    private UserMapper userMapper;

    public void save(User user) {
        userMapper.save(user);
    }
}
