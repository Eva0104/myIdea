package com.zhuxiaoxue.web;

import com.google.gson.Gson;
import com.zhuxiaoxue.entity.Message;
import com.zhuxiaoxue.service.MessageService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/message")
public class MessageServlet extends HttpServlet {
    private MessageService messageService = new MessageService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Message> messageList = messageService.findAll();
        int maxId = 0;
        if (!messageList.isEmpty()) {
            maxId = messageList.get(0).getId();
        }
        req.setAttribute("maxId", maxId);
        req.setAttribute("messageList", messageList);

        req.getRequestDispatcher("/WEB-INF/views/message.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int maxId = Integer.parseInt(req.getParameter("maxId"));
        List<Message> messageList = messageService.findByMaxId(maxId);

        resp.setContentType("application/json;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.print(new Gson().toJson(messageList));
        out.flush();
        out.close();
    }
}
