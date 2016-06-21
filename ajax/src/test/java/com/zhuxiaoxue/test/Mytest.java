package com.zhuxiaoxue.test;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class Mytest {

    @Test
    public void testComponent() throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();

        HttpGet httpGet = new HttpGet("http://www.hao123.com");
        HttpResponse resp = httpClient.execute(httpGet);

        int httpCode = resp.getStatusLine().getStatusCode();
        if (httpCode == 200) {

            InputStream inputStream = resp.getEntity().getContent();

            String result = IOUtils.toString(inputStream);
            System.out.println(result);
        } else {
            System.out.println("请求异常 ：" + httpCode);
        }

        httpClient.close();
    }
}
