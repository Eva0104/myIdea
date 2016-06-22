package com.zhuxiaoxue.web;

import com.zhuxiaoxue.dao.DocumentDAO;
import com.zhuxiaoxue.entity.Document;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet("/preview")
public class PreviewServlet extends HttpServlet {
    private DocumentDAO dao = new DocumentDAO();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String md5 = req.getParameter("file");
        if(StringUtils.isNoneEmpty(md5)){
            Document document = dao.findByMd5(md5);
            if(document == null){
                resp.sendError(404);
            }else {
                String saveName = document.getSavename();
                File file = new File("D:/new",saveName);
                if(file.exists()){
                    String down = req.getParameter("down");
                    if("true".equals(down)){
                        resp.setContentType("application/octet-stream");
                        resp.setContentLength(new Long(file.length()).intValue());
                        String encodedFileName = new String(document.getFilename().getBytes("UTF-8"),"ISO8859-1");

                        resp.setHeader("Content-Disposition","attachment;filename=\"" + encodedFileName + "\"");

                    }
                    FileInputStream inputStream = new FileInputStream(file);
                    OutputStream outputStream = resp.getOutputStream();
                    IOUtils.copy(inputStream,outputStream);

                    outputStream.flush();
                    outputStream.close();
                    inputStream.close();
                }
            }

        }else{
            resp.sendError(404);

        }



    }

}
