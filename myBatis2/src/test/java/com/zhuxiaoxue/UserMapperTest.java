package com.zhuxiaoxue;

import com.zhuxiaoxue.mapper.UserMapper;
import com.zhuxiaoxue.pojo.User;
import com.zhuxiaoxue.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

public class UserMapperTest {
    private Logger logger = Logger.getLogger(UserMapperTest.class);

    @Test
    public void testFindById(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = userMapper.findById(10);
        logger.info(user);

        sqlSession.close();
    }
    @Test
    public void testFindByParams(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = userMapper.findByParams("James","123123");
        logger.info(user);
        sqlSession.close();
    }

    @Test
    public void testSave(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = new User();
        user.setUsername("Eric");
        user.setPassword("000000");
        user.setEmail("342030831@qq.com");

        userMapper.save(user);

        sqlSession.commit();
        sqlSession.close();
    }


}
