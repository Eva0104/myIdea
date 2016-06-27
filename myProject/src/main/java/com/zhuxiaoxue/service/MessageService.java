package com.zhuxiaoxue.service;

import com.zhuxiaoxue.dao.MessageDAO;
import com.zhuxiaoxue.entity.Message;

import java.util.List;

public class MessageService {
    private MessageDAO messageDao = new MessageDAO();

    public List<Message> findAll() {
        return messageDao.findAll();
    }

    public List<Message> findByMaxId(Integer maxId) {
        return messageDao.findByMaxId(maxId);
    }
}
