package com.zhuxiaoxue.service;

import com.zhuxiaoxue.dao.LoginLogDAO;
import com.zhuxiaoxue.dao.UserDAO;
import com.zhuxiaoxue.pojo.LoginLog;
import com.zhuxiaoxue.pojo.User;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;

@Named
@Transactional
public class UserService {

    @Inject
    private UserDAO userDAO;
    @Inject
    private LoginLogDAO loginLogDAO;

    public void login(String username,String password,String ip){

        User user = userDAO.findByName(username);

        if(user != null && user.getPassword().equals(password)){
            loginLogDAO.save(new LoginLog(ip,user.getId()));
            throw new RuntimeException("出错了");
        }
    }
}
