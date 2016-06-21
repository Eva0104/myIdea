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
import java.util.List;

@WebServlet("/user.xml")
public class UserXMLServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/xml;charset=UTF-8");

        PrintWriter out = resp.getWriter();
        out.print("<?xml version=\"1.0\" encoding=\"UTF_8\"?>");
        out.print("<users>");
        UserDAO dao = new UserDAO();
        List<User> userList =  dao.queryAll();
        for(User user : userList){
            out.print("<user id=\""+ user.getId() +"\"><username>"+ user.getName() +"</username><address>"+ user.getAddress() +"</address></user>");

        }
//        out.print("<user id=\"101\"><username>张无忌</username><address>Uk</address></user>");
//        out.print("<user id=\"102\"><username>张三丰</username><address>中国</address></user>");
        out.print("</users>");

        out.flush();
        out.close();
    }
}
