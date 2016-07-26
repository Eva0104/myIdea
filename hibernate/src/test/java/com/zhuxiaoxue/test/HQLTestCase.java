package com.zhuxiaoxue.test;

import com.zhuxiaoxue.pojo.User;
import com.zhuxiaoxue.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

import java.util.List;

public class HQLTestCase {


    @Test
    public void testFindAll(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        String hql = "from User";
        Query query = session.createQuery(hql);
        List<User> userList = query.list();

        for(User user : userList){
            System.out.println(user.getId() +"---->"+ user.getName());
        }

        session.getTransaction().commit();
    }

    @Test
    public void testFindByWhere(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

//        String hql = "from User where name =? and password = ?";
//        Query query = session.createQuery(hql);
////        query.setString(0,"AAA");
////        query.setString(1,"aaa");
//         query.setParameter(0,"AAA");
//        query.setParameter(1,"aaa");

        String hql = "from User where name =:name and password = :password";
        Query query = session.createQuery(hql);
//        query.setString("name","AAA");
//        query.setString("password","aaa");

        query.setParameter("name","AAA");
        query.setParameter("password","aaa");

        List<User> userList = query.list();

        for(User user : userList){
            System.out.println(user.getId() +"---->"+ user.getName());
        }

        session.getTransaction().commit();
    }


    //获取某一列
    @Test
    public void testFindColumn(){

        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        String hql = "select name from User";
        Query query = session.createQuery(hql);
        List<String> nameList = query.list();

        for(String name : nameList){
            System.out.println(name);
        }

        session.getTransaction().commit();


    }

    //获取两列
    @Test
    public void testFindColumns(){

        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        String hql = "select name,password from User";
        Query query = session.createQuery(hql);
        List<Object[]> result  = query.list();

        for(Object[] object : result){
            System.out.println(object[0] + "--->" + object[1]);
        }

        session.getTransaction().commit();
    }


    @Test
    public void testCount(){

        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        String hql = "select count(*),max(id) from User";
        Query query = session.createQuery(hql);
        Object[] result = (Object[]) query.uniqueResult();

        System.out.println("Count:" + result[0]);
        System.out.println("Max(id):" + result[1]);

        session.getTransaction().commit();
    }

    //分页
    @Test
    public void testPage(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        String hql = "from User";
        Query query = session.createQuery(hql);

        query.setFirstResult(0);
        query.setMaxResults(3);

        List<User> userList = query.list();

        for(User user : userList){
            System.out.println(user.getId() +"---->"+ user.getName());
        }

        session.getTransaction().commit();
    }




}
