package com.zhuxiaoxue.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.UUID;

@WebServlet("/pay")
public class PayServlet extends HttpServlet{

    Logger logger = LoggerFactory.getLogger(PayServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String token = UUID.randomUUID().toString();
        HttpSession session = req.getSession();
        //把token放入session
        session.setAttribute("token",token);

        //把token放入表单
        req.setAttribute("token",token);
        req.getRequestDispatcher("/WEB-INF/views/pay.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String money = req.getParameter("money");
        //从表单中获取token
        String token = req.getParameter("token");
        //从session中获取token
        HttpSession session = req.getSession();
        String sessionToken = (String)session.getAttribute("token");

        //判断是否一致
        if(token != null && token.equalsIgnoreCase(sessionToken)){
            //将session中的token删除
            session.removeAttribute("token");
            logger.info("扣除{}元",money);
            req.getRequestDispatcher("WEB-INF/views/paysuc.jsp").forward(req,resp);
        }else {
            logger.error("表单重复提交");
            req.getRequestDispatcher("WEB-INF/views/payerror.jsp").forward(req,resp);
        }
    }
}
