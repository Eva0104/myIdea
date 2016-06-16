package com.zhuxiaoxue.dao;

import com.zhuxiaoxue.entity.Document;
import com.zhuxiaoxue.util.DbHelper;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.List;

public class DocumentDAO {

    public void save(Document doucument) {
        String sql = "INSERT INTO document (filename,savename,md5,extname,size,displaysize) VALUES (?,?,?,?,?,?)";
        DbHelper.update(sql, doucument.getFilename(), doucument.getSavename(), doucument.getMd5(), doucument.getExtname(), doucument.getSize(), doucument.getDisplaysize());
    }

    public Document findByMd5(String md5) {
        String sql = "select * from document where md5=?";
        return DbHelper.query(sql, new BeanHandler<>(Document.class), md5);
    }

    public List<Document> findAll() {
        String sql="select * from document";
        return DbHelper.query(sql,new BeanListHandler<Document>(Document.class));
    }
}

