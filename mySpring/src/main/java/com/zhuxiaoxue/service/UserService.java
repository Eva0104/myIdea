package com.zhuxiaoxue.service;

import com.zhuxiaoxue.dao.UserDAO;

public class UserService {


    //TOC(控制翻转) DI(依赖注入)
    //1.set注入
    private UserDAO userDAO;

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    //构造方法注入

//    public UserService(UserDAO userDAO){
//        this.userDAO = userDAO;
//    }

    public void sayHi(){
        System.out.println("userService sayHi");
        userDAO.sayHello();
    }
}
