package com.zhuxiaoxue.service;

import com.zhuxiaoxue.dao.DocumentDAO;
import com.zhuxiaoxue.entity.Document;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.util.UUID;

public class DocumentService {

    private DocumentDAO dao = new DocumentDAO();

    public void updateFile(String fileName, Long size, InputStream inputStream) throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(IOUtils.toByteArray(inputStream));
        String md5 = DigestUtils.md5Hex(byteArrayInputStream);
        Document document = dao.findByMd5(md5);
        if (document == null) {
            String saveFileName = saveFile(fileName, byteArrayInputStream);

            document = new Document();

            document.setFilename(fileName);
            document.setMd5(md5);
            document.setSavename(saveFileName);
            document.setExtname(fileName.substring(fileName.indexOf(".")));
            document.setSize(size);
            document.setDisplaysize(FileUtils.byteCountToDisplaySize(size));

            dao.save(document);
        }
    }

    public String saveFile(String fileName, InputStream inputStream) throws IOException {
        inputStream.reset();

        String uuid = UUID.randomUUID().toString();
        fileName = uuid + fileName.substring(fileName.indexOf("."));

        File dir = new File("D:/new");
        if (!dir.exists()) {
            dir.mkdirs();
        }
        FileOutputStream outputStream = new FileOutputStream(new File(dir, fileName));
        IOUtils.copy(inputStream, outputStream);

        outputStream.flush();
        outputStream.close();
        inputStream.close();

        return fileName;
    }
}
