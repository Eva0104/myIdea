package com.zhuxiaoxue.dao;

import com.zhuxiaoxue.entity.User;
import com.zhuxiaoxue.util.DbHelper;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import java.util.List;

public class UserDAO {
    public void save(User user) {
        String sql = "insert into student (name,address,tel) values (?,?,?)";
        DbHelper.update(sql,user.getName(),user.getAddress(),user.getTel());
    }

    public void updateById(String name, Integer id) {
        String sql = "update student set name=? where id=?";
        DbHelper.update(sql, name, id);
    }

    public void deleteById(Integer id) {
        String sql = "delete from student where id=?";
        DbHelper.update(sql, id);
    }

    public User queryById(Integer id) {
        String sql = "select * from student where id =?";
        User user = DbHelper.query(sql, new BeanHandler<>(User.class), id);
        return user;
    }

    public List<User> queryAll() {
        String sql = "select * from student";
        List<User> list = DbHelper.query(sql, new BeanListHandler<>(User.class));
        return list;
    }

}
