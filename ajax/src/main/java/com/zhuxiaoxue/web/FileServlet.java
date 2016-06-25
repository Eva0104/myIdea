package com.zhuxiaoxue.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

@WebServlet("/file")
@MultipartConfig
public class FileServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Part part = req.getPart("file");
        String name = getFileName(part);
        System.out.println(name);
    }
    public String getFileName(Part part){
        String fileName = part.getHeader("Content-Disposition");
        fileName = fileName.substring(fileName.indexOf("filename="));
        fileName = fileName.substring(fileName.indexOf("\"")+1,fileName.length()-1);
        return fileName;
    }
}
