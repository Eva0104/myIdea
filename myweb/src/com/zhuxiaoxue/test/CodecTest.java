package com.zhuxiaoxue.test;

import com.zhuxiaoxue.entity.User;
import com.zhuxiaoxue.servic.UserServic;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Assert;
import org.junit.Test;

public class CodecTest {

    @Test
    public void md5Test() {
        String password = "111111";
        //String salt = "%%%%%%%%%%";
        password = DigestUtils.md5Hex(password);
        System.out.println(password);
    }

    @Test
    public void shaTest() {
        String password = "123123";
        String salt = "%%%%%%%%%%";
        password = DigestUtils.sha1Hex(password + salt);
        System.out.println(password);
    }

    @Test
    public void LoginTest() {
        UserServic userServic = new UserServic();
        User user = userServic.login("Jack", "111111");
        Assert.assertNotNull(user);
    }
}
