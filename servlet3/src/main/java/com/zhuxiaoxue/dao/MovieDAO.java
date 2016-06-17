package com.zhuxiaoxue.dao;

import com.zhuxiaoxue.entity.Movie;
import com.zhuxiaoxue.util.DbHelper;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.util.List;

public class MovieDAO {

    public List<Movie> findAll(){
        String sql = "select * from movie";
        return DbHelper.query(sql,new BeanListHandler<>(Movie.class));
    }

    public List<Movie> findByPage(int start,int size){
        String sql = "select * from movie limit ?,?";
        return DbHelper.query(sql,new BeanListHandler<>(Movie.class),start,size);
    }

    public Long getCount(){
        String sql = "select count(*) from movie";
        return DbHelper.query(sql,new ScalarHandler<Long>());
    }

}
