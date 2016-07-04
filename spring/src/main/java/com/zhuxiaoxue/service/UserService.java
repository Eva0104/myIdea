package com.zhuxiaoxue.service;

import com.zhuxiaoxue.mapper.LoginMapper;
import com.zhuxiaoxue.mapper.UserMapper;
import com.zhuxiaoxue.pojo.Loginlog;
import com.zhuxiaoxue.pojo.User;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;


public class UserService {

    @Inject
    private UserMapper userMapper;

    @Inject
    private LoginMapper loginMapper;

    public User findById(Integer id){
        return userMapper.findById(id);
    }

    public void save(User user){
        userMapper.save(user);
    }

    public List<Loginlog> findByUserId(Integer userId){
        return loginMapper.findByUserId(userId);
    }
}
