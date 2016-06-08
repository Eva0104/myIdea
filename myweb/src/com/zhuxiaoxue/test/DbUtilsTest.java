package com.zhuxiaoxue.test;

import com.zhuxiaoxue.entity.User;
import com.zhuxiaoxue.util.ConnectionManager;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class DbUtilsTest {
    @Test
    public void testSave() {
        QueryRunner queryRunner = new QueryRunner();
        String sql = "insert into student (name,address,tel) values(?,?,?)";

        Connection connection = ConnectionManager.getConnection();
        try {
            queryRunner.update(connection, sql, "jim", "焦作", "123");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testUpdate() {
        QueryRunner queryRunner = new QueryRunner();
        String sql = "update student set name=? where id=?";
        Connection connection = ConnectionManager.getConnection();

        try {
            queryRunner.update(connection, sql, "tom", 3);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testQueryById(){
        QueryRunner queryRunner = new QueryRunner();
        String sql = "select * from student where id = ?";
        Connection connection = ConnectionManager.getConnection();

        try {
            User user = queryRunner.query(connection,sql, new BeanHandler<User>(User.class), 1);
            System.out.print(user);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    

}
