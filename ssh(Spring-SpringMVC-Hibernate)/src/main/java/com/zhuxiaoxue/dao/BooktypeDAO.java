package com.zhuxiaoxue.dao;

import com.zhuxiaoxue.pojo.Booktype;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class BooktypeDAO extends BaseDAO<Booktype,Integer>{

}
