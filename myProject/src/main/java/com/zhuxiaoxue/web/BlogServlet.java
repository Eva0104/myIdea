package com.zhuxiaoxue.web;

import com.zhuxiaoxue.entity.Client;
import com.zhuxiaoxue.entity.Message;
import com.zhuxiaoxue.service.ClientServic;
import com.zhuxiaoxue.service.MessageService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/blog")
public class BlogServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ClientServic clientService = new ClientServic();
        List<Client> client = clientService.findAll();
        req.setAttribute("client",client);
        req.getRequestDispatcher("/WEB-INF/views/blog.jsp").forward(req,resp);
    }
}
