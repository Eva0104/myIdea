package com.zhuxiaoxue.service;

import com.zhuxiaoxue.dao.UserDAO;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class BookService {

    private String bookName;
    private Integer num;
    private List<String> lits;
    private Map<String,Object> maps;
    private Set<String> sets;
    private Properties properties;
    private UserDAO userDAO;

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public void setLits(List<String> lits) {
        this.lits = lits;
    }

    public void setMaps(Map<String, Object> maps) {
        this.maps = maps;
    }

    public void setSets(Set<String> sets) {
        this.sets = sets;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void showBook() {
        System.out.println( "BookService{" +
                "bookName='" + bookName + '\'' +
                ", num=" + num +
                ", lits=" + lits +
                ", maps=" + maps +
                ", sets=" + sets +
                ", properties=" + properties +
                ", " +
                '}');
        userDAO.sayHello();
    }
}
