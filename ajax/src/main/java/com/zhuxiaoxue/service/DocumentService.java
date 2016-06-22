package com.zhuxiaoxue.service;

import org.apache.commons.io.IOUtils;

import java.io.*;
import java.util.UUID;

public class DocumentService {

    public void saveFile(String fileName, InputStream inputStream) throws IOException {
        String uuid = UUID.randomUUID().toString();
        fileName = uuid + fileName.substring(fileName.indexOf("."));

        File dir = new File("D:/new");
        if(!dir.exists()){
            dir.mkdirs();
        }
        FileOutputStream outputStream = new FileOutputStream(new File(dir,fileName));
        IOUtils.copy(inputStream,outputStream);

        outputStream.flush();
        outputStream.close();
        inputStream.close();
    }
}
