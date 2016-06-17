package com.zhuxiaoxue.web;

import com.zhuxiaoxue.entity.Movie;
import com.zhuxiaoxue.service.MovieService;

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

        int page = Integer.parseInt(req.getParameter("p"));

        List<Movie> movieList = movieService.findMovieByPage(page);
        req.setAttribute("movie",movieList);
        req.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(req,resp);
    }
}
