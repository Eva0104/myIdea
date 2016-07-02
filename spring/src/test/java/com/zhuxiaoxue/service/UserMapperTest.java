package com.zhuxiaoxue.service;

import com.zhuxiaoxue.pojo.Loginlog;
import com.zhuxiaoxue.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:ApplicationContext.xml")
public class UserMapperTest {

    @Inject
    private UserService userService;

    @Test
    public void testFindById(){
        User user = userService.findById(1);
        System.out.println(user);
    }

    @Test
    public void testSave(){
        User user = new User("大地瓜","大地","000000");
        userService.save(user);
    }

    @Test
    public void testFindLoginlogById(){
       List<Loginlog> loginlogList =  userService.findByUserId(17);
        for(Loginlog loginlog : loginlogList){
            System.out.println(loginlog);
        }
    }

}
