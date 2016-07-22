package com.zhuxiaoxue;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class SpringRedisTemplateTestCase {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void testSet(){
        stringRedisTemplate.opsForValue().set("user:2:name","jim");
    }

    @Test
    public void testGet(){
        System.out.println(stringRedisTemplate.opsForValue().get("user:2:name"));
    }

    @Test
    public void testIncr(){
        stringRedisTemplate.opsForValue().increment("user:2:age",1);
        System.out.println(stringRedisTemplate.opsForValue().get("user:2:age"));
    }

}
