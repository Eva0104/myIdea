package com.zhuxiaoxue.action;

import com.zhuxiaoxue.pojo.User;

import java.util.ArrayList;
import java.util.List;

public class UserAction extends BaseAction{

//    private String username;
//    private String address;

    private User user;

    private List<String> names;

    public String toSave(){
        System.out.println("User save ...");
        return "success";
    }

    public String save(){
//        System.out.println("username" + username);
//        System.out.println("address" + address);

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

    //get set


//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }


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
