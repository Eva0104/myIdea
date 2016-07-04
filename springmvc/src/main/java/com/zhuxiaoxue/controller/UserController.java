package com.zhuxiaoxue.controller;

import com.zhuxiaoxue.pojo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model){

        User user1 = new User("user1","address1","password1");
        User user2 = new User("user2","address2","password2");
        User user3 = new User("user3","address3","password3");

        List<User> userList = new ArrayList<User>();

        userList.add(user1);
        userList.add(user2);
        userList.add(user2);

        model.addAttribute(userList);

        return "/users/list";
    }


    @RequestMapping(value = "/new",method = RequestMethod.GET)
    public String add(){
        return "/users/user";
    }

    @RequestMapping( value = "/new",method = RequestMethod.POST)
    public String getUser(User user){

        logger.info("userName:{} userPassword:{} userAddress:{}",user.getName(),user.getPassword(),user.getAddress());
        return "redirect:/users/new";
    }

    @RequestMapping( value = "/news",method = RequestMethod.GET)
    @ResponseBody
    public String getUserString(){

       return "Json";
    }

    @RequestMapping(value = "/{id}.json",method = RequestMethod.GET)
    @ResponseBody
    public User getUserJson(){
        User user = new User("张三丰","123","USA");
        return user;
    }

    @RequestMapping("/nativ")
    public String nativeHttpServlet(HttpServletRequest request,
                                    HttpServletResponse response,
                                    HttpSession session){
        ServletContext context = session.getServletContext();
        context.setAttribute("curr_user","jim");
        return "home";

    }


    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public String user(@PathVariable Integer id){
        System.out.println(id);
        return "/users/user";
    }





}
