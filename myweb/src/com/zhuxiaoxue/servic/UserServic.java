package com.zhuxiaoxue.servic;

import com.zhuxiaoxue.dao.UserDAO;
import com.zhuxiaoxue.entity.User;
import org.apache.commons.codec.digest.DigestUtils;
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
        DigestUtils.md5Hex(password + salt);
        if (user != null && user.getPassword().equals(DigestUtils.md5Hex(password + salt))) {
            return user;
        } else {

            return null;
        }

    }

}
