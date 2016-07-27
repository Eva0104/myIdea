package com.zhuxiaoxue.test;

import com.zhuxiaoxue.pojo.Task;
import com.zhuxiaoxue.util.HibernateUtil;
import org.hibernate.LockOptions;
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
    public void testUpdate() throws InterruptedException {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        Task task = (Task) session.get(Task.class,"40283881562bc1e601562bc1e9110000");

        task.setTitle("103");

        Thread.sleep(10000);

        session.getTransaction().commit();
    }

    //悲观锁
    @Test
    public void testUpdate2() throws InterruptedException {
        Session session1 = HibernateUtil.getSession();
        session1.beginTransaction();

        Task task = (Task) session1.get(Task.class,"40283881562bc1e601562bc1e9110000", LockOptions.UPGRADE);

        task.setTitle("108");

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Session session2 = HibernateUtil.getSession();
                session2.beginTransaction();

                Task task2 = (Task) session2.get(Task.class,"40283881562bc1e601562bc1e9110000");

                task2.setTitle("V-102");

                session2.getTransaction().commit();
            }
        });

        thread.start();

        Thread.sleep(5000);

        session1.getTransaction().commit();
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
