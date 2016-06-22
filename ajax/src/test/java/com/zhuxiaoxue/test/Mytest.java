package com.zhuxiaoxue.test;

import com.zhuxiaoxue.util.HttpUtil;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
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

    @Test
    public void testGetImag() throws IOException {

        Document document =  Jsoup.connect("http://www.topit.me/pop?p=1").cookie("is_click","1").get();

        Elements elements = document.select("#content .catalog .e>a");

        for(Element element:elements){
            String href = element.attr("href");
            Document img = Jsoup.connect(href).cookie("is_click","1").get();
            Elements imgElement = img.select("#content>a");

            String imgSrc = imgElement.attr("href");
            String fileName = imgSrc.substring(imgSrc.lastIndexOf("/") + 1);
            HttpUtil.getRequestStream(imgSrc,"D:/load/"+ fileName);
        }

    }

    @Test
    public void testGetImg() throws IOException {
        Document document = Jsoup.connect("http://www.topit.me/tag/星空").cookie("is_click","1").get();
        Elements elements = document.select("#content .catalog .e>a");

        for(Element element : elements){
            String href = element.attr("href");
            Document img = Jsoup.connect(href).cookie("is_click","1").get();
            Element imgElement = img.select("#content>a").first();

            String imgSrc = imgElement.attr("href");
            String fileName = imgSrc.substring(imgSrc.lastIndexOf("/")+1);
            HttpUtil.getRequestStream(imgSrc,"D:/load/" + fileName);
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
