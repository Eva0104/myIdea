package com.zhuxiaoxue.util;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.io.InputStream;

public class HttpUtil {

    public static String crestHttpClient() throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();

        HttpGet httpGet = new HttpGet("http://blog.sina.com.cn/rss/1220218113.xml");
        HttpResponse resp = httpClient.execute(httpGet);

        int httpCode = resp.getStatusLine().getStatusCode();
        if (httpCode == 200) {

            InputStream inputStream = resp.getEntity().getContent();

            String result = IOUtils.toString(inputStream);

            return result;

        } else {
            System.out.println("请求异常 ：" + httpCode);

        }
        httpClient.close();
        return null;
    }
}
