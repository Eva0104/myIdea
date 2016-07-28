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
public class BookDAO {

    @Inject
    private SessionFactory sessionFactory;

    private Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    public void save(Book book){
        getSession().saveOrUpdate(book);
    }

    public void delBook(Book book){
        getSession().delete(book);
    }

    public List<Book> findAllBook(){
        Criteria criteria = getSession().createCriteria(Book.class);
        criteria.addOrder(Order.desc("id"));
        return criteria.list();
    }

    public Book findById(Integer id){
        return (Book) getSession().get(Book.class,id);
    }

    public void delBookByid(Integer id){
        getSession().delete(findById(id));
    }
}
