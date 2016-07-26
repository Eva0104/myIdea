package com.zhuxiaoxue.test;

import com.zhuxiaoxue.pojo.User;
import com.zhuxiaoxue.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.*;
import org.junit.Test;

import java.util.List;

public class CriteriaTestCase {

    @Test
    public void testFindAll(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        Criteria criteria = session.createCriteria(User.class);

        List<User> userList = criteria.list();

        for(User user : userList){
            System.out.println(user.getName());

        }
        session.getTransaction().commit();
    }


    @Test
    public void testFindByWhere(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        Criteria criteria = session.createCriteria(User.class);
        //and条件
//        criteria.add(Restrictions.eq("name","AAA"));
//        criteria.add(Restrictions.eq("password","aaa"));

        //or
//        criteria.add(Restrictions.or(Restrictions.eq("name","AAA"),
//                                    Restrictions.eq("password","123123")));

        //另外一种or的写法
//        Disjunction disjunction = Restrictions.disjunction();
//        disjunction.add(Restrictions.eq("name","AAA"));
//        disjunction.add(Restrictions.eq("password","123123"));
//
//        criteria.add(disjunction);

        //like

        criteria.add(Restrictions.like("name","E", MatchMode.ANYWHERE));
        List<User> userList = criteria.list();

        for(User user : userList){
            System.out.println(user.getName());

        }
        session.getTransaction().commit();
    }

    //分页+排序
    @Test
    public void testPage(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        Criteria criteria = session.createCriteria(User.class);
        criteria.setFirstResult(0);//分页
        criteria.setMaxResults(3);

        criteria.addOrder(Order.desc("id"));//排序

        List<User> userList = criteria.list();

        for(User user : userList){
            System.out.println(user.getName());

        }
        session.getTransaction().commit();
    }

    //获取唯一
    @Test
    public void testFindUniqueResult(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.eq("id",23));

        User user = (User) criteria.uniqueResult();

        System.out.println(user.getName());
        session.getTransaction().commit();
    }

    @Test
    public void testCount(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        Criteria criteria = session.createCriteria(User.class);
//        criteria.setProjection(Projections.rowCount());

        ProjectionList projectionList = Projections.projectionList();
        projectionList.add(Projections.rowCount());
        projectionList.add(Projections.max("id"));

        criteria.setProjection(projectionList);

        Object[] result = (Object[]) criteria.uniqueResult();

        System.out.println("Count:" + result[0]);
        System.out.println("MaxId:" + result[1]);
        session.getTransaction().commit();
    }



}
