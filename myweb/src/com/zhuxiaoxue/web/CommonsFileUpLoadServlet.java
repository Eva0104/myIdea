package com.zhuxiaoxue.web;

import com.zhuxiaoxue.servic.DocumentService;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;


public class CommonsFileUpLoadServlet extends HttpServlet {
    private Logger logger = LoggerFactory.getLogger(CommonsFileUpLoadServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/upload.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (ServletFileUpload.isMultipartContent(req)) {
            DiskFileItemFactory factory = new DiskFileItemFactory();

            ServletContext servletContext = getServletContext();
            File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");

            factory.setRepository(repository);
            factory.setSizeThreshold(1024);

            ServletFileUpload servletFileUpload = new ServletFileUpload(factory);

            try {
                List<FileItem> fileItemList = servletFileUpload.parseRequest(req);

                for (FileItem fileItem :fileItemList) {
                    if(fileItem.isFormField()){
                        String fieldName = fileItem.getFieldName();
                        if("fileDesc".equals(fieldName)){
                            String value = fileItem.getString("UTF-8");
                        }
                    }else{
                        String fileName = fileItem.getName();
                        Long size = fileItem.getSize();
                        String contentType = fileItem.getContentType();
                        logger.debug("文件名称：" + fileName,"文件大小：" + size, "文件类型：" + contentType);

                        DocumentService document = new DocumentService();
                        document.updateFile(fileName,size,fileItem.getInputStream());

                    }
                }
            } catch (FileUploadException e) {
                e.printStackTrace();
            }
        }
    }
}
