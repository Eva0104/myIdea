package com.zhuxiaoxue;

import com.zhuxiaoxue.mapper.UserMapper;
import com.zhuxiaoxue.pojo.User;
import com.zhuxiaoxue.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class UserMapperTest {

    private Logger logger = LoggerFactory.getLogger(UserMapperTest.class);

    @Test
    public void testFindById(){

        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = userMapper.findById(1);
        logger.info("{}",user);
        Assert.assertNotNull(user);

        sqlSession.close();

    }

    @Test
    public void testFindAll(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        List<User> userList = userMapper.findAll();
        for(User user : userList){
            logger.info("{}",user);
        }

        sqlSession.close();
    }

    @Test
    public void testSave(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = new User();
        user.setName("范范");
        user.setPassword("123123");
        user.setAddress("开封");

        userMapper.save(user);

        sqlSession.commit();
        sqlSession.close();

    }

    @Test
    public void testUpdate(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = userMapper.findById(11);
        user.setName("等等");

        userMapper.update(user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testDelete(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        userMapper.delete(12);
        sqlSession.commit();
        sqlSession.close();
    }
}
