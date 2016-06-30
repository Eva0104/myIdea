package com.zhuxiaoxue.dao;

public class UserDAOImp implements UserDAO {

    @Override
    public Integer save() {
        System.out.println("save......");
//        if(1==1){
//            throw new RuntimeException("异常.....");
//        }
        return 100;
    }

}
