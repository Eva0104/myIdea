package com.zhuxiaoxue.mapper;

import com.zhuxiaoxue.pojo.User;

import java.util.List;

/**
 * Created by Eric on 2016/6/28.
 */
public interface UserMapper {

    User findById(Integer id);

    List<User> findAll();

    void save(User user);

    void update(User user);

    void delete(Integer id);
}
