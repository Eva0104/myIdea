package com.zhuxiaoxue.test;
import com.zhuxiaoxue.entity.User;
import com.zhuxiaoxue.util.ConnectionManager;
import com.zhuxiaoxue.util.DbHelper;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class DbUtilsTest {
    @Test
    public void testSave() {
        String sql = "insert into student (name,address,tel) values(?,?,?)";
        DbHelper.update(sql,"eric","河南","1212");

    }

    @Test
    public void testUpdate() {
        String sql = "update student set name=? where id=?";
        DbHelper.update(sql,"lucy",4);
    }

    @Test
    public void testQueryById() {
        QueryRunner queryRunner = new QueryRunner();
        String sql = "select * from student where id = ?";
        Connection connection = ConnectionManager.getConnection();

        try {
            User user = queryRunner.query(connection, sql, new BeanHandler<User>(User.class),4);
            System.out.print(user);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.closeConnection(connection);
        }
    }

    @Test
    public void testQueryAll() {
        String sql = "select * from student ";
        List<User> userList = DbHelper.query(sql,new BeanListHandler<User>(User.class));
            for (User user : userList) {
                System.out.println(user);
            }

    }

    @Test
    public void testQueryMap() {
        QueryRunner queryRunner = new QueryRunner();
        Connection connection = ConnectionManager.getConnection();
        String sql = "select * from student where id =?";
        try {
            Map<String, Object> user = queryRunner.query(connection, sql, new MapHandler(), 1);
            for (Map.Entry<String, Object> users : user.entrySet()) {
                System.out.println(users.getKey() + "--->" + users.getValue());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
