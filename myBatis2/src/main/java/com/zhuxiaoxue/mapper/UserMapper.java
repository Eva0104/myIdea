package com.zhuxiaoxue.mapper;

import com.zhuxiaoxue.pojo.User;
import org.apache.ibatis.annotations.Param;

/**
 * Created by Eric on 2016/6/29.
 */
public interface UserMapper {

    User findById(Integer id);

    User findByParams(@Param("username") String username, @Param("password") String password);

    void save(User user);

    void update(User user);

    void delete(Integer id);
}
