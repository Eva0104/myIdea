package com.zhuxiaoxue.web;

import com.zhuxiaoxue.util.HttpUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/dict")
public class DictServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String p = req.getParameter("word");
        p = new String(p.getBytes("ISO8859-1"),"UTF-8");
        resp.setContentType("text/xml;charset=UTF-8");
        String url = "http://fanyi.youdao.com/openapi.do?keyfrom=kaishengit&key=1587754017&type=data&doctype=xml&version=1.1&q=" + p;

        String result = HttpUtil.crestHttpClient(url);
        PrintWriter out = resp.getWriter();
        out.print(result);
        out.flush();
        out.close();
    }
}
