package com.zhuxiaoxue;


import com.zhuxiaoxue.pojo.User;
import com.zhuxiaoxue.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class UserServiceTestCase {

    @Autowired
    private UserService userService;

    @Test
    public void testSave(){
        User user = new User(102,"eric",99.9F);
        userService.saveUser(user);
    }

    @Test
    public void testFindById(){
        User user = userService.findById(102);
        System.out.println(user.getName());
    }


}
