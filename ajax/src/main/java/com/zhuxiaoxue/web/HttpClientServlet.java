package com.zhuxiaoxue.web;

import com.zhuxiaoxue.util.HttpUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/load")
public class HttpClientServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/xml;charset=UTF-8");

        String result = HttpUtil.crestHttpClient();
        PrintWriter out = resp.getWriter();
        out.print(result);
        out.flush();
        out.close();
    }
}
