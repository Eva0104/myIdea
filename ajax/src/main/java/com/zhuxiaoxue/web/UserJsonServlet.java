package com.zhuxiaoxue.web;

import com.google.gson.Gson;
import com.zhuxiaoxue.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/user.json")
public class UserJsonServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json;charset=UTF-8");
        List<User> userList = new ArrayList<>();
        userList.add(new User("tom","USA","123"));
        userList.add(new User("lucy","印度","456"));
        userList.add(new User("张三","中国","789"));

        String json = new Gson().toJson(userList);

        PrintWriter out = resp.getWriter();
        out.print(json);
        out.flush();
        out.close();
    }
}
