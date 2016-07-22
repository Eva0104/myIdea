package com.zhuxiaoxue;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

    @Test
    public void testSaveHash(){
        Map<String,String> map = new HashMap<String, String>();
        map.put("address","USA");
        map.put("age","23");

        stringRedisTemplate.opsForHash().putAll("student:1",map);
    }

    @Test
    public void testGetHash(){
        System.out.println(stringRedisTemplate.opsForHash().get("student:1","age"));
    }

    @Test
    public void testSaveSet(){
        stringRedisTemplate.opsForSet().add("students","jim","tom","lucy","rose");
    }

    @Test
    public void testGetSet(){
        Set<String> set = stringRedisTemplate.opsForSet().members("students");

        for(String stu:set){
            System.out.println(stu);
        }
    }

    @Test
    public void testSaveList(){
        stringRedisTemplate.opsForList().leftPush("numbers","b");
    }

    @Test
    public void testGetList(){
        List<String> list = stringRedisTemplate.opsForList().range("numbers",0,-1);
        for(String str :list){
            System.out.println(str);
        }
    }
}
