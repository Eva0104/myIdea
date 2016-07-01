package com.zhuxiaoxue.dao;

import com.zhuxiaoxue.pojo.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:ApplicationContext.xml")
public class UserDAOImpTest {

    @Inject
    private UserDAO userDAO;

    @Test
    public void testSave(){
        User user = new User();
        user.setName("欧阳帅");
        user.setPassword("123123");
        user.setAddress("火星");

        userDAO.save(user);
    }

    @Test
    public void testDelete(){
        userDAO.delete(15);
    }

    @Test
    public void testUpdate(){
        User user = userDAO.findById(14);
        user.setName("皇后2");
        user.setAddress("后宫2");
        user.setPassword("222222");

        userDAO.update(user);
    }

    @Test
    public void testFindById(){
        User user = userDAO.findById(16);
        System.out.println(user);
    }
    @Test
    public void testFindByName(){
        User user = userDAO.findByName("大白");
        System.out.println(user);
    }

    @Test
    public void testCount(){
        Long count = userDAO.count();
        System.out.println(count);
    }

}
