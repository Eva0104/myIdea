package com.zhuxiaoxue.test;

import com.zhuxiaoxue.util.Config;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.junit.Test;

public class MailTest {

    @Test
    public void sendMailTest() {
        Email email = new SimpleEmail();
        email.setAuthentication(Config.getConfig("mail.username"), Config.getConfig("mail.password"));
        email.setHostName(Config.getConfig("mail.hostName"));
        email.setSmtpPort(Integer.parseInt(Config.getConfig("mail.port")));
        email.setCharset(Config.getConfig("mail.charset"));

        try{
            email.setFrom(Config.getConfig("mail.setFrom"));
            email.setSubject("我还没写到时间部分");
            email.setMsg("这是利用commons包发出的电子邮件");
            //email.addTo("342030831@qq.com");
            email.addTo("xieyue86@163.com");
            email.send();
        }catch (EmailException ex){
            throw new RuntimeException(ex);
        }

    }
}
