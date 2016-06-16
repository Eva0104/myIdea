package com.zhuxiaoxue.web;

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

@WebServlet("/upload")
@MultipartConfig
public class FileUploadServlet extends HttpServlet {

    private Logger logger = LoggerFactory.getLogger(FileUploadServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/upload.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        Part part = req.getPart("doc");
        String fileDesc = req.getParameter("fileDesc");
        logger.info("文件描述：{}", fileDesc);

        //获取的MIME头
        String contentType = part.getContentType();
        logger.info(contentType);

        //获取文件大小
        Long size = part.getSize();
        logger.info("获取文件大小{}", size);

        //获取文件名
        String fileName = getFileName(part);
        logger.info("文件名：{}", fileName);

        File dir = new File("D:/new");
        if(!dir.exists()){
            dir.mkdirs();
        }
        InputStream inputStream = part.getInputStream();
        FileOutputStream fileOutputStream = new FileOutputStream(new File(dir,fileName));

        IOUtils.copy(inputStream,fileOutputStream);

        inputStream.close();
        fileOutputStream.close();

//        BufferedInputStream bufferInput = new BufferedInputStream(inputStream);
//        BufferedOutputStream bufferOutput = new BufferedOutputStream(fileOutputStream);
//
//        byte[] buffer = new byte[1024];
//        int len = -1;
//        while((len = bufferInput.read(buffer)) != -1){
//            bufferOutput.write(buffer,0,len);
//        }
//        bufferOutput.flush();
//        bufferOutput.close();
//        bufferInput.close();
    }

    public String getFileName(Part part) {

        String fileName = part.getHeader("Content-Disposition");
        fileName = fileName.substring(fileName.indexOf("filename"));
        fileName = fileName.substring(fileName.indexOf("\"") + 1, fileName.length() - 1);
        return fileName;
    }
}
