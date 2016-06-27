package com.zhuxiaoxue.dao;

import com.zhuxiaoxue.entity.User;
import com.zhuxiaoxue.util.DbHelper;
import com.zhuxiaoxue.util.EhcacheUtil;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class UserDAO {
    private Logger logger = LoggerFactory.getLogger(UserDAO.class);

    public void save(User user) {
        String sql = "insert into student (name,address,tel) values (?,?,?)";
        DbHelper.update(sql, user.getName(), user.getAddress(), user.getPassword());
        EhcacheUtil.remove("userList");
    }

    public void updateById(String name, Integer id) {
        String sql = "update student set name=? where id=?";
        DbHelper.update(sql, name, id);
    }

    public User deleteById(Integer id) {
        String sql = "delete from student where id=?";
        DbHelper.update(sql, id);
        return null;
    }

    public User queryById(Integer id) {
        User user = (User) EhcacheUtil.get("user:"+id);
        if(user == null){
            String sql = "select * from student where id =?";
            user = DbHelper.query(sql, new BeanHandler<>(User.class), id);
            EhcacheUtil.set("user:" + id,user);
        }else{
            logger.info("从缓存中读取");
        }
        return user;
    }

    public User queryByUsername(String username) {
        String sql = "select * from student where name =?";
        User user = DbHelper.query(sql, new BeanHandler<>(User.class), username);
        return user;
    }

    public List<User> queryAll() {
        List<User> userList = (List<User>) EhcacheUtil.get("userList");
        if(userList == null){
            String sql = "select * from student";
            userList = DbHelper.query(sql, new BeanListHandler<>(User.class));
            EhcacheUtil.set("userList",userList);
        }

        return userList;
    }

}
