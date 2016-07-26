package com.zhuxiaoxue.test;

import com.zhuxiaoxue.pojo.User;
import com.zhuxiaoxue.util.HibernateUtil;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.junit.Test;

import java.util.List;

public class SQLTestCase {

    @Test
    public void testFindAll(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        String sql = "select * from student ORDER by id DESC limit 0,3";

//        SQLQuery sqlQuery = session.createSQLQuery(sql);
//        List<Object[]> result = sqlQuery.list();
//        for (Object[] user:result){
//            System.out.println(user[0] + "--->" + user[1]);
//        }

        SQLQuery sqlQuery = session.createSQLQuery(sql).addEntity(User.class);
        List<User> userList = sqlQuery.list();

        for(User user : userList){
            System.out.println(user.getId() +"-->"+user.getName());
        }

        session.getTransaction().commit();
    }

    @Test
    public void testFindByid(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        String sql = "select * from student where id = ?";
        SQLQuery sqlQuery = session.createSQLQuery(sql);
        sqlQuery.setParameter(0,"25");

        List<Object[]> result = sqlQuery.list();
        for(Object[] objects : result){
            System.out.println(objects[0] + "-->" + objects[1]);
        }
        session.getTransaction().commit();
    }

    @Test
    public void testPage(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        String sql = "select * from student";

        SQLQuery sqlQuery = session.createSQLQuery(sql).addEntity(User.class);
        sqlQuery.setFirstResult(3);
        sqlQuery.setMaxResults(5);

        List<User> userList = sqlQuery.list();

        for(User user : userList){
            System.out.println(user.getId() +"-->"+user.getName());
        }
        session.getTransaction().commit();
    }



}
