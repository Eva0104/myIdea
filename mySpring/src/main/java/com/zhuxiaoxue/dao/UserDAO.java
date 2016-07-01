package com.zhuxiaoxue.dao;

import com.zhuxiaoxue.pojo.User;

import java.util.List;

/**
 * Created by Eric on 2016/6/30.
 */
public interface UserDAO {
    void save(User user);
    void delete(Integer id);
    void update(User user);
    User findById(Integer id);
    List<User> findAll();
    User findByName(String name);
    Long count();
}
