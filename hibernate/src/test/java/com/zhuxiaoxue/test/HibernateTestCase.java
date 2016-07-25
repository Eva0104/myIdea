package com.zhuxiaoxue.test;

import com.zhuxiaoxue.pojo.User;
import com.zhuxiaoxue.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.Test;

import java.util.List;

public class HibernateTestCase {

    @Test
    public void testSave(){

        Configuration configuration = new Configuration().configure();

        //Hibernate 3.x
        //SessionFactory sessionFactory = configuration.buildSessionFactory();

        //Hibernate 4.3
        ServiceRegistry serviceRegistry =
                new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();

        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);

        Session session = sessionFactory.getCurrentSession();

        Transaction transaction = session.beginTransaction();

        User user = new User();
        user.setName("HHH");
        user.setPassword("000000");
        user.setAddress("火星");

        session.save(user);
        transaction.commit();
    }

    @Test
    public void TestFindById(){
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();

        User user = (User) session.get(User.class,21);
        System.out.println(user.getName());

        transaction.commit();
    }

    @Test
    public void TestUpdate(){
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();

        User user = (User) session.get(User.class,21);
        user.setPassword("11111");

        transaction.commit();
    }

    @Test
    public void TestFindAll(){
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        String hql = "from User";
        Query query = session.createQuery(hql);
        List<User> userList = query.list();

        for(User user : userList){
            System.out.println(user.getId() +"-->"+ user.getName());
        }
        transaction.commit();
    }

    @Test
    public void TestDel(){
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();

        User user = (User) session.get(User.class,21);
        session.delete(user);

        transaction.commit();
    }

}
