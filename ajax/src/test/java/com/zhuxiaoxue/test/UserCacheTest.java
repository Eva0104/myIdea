package com.zhuxiaoxue.test;

import com.zhuxiaoxue.dao.UserDAO;
import com.zhuxiaoxue.entity.User;
import org.junit.Assert;
import org.junit.Test;

public class UserCacheTest {
    private UserDAO dao = new UserDAO();

    @Test
    public void test(){
        User user = dao.queryById(1);
        user = dao.queryById(1);
        Assert.assertNotNull(user);
    }

}
