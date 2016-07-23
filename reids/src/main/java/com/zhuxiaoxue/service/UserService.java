package com.zhuxiaoxue.service;

import com.google.gson.Gson;
import com.zhuxiaoxue.pojo.User;
import com.zhuxiaoxue.util.KeyUtil;
import io.protostuff.LinkedBuffer;
import io.protostuff.Schema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Protocol;

@Service
public class UserService {

    @Autowired
    private JedisPool jedisPool;

    public Jedis getJedis(){
        return jedisPool.getResource();
    }

    public void saveUser(User user){
        Schema<User> userSchema = RuntimeSchema.getSchema(User.class);
        byte[] bytes = Protocol.toByteArray(user,userSchema,LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE));
        Jedis jedis = getJedis();
        jedis.set(KeyUtil.getKey(user.getId()).getBytes(),bytes);

        jedis.close();
    }

    public User findById(Integer userId){
        Jedis jedis = getJedis();
        String json = jedis.get(KeyUtil.getKey(userId));

        User user = new Gson().fromJson(json,User.class);

        if(user == null){
            //find from db;
        }
        jedis.close();
        return user;
    }

}
