package com.zhuxiaoxue.util;

import com.zhuxiaoxue.exception.DataAccessException;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class HttpUtil {

    public static String getRequestText(String url){
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try{
            HttpGet httpGet = new HttpGet(url);
            HttpResponse resp = httpClient.execute(httpGet);
            int httpCode = resp.getStatusLine().getStatusCode();
            if (httpCode == 200) {

                InputStream inputStream = resp.getEntity().getContent();

                String result = IOUtils.toString(inputStream);
                return result;
            } else {
                throw new RuntimeException("请求异常 ：" + httpCode);
            }
        }catch (IOException e){
           throw new RuntimeException(e);
        }finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void getRequestStream(String url,String savePath){
        CloseableHttpClient httpClient = HttpClients.createDefault();

        HttpGet httpGet = new HttpGet(url);
        try {
            HttpResponse httpResponse = httpClient.execute(httpGet);
            int httpCode = httpResponse.getStatusLine().getStatusCode();
            if(httpCode == 200){
                InputStream inputStream = httpResponse.getEntity().getContent();
                FileOutputStream outPutStream = new FileOutputStream(savePath);

                IOUtils.copy(inputStream,outPutStream);

                outPutStream.flush();
                outPutStream.close();
                inputStream.close();
            }else{
                throw new RuntimeException("请求异常："+ httpCode);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
