package com.zhuxiaoxue.test;

import com.zhuxiaoxue.pojo.User;
import com.zhuxiaoxue.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

public class HibernateLIfeTestCase {

    @Test
    public void TestSave(){
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();

        User user = new User();
        user.setName("CCC");
        user.setPassword("ccc");
        user.setAddress("三C集团");

        //Integer id = (Integer) session.save(user);//save之前是自由态，经过save变成持久态

        //同save一样，persist()方法也能把自由态的对象带入持久态，不同的是save()方法执行后会返回持久化对象
        //的id,而persist()方法不会
        session.persist(user);
        //System.out.println(id);
        transaction.commit();//事务提交，session关闭变成游离态
    }

    @Test
    public void TestFindById(){
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();

        //get()和load()方法均能把一个对象带入持久态，不同的是load()方法会懒加载，即第一次使用对象是才会执行操作
        //load()方法不会返回null,get()方法则会

        //User user = (User) session.get(User.class,22);
        User user = (User) session.load(User.class,22);
        System.out.println(user.getName());
        transaction.commit();
    }

    @Test
    public void TestUpdate(){
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();

        User user = (User) session.get(User.class,23);//持久态

        transaction.commit();
        //游离态

        Session session1 = HibernateUtil.getSession();
        session1.beginTransaction();

        user.setPassword("BBB");
        session1.update(user);
        //save()和update()的区别：save()是将自由态的对象进行保存，update是将游离态的对象进行保存
        session1.getTransaction().commit();
    }

    @Test
    public void TestSaveOrUpdate(){
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();

        User user = new User();
        user.setName("DDD");
        user.setPassword("ddd");
        user.setAddress("三D集团");

        session.saveOrUpdate(user);

        transaction.commit();

        Session session1 = HibernateUtil.getSession();
        session1.beginTransaction();

        user.setPassword("DDD");
        session1.saveOrUpdate(user);
        session1.getTransaction().commit();

        //saveOrUpdate会自行判断对象的状态，若为自由态，则执行save()，若为游离态，则执行update();
    }

    @Test
    public void TestMerge(){
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();

//        User user = new User();
//        user.setName("EEE");
//        user.setPassword("eee");
//        user.setAddress("三E集团");
//
//        session.merge(user);
//        System.out.println(user.getId()); //返回为null

        User user = (User) session.get(User.class,25);

        transaction.commit();
        //--------------------------------------

        user.setPassword("EEE");

        Session session1 = HibernateUtil.getSession();

        session1.beginTransaction();

        session1.merge(user);

        session1.getTransaction().commit();

        //merge()方法不会改变对象的状态，
    }

    @Test
    public void testDel(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        User user = (User) session.get(User.class,24);
        session.delete(user);

        session.getTransaction().commit();
    }

}
