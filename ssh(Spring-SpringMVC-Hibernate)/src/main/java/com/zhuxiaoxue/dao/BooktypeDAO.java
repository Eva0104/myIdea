package com.zhuxiaoxue.dao;

import com.zhuxiaoxue.pojo.Booktype;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class BooktypeDAO {

    @Inject
    private SessionFactory sessionFactory;

    private Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    public List<Booktype> findAll(){
        Criteria criteria = getSession().createCriteria(Booktype.class);
        return criteria.list();
    }
}
