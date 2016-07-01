package com.zhuxiaoxue.service;

import com.zhuxiaoxue.dao.UserDAO;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class UserService {

    @Inject
    private UserDAO userDAO;

    public void sayHi(){
        System.out.println("userService sayHi");
        userDAO.save();
    }
}
