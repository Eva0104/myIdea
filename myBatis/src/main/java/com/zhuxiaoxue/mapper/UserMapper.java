package com.zhuxiaoxue.mapper;

import com.zhuxiaoxue.pojo.User;

import java.util.List;
import java.util.Map;

/**
 * Created by Eric on 2016/6/28.
 */
public interface UserMapper {

    void batchSave(List<User> userList);

    List<User> findByQueryParams(Map<String,Object> queryParam);

    User findByParams(String username,String password);

    User findById(Integer id);

    List<User> findAll();

    void save(User user);

    void update(User user);

    void delete(Integer id);
}
