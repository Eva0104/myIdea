package com.zhuxiaoxue.action;

import com.zhuxiaoxue.pojo.User;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class UserAction extends BaseAction{


    private User user;

    private List<String> names;

    private String code;

    public String toSave(){
        System.out.println("User save ...");
        return "success";
    }

    public String save(){

        System.out.println("username" + user.getUsername());
        System.out.println("address" + user.getAddress());
        return "success";
    }

    public String list(){
        names = new ArrayList<>();
        names.add("A1");
        names.add("A2");
        names.add("A3");
        names.add("A4");
        return "success";
    }

    public String login(){
        if("tom".equals(user.getUsername()) && "123".equals(user.getAddress())){
            HttpSession session = getHttpSession();
            session.setAttribute("curr_user",user.getUsername());
            return SUCCESS;
        }else {
            code = "10009";
            return INPUT;
        }
    }

    //get set
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }
}
