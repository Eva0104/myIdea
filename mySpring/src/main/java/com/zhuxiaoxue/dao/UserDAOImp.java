package com.zhuxiaoxue.dao;


import javax.inject.Named;

@Named
public class UserDAOImp implements UserDAO {

    @Override
    public Integer save() {
        System.out.println("save......");
        return 100;
    }

}
