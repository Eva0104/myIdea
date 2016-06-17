package com.zhuxiaoxue.service;

import com.zhuxiaoxue.entity.Movie;
import static org.junit.Assert.*;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class MovieServiceTest {
    private MovieService movieService = new MovieService();
    private Logger logger = LoggerFactory.getLogger(MovieServiceTest.class);

    @Test
    public void TestMovieService(){
        List<Movie> movies = movieService.findMovie();
        assertNotNull(movies);
    }
    @Test
    public void TestMovieByPage(){
        List<Movie> list = movieService.findMovieByPage(1);
        assertEquals(list.size(),10);
    }
}
