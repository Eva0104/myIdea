package com.zhuxiaoxue.test;

import com.zhuxiaoxue.pojo.Card;
import com.zhuxiaoxue.pojo.Person;
import com.zhuxiaoxue.util.HibernateUtil;
import org.hibernate.Session;
import org.junit.Test;

public class OneToOneTestCase {

    /*
     最佳实践：先存主，再存从；
     */

    @Test
    public void testSave(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        Person person = new Person();
        person.setName("tom");

        Card card = new Card();
        card.setCardname("102");
        card.setPerson(person);

        session.save(person);
        session.save(card);

        session.getTransaction().commit();
    }

    @Test
    public void testFindPerson(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        Person person = (Person) session.get(Person.class,16);

        System.out.println(person.getName() +"--->"+ person.getCard().getCardname());

        session.getTransaction().commit();
    }

    @Test
    public void testFindCard(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        Card card = (Card) session.get(Card.class,16);

        System.out.println(card.getCardname() +"--->"+ card.getPerson().getName());

        session.getTransaction().commit();
    }

    @Test
    public void testDelCard(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        Card card = (Card) session.get(Card.class,14);
        session.delete(card);

        session.getTransaction().commit();
    }

    @Test
    public void testDelPerson(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        Person person = (Person) session.get(Person.class,15);
        session.delete(person);

        session.getTransaction().commit();
    }
}
