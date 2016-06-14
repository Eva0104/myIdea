package com.zhuxiaoxue.test;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.junit.Test;

public class MailTest {

    @Test
    public void sendMailTest() {
        Email email = new SimpleEmail();
        email.setAuthentication("zhuxiaoxue0104", "Eric0609");
        email.setHostName("smtp.126.com");
        email.setSmtpPort(25);
        email.setCharset("utf-8");

        try{
            email.setFrom("zhuxiaoxue0104@126.com");
            email.setSubject("明天咱俩约会吧  你说去哪");
            email.setMsg("这是利用commons包发出的电子邮件");
            email.addTo("zhuxiaoxue0104@126.com");
            email.send();
        }catch (EmailException ex){
            throw new RuntimeException(ex);
        }

    }
}
