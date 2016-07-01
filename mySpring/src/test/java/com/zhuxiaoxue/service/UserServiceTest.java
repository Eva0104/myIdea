package com.zhuxiaoxue.service;

import com.zhuxiaoxue.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:ApplicationContext.xml")
public class UserServiceTest {

    @Inject
    private UserService userService;

    @Test
    public void testSave(){
        User user = new User();
        user.setName("番薯");
        user.setPassword("101010");
        user.setAddress("大地");

        userService.save(user);
    }
}
