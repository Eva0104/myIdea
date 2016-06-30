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
        user.setUsername("123123");
        user.setPassword("123123");
        user.setEmail("123123");

        userMapper.save(user);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testUpdate(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = userMapper.findById(17);
        user.setPassword("111111");

        userMapper.update(user);

        sqlSession.commit();
        sqlSession.close();

    }

    @Test
    public void testDelete(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        userMapper.delete(17);
        sqlSession.commit();
        sqlSession.close();
    }


}
