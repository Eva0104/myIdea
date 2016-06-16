package com.zhuxiaoxue.web;

import com.zhuxiaoxue.dao.DocumentDAO;
import com.zhuxiaoxue.entity.Document;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet("/filelist")
public class FileListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DocumentDAO dao = new DocumentDAO();
        List<Document> list = dao.findAll();
        req.setAttribute("list",list);
        req.getRequestDispatcher("/WEB-INF/views/fileList.jsp").forward(req,resp);
    }
}
