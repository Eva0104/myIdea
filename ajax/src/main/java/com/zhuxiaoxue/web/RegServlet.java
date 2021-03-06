package com.zhuxiaoxue.web;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/reg")
public class RegServlet extends HttpServlet {
    private Logger logger = LoggerFactory.getLogger(RegServlet.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        resp.setContentType("application/json;charset=UTF-8");
        String name = req.getParameter("username");
        String password = req.getParameter("password");

        logger.info("name{}",name);
        logger.info("password{}",password);

        PrintWriter out = resp.getWriter();
        out.print(new Gson().toJson("yes"));
        out.flush();
        out.close();

    }
}
