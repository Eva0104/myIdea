package com.zhuxiaoxue.dao;


import com.zhuxiaoxue.pojo.LoginLog;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:ApplicationContext.xml")
public class LoginLogDaoTest {

    @Inject
    private LoginLogDAO loginLogDAO;

    @Test
    public void testSave(){
        LoginLog loginLog = new LoginLog("8.8.8.8",1);
        loginLogDAO.save(loginLog);
    }

}
