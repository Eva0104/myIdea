package com.zhuxiaoxue.util;

import com.zhuxiaoxue.entity.User;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MailUtil {

    private static Logger logger = LoggerFactory.getLogger(MailUtil.class);

    /**
     * 发送邮件
     *
     * @param toAddress 收件人地址
     * @param msg       内容
     * @param subject   标题
     */
    public static void sendEmail(String toAddress, String msg, String subject) {
        Email email = new SimpleEmail();
        email.setAuthentication(Config.getConfig("mail.username"), Config.getConfig("mail.password"));
        email.setHostName(Config.getConfig("mail.hostName"));
        email.setSmtpPort(Integer.parseInt(Config.getConfig("mail.port")));
        email.setCharset(Config.getConfig("mail.charset"));

        try {
            email.setFrom(Config.getConfig("mail.setFrom"));
            email.setSubject(subject);
            email.setMsg(msg);
            email.addTo(toAddress);
            email.send();
            logger.info("给{}发送邮件成功", toAddress);
        } catch (Exception ex) {
            logger.error("给{}发送邮件失败", toAddress);
            throw new RuntimeException(ex);
        }
    }
//    public static void sendEmail(User user) {
//        Email email = new SimpleEmail();
//        email.setAuthentication(Config.getConfig("mail.username"), Config.getConfig("mail.password"));
//        email.setHostName(Config.getConfig("mail.hostName"));
//        email.setSmtpPort(Integer.parseInt(Config.getConfig("mail.port")));
//        email.setCharset(Config.getConfig("mail.charset"));
//
//        try {
//            email.setFrom(Config.getConfig("mail.setFrom"));
//            email.setSubject("账号登录信息");
//            email.setMsg("账号" + user.getName() + "在" + DateTime.now().toString("yyyy-MM-dd hh:mm:ss") + "登录");
//            email.addTo(user.getAddress());
//            email.send();
//            logger.info("给{}发送邮件成功",user.getName());
//        } catch (Exception ex) {
//            logger.error("给{}发送邮件失败",user.getName());
//            throw new RuntimeException(ex);
//        }
//    }
}
