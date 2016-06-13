package com.zhuxiaoxue.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/pay")
public class PayServlet extends HttpServlet{

    Logger logger = LoggerFactory.getLogger(PayServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/pay.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String money = req.getParameter("money");
        logger.info("扣除{}元",money);
        //req.getRequestDispatcher("WEB-INF/views/paysuc.jsp").forward(req,resp);
        resp.sendRedirect("/paysuc");
    }
}
