package com.zhuxiaoxue.dao;

import com.zhuxiaoxue.pojo.User;

import java.util.List;

/**
 * Created by Eric on 2016/7/4.
 */
public interface UserDao {

    List<User> findAll();
}
