package com.zhuxiaoxue;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class RedisStringTestCase {


    @Autowired
    private JedisPool jedisPool;

    private Jedis jedis = null;

    @Before
    public void getJedis() {
//        jedis = new Jedis("192.168.184.128");
        jedis = jedisPool.getResource();
    }

    @After
    public void close() {
        if (jedis != null) {
            jedis.close();
        }
    }

    @Test
    public void testSet() {
        jedis.set("product:1:num","10");

    }

    @Test
    public void testGet(){
        String name = jedis.get("user:1:name");
        System.out.println(name);
    }

    @Test
    public void testIncr(){
        jedis.incr("eric:1:viewnum");
    }

    @Test
    public void testIncrby(){
        jedis.incrBy("eric:1:viewnum",10);
    }

    @Test
    public void testIncrByFloat(){
        jedis.incrByFloat("eric:1:viewnum",10.2F);
    }

    @Test
    public void testDecr(){
        jedis.decr("product:1:num");
    }

    @Test
    public void testAppend(){
        jedis.append("user:1:name","jim");
    }

    @Test
    public void testStrlen(){
        System.out.println(jedis.strlen("user:1:name"));
    }

    @Test
    public void testMset(){
        jedis.mset("user:2:name","jim","user:3:name","lucy");
    }

    @Test
    public void testMget(){
        List<String> list = jedis.mget("user:1:name","user:2:name","user:3:name");
        for(String str : list){
            System.out.println(str);
        }
    }


}
