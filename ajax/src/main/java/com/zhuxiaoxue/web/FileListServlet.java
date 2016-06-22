package com.zhuxiaoxue.web;

import com.zhuxiaoxue.dao.DocumentDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/list")
public class FileListServlet extends HttpServlet{
    private DocumentDAO dao = new DocumentDAO();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("list",dao.findAll());
        req.getRequestDispatcher("/WEB-INF/views/fileList.jsp").forward(req,resp);
    }
}
