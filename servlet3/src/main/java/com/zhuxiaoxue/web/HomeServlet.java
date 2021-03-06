package com.zhuxiaoxue.web;

import com.zhuxiaoxue.entity.Movie;
import com.zhuxiaoxue.service.MovieService;
import com.zhuxiaoxue.util.Page;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/home")
public class HomeServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        MovieService movieService = new MovieService();
        String p = req.getParameter("p");
        int pg = 1;
        if(StringUtils.isNumeric(p)){
            pg = Integer.parseInt(p);
        }
        Page<Movie> page = movieService.findMovieByPage(pg);
        req.setAttribute("page",page);
        req.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(req,resp);
    }
}
