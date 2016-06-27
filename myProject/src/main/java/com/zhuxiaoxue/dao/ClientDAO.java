package com.zhuxiaoxue.dao;

import com.zhuxiaoxue.entity.Client;
import com.zhuxiaoxue.util.DbHelper;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.List;

public class ClientDAO {
    public List<Client> fingAll(){
        String sql = "select * from client";
        return DbHelper.query(sql,new BeanListHandler<>(Client.class));
    }
}
