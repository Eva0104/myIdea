package com.zhuxiaoxue.test;

import com.zhuxiaoxue.entity.User;
import com.zhuxiaoxue.util.Config;
import com.zhuxiaoxue.util.MailUtil;
import org.apache.commons.mail.*;
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

        try {
            email.setFrom(Config.getConfig("mail.setFrom"));
            email.setSubject("练习一下 ^-^");
            email.setMsg("现在时间" + DateTime.now().toString("yyyy-MM-dd hh:mm:ss"));
            //email.addTo("342030831@qq.com");
            email.addTo("xieyue86@163.com");
            email.send();
        } catch (EmailException ex) {
            throw new RuntimeException(ex);
        }

    }

    @Test
    public void sendHtmlEmailTest() {
        HtmlEmail email = new HtmlEmail();
        email.setAuthentication(Config.getConfig("mail.username"), Config.getConfig("mail.password"));
        email.setHostName(Config.getConfig("mail.hostName"));
        email.setSmtpPort(Integer.parseInt(Config.getConfig("mail.port")));
        email.setCharset(Config.getConfig("mail.charset"));

        try {
            email.setFrom(Config.getConfig("mail.setFrom"));
            email.setSubject("练习一下 ^-^");
            email.setHtmlMsg("<h1 style=\"color:red\">练习发送Html邮件</h1>");
            //email.addTo("342030831@qq.com");
            email.addTo("342030831@qq.com");
            email.send();
        } catch (EmailException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Test
    public void sendAttEmailTest() {
        EmailAttachment ea = new EmailAttachment();
        ea.setPath("D:/朱小雪/0U00M3B-110.jpg");

        MultiPartEmail ml = new MultiPartEmail();

        ml.setAuthentication(Config.getConfig("mail.username"), Config.getConfig("mail.password"));
        ml.setHostName(Config.getConfig("mail.hostName"));
        ml.setSmtpPort(Integer.parseInt(Config.getConfig("mail.port")));
        ml.setCharset(Config.getConfig("mail.charset"));

        try{
            ml.setFrom(Config.getConfig("mail.setFrom"));
            ml.setSubject("练习一下 ^-^");
            ml.setMsg("发送带附件的邮件");
            ml.addTo("zhuxiaoxue0104@126.com");
            ml.attach(ea);
            ml.send();
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }


}
