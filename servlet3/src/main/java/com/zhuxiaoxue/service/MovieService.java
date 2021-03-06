package com.zhuxiaoxue.service;

import com.zhuxiaoxue.dao.MovieDAO;
import com.zhuxiaoxue.entity.Movie;
import com.zhuxiaoxue.util.Page;

import java.util.List;

public class MovieService {
    private MovieDAO dao = new MovieDAO();

    public List<Movie> findMovie() {
        return dao.findAll();
    }

    public Page<Movie> findMovieByPage(int pageNum) {

        int totalsize = dao.getCount().intValue();//共多少条数据
        int size = 10;//每页显示10条数据

        Page<Movie> page = new Page(totalsize,pageNum,size);

        List<Movie> movieList = dao.findByPage(page.getStart(),size);
        page.setItems(movieList);
        return page;

//        int totalPageSize = totalsize / size;//共多少页
//
//        if (totalsize % size != 0) {
//            totalPageSize++;
//        }
//
//        int start = (pageNum - 1) * size;

    }
}
