package com.zhuxiaoxue.test;

import com.zhuxiaoxue.dao.UserDAO;
import com.zhuxiaoxue.entity.User;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class UserDAOTest {
    UserDAO dao = new UserDAO();
    @Test
    public void testSave(){
        User user = new User("武则天2","河南","120");
        dao.save(user);
    }
    @Test
    public void testUpdateById(){
        dao.updateById("秦始皇",13);
    }
    @Test
    public void testDeleteById(){
        dao.deleteById(5);
    }
    @Test
    public void testQueryById(){
        User user = dao.queryById(1);
        Assert.assertNotNull(user);
        System.out.println(user);
    }
    @Test
    public void testQueryAll(){
       List<User> list =  dao.queryAll();
        Assert.assertEquals(list.size(),10);
    }
}
