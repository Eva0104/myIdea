package com.zhuxiaoxue.test;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

public class CodecTest {

    @Test
    public void md5Test() {
        String password = "123123";
        String salt = "%%%%%%%%%%";
        password = DigestUtils.md5Hex(password + salt);
        System.out.println(password.length());
    }

    @Test
    public void shaTest() {
        String password = "123123";
        String salt = "%%%%%%%%%%";
        password = DigestUtils.sha1Hex(password+salt);
        System.out.println(password.length());
    }
}
