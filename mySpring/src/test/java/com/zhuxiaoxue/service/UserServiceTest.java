package com.zhuxiaoxue.service;


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
    public void testLogin(){
        userService.login("甄嬛","000000","3.1.1.1");
    }
}
