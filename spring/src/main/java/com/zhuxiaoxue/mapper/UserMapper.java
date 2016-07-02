package com.zhuxiaoxue.mapper;

import com.zhuxiaoxue.pojo.User;

/**
 * Created by Eric on 2016/7/2.
 */
public interface UserMapper {

    User findById(Integer id);

    void save(User user);
}
