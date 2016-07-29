package com.zhuxiaoxue.dao;

import com.zhuxiaoxue.pojo.Book;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class BookDAO extends BaseDAO<Book,Integer> {

}
