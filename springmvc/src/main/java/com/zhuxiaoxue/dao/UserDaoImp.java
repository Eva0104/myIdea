package com.zhuxiaoxue.dao;

import com.zhuxiaoxue.pojo.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class UserDaoImp implements UserDao {

    @Inject
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<User> findAll() {
        String sql = "select * from student";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(User.class));
    }
}
