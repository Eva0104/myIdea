package com.zhuxiaoxue.test;

import com.zhuxiaoxue.pojo.Topic;
import com.zhuxiaoxue.pojo.TopicContent;
import com.zhuxiaoxue.util.HibernateUtil;
import org.hibernate.Session;
import org.junit.Test;

public class OneToOne2TestCase {

    @Test
    public void testFind(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        Topic topic = (Topic) session.get(Topic.class,1);

        System.out.println(topic.getTitle());

        System.out.println(topic.getTopicContent().getContent());
        session.getTransaction().commit();
    }
}
