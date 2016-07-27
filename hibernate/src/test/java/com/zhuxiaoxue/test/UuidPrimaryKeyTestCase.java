package com.zhuxiaoxue.test;

import com.zhuxiaoxue.pojo.Task;
import com.zhuxiaoxue.util.HibernateUtil;
import org.hibernate.Cache;
import org.hibernate.Session;
import org.junit.Test;

public class UuidPrimaryKeyTestCase {

    @Test
    public void testSave() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        Task task = new Task();
        task.setTitle("101");

        session.save(task);
        session.getTransaction().commit();
    }

    @Test
    public void findByid() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        Task task = (Task) session.get(Task.class, "40283881562addf801562addfa570000");

        //System.out.println(session.contains(task));
        //session.clear(); 持久态 -> 游离态  并清空一级缓存
        //session.evict(task); //将指定对象从一级缓存中清除

        session.getTransaction().commit();

        //------------------------------------------

        //将对象从二级缓存中清除
//        Cache cache = HibernateUtil.getSessionFactory().getCache();
//        cache.evictEntityRegion(Task.class);
        //cache.evictAllRegions();

        Session session2 = HibernateUtil.getSession();
        session2.beginTransaction();

        Task task2 = (Task) session2.get(Task.class, "40283881562addf801562addfa570000");

        System.out.println(task2.getTitle());

        session2.getTransaction().commit();
    }


}
