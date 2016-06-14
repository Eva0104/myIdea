package com.zhuxiaoxue.test;

import com.zhuxiaoxue.util.Config;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.joda.time.DateTime;
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
            email.setSubject("练习一下 ^-^");
            email.setMsg("现在时间"+ DateTime.now().toString("yyyy-MM-dd hh:mm:ss"));
            //email.addTo("342030831@qq.com");
            email.addTo("xieyue86@163.com");
            email.send();
        }catch (EmailException ex){
            throw new RuntimeException(ex);
        }

    }
}
