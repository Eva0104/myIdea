package com.zhuxiaoxue.dao;


import com.zhuxiaoxue.entity.Message;
import com.zhuxiaoxue.util.DbHelper;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.List;

public class MessageDAO {

    public List<Message> findAll() {
        String sql = "select * from message ORDER by id DESC ";
        return DbHelper.query(sql, new BeanListHandler<>(Message.class));
    }

    public List<Message> findByMaxId(Integer maxId) {
        String sql = "select * from message  where id > ? ORDER by id DESC";
        return DbHelper.query(sql, new BeanListHandler<>(Message.class), maxId);
    }
}
