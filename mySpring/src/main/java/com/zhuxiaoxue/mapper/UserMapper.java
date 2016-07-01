package com.zhuxiaoxue.mapper;

import com.zhuxiaoxue.pojo.User;

/**
 * Created by Eric on 2016/7/1.
 */
public interface UserMapper {

    void save(User user);

    User findById(Integer id);
}
