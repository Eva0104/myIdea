package com.zhuxiaoxue.servic;

import com.zhuxiaoxue.dao.UserDAO;
import com.zhuxiaoxue.entity.User;
import com.zhuxiaoxue.util.MailUtil;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserServic {

    private UserDAO dao = new UserDAO();
    private String salt = "%%%%%%%%%%";
    Logger logger = LoggerFactory.getLogger(UserServic.class);

    /**
     * 用户登录
     *
     * @param username 用户名
     * @param password 密码
     * @return 如果登录成功返回User对象，登录失败则返回null
     */
    public User login(String username, String password) {
        User user = dao.queryByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            MailUtil mailUtil = new MailUtil();
            String msg = "账号" + user.getName() + "在" + DateTime.now().toString("yyyy-MM-dd hh:mm:ss") + "登录";
            String subject="账号登录信息";
            mailUtil.sendEmail(user.getAddress(),msg,subject);
            return user;
        } else {
            return null;
        }

    }

}
