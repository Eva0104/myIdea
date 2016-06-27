package com.zhuxiaoxue.service;

import com.zhuxiaoxue.dao.ClientDAO;
import com.zhuxiaoxue.entity.Client;

import java.util.List;

public class ClientServic {
    private ClientDAO clientDAO = new ClientDAO();

    public List<Client> findAll(){
        return clientDAO.fingAll();
    }
}
