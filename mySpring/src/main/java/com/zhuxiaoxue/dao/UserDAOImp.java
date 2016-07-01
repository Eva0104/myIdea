package com.zhuxiaoxue.dao;
import com.zhuxiaoxue.pojo.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SingleColumnRowMapper;

import javax.inject.Inject;
import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Named
public class UserDAOImp implements UserDAO {

    @Inject
    private JdbcTemplate jdbcTemplate;

    @Override
    public void save(User user) {
        String sql = "insert into student (name,address,password) values (?,?,?)";
        jdbcTemplate.update(sql,user.getName(),user.getAddress(),user.getPassword());
    }

    @Override
    public void delete(Integer id) {
        String sql = "delete from student where id =?";
        jdbcTemplate.update(sql,id);

    }

    @Override
    public void update(User user) {
        String sql = "update student set name=?,address=?,password=? where id=?";
        jdbcTemplate.update(sql,user.getName(),user.getAddress(),user.getPassword(),user.getId());
    }

    @Override
    public User findById(Integer id) {
        String sql = "select * from student where id=?";
//        return jdbcTemplate.queryForObject(sql, new RowMapper<User>() {
//            @Override
//            public User mapRow(ResultSet resultSet, int i) throws SQLException {
//                User user = new User();
//                user.setId(resultSet.getInt("id"));
//                user.setName(resultSet.getString("name"));
//                user.setPassword(resultSet.getString("password"));
//                user.setAddress(resultSet.getString("address"));
//                return user;
//            }
//        },id);
        return jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<>(User.class),id);
    }

    @Override
    public List<User> findAll() {
        String sql = "select * from student";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(User.class));
    }

    @Override
    public User findByName(String name) {
        String sql = "select * from student where name=?";
        return jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<>(User.class),name);
    }

    @Override
    public Long count() {
        String sql = "select count(*) from student";
        return jdbcTemplate.queryForObject(sql,new SingleColumnRowMapper<Long>());
    }
}
