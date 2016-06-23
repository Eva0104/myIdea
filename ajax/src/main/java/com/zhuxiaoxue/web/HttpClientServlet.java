package com.zhuxiaoxue.web;

import com.zhuxiaoxue.util.HttpUtil;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

@WebServlet("/load")
public class HttpClientServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/xml;charset=UTF-8");
        String url = req.getParameter("url");

        String result = HttpUtil.getRequestText(url);
//        CloseableHttpClient httpClient = HttpClients.createDefault();
//
//        HttpGet httpGet = new HttpGet(url);
//        HttpResponse httpResponse = httpClient.execute(httpGet);
//        int httpCode = httpResponse.getStatusLine().getStatusCode();
//        if(httpCode == 200){
//            InputStream inputStream = httpResponse.getEntity().getContent();
//            String result = IOUtils.toString(inputStream);
//
            PrintWriter out = resp.getWriter();
            out.print(result);
            out.flush();
            out.close();
        //}
    }
}
