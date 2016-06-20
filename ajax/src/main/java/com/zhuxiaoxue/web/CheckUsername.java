package com.zhuxiaoxue.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/checkUsername")
public class CheckUsername extends HttpServlet{
    private Logger logger = LoggerFactory.getLogger(CheckUsername.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        username = new String(username.getBytes("ISO8859-1"),"UTF-8");
        logger.info(username);
        PrintWriter out = resp.getWriter();
        if("tom".equals(username)){
            out.print("no");
        }else {
            out.print("yes");
        }
        out.flush();
        out.close();
    }
}
