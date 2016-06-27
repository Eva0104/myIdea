package com.zhuxiaoxue.web;

import com.zhuxiaoxue.dao.UserDAO;
import com.zhuxiaoxue.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/userlog")
public class CheckUserServlet extends HttpServlet{
    private UserDAO dao = new UserDAO();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User user = dao.queryByUP(username,password);
        if(user != null){
            resp.sendRedirect("/blog");
        }else{
            resp.sendError(404);
        }
    }
}
