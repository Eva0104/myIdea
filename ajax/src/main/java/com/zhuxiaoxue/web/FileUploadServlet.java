package com.zhuxiaoxue.web;

import com.zhuxiaoxue.service.DocumentService;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.util.UUID;

@WebServlet("/servlet3")
@MultipartConfig

public class FileUploadServlet extends HttpServlet {
    private Logger logger = LoggerFactory.getLogger(FileUploadServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/servlet3Upload.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String fileDesc = req.getParameter("fileDesc");
        Part part = req.getPart("doc");
        logger.debug(fileDesc);
        String contentType = part.getContentType();
        Long size = part.getSize();
        String fileName = getFileName(part);
        logger.debug(fileName);
        String uuid = UUID.randomUUID().toString();
        fileName = uuid + fileName.substring(fileName.indexOf("."));
        InputStream inputStream = part.getInputStream();
        DocumentService service = new DocumentService();
        service.saveFile(fileName,inputStream);

//        fileName = uuid + fileName.substring(fileName.indexOf("."));
//        File dir = new File("D:/new");
//        if(!dir.exists()){
//            dir.mkdirs();
//        }
//        InputStream inputStream = part.getInputStream();
//        FileOutputStream outputStream = new FileOutputStream(new File(dir,fileName));
//        IOUtils.copy(inputStream,outputStream);
//        inputStream.close();
//        outputStream.close();

    }
    public String getFileName(Part part){
        String fileName = part.getHeader("Content-Disposition");
        fileName = fileName.substring(fileName.indexOf("filename="));
        fileName = fileName.substring(fileName.indexOf("\"")+1,fileName.length()-1);
        return fileName;
    }
}
