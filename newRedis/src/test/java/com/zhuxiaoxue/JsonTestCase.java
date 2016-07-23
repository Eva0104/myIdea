package com.zhuxiaoxue;


import com.zhuxiaoxue.pojo.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class JsonTestCase {

    @Autowired
    RedisTemplate<String,User> redisTemplate;

    @Before
    public void setUp(){
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(User.class));
    }

    @Test
    public void testSave(){
        User user = new User(001,"jim",89.0F);
        redisTemplate.opsForValue().set("user:1",user);
    }

    @Test
    public void testGet(){
        User user = redisTemplate.opsForValue().get("user:1");
        System.out.println(user.getName());
    }

}
