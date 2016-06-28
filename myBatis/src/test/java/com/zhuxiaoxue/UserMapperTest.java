package com.zhuxiaoxue;

import com.zhuxiaoxue.mapper.UserMapper;
import com.zhuxiaoxue.pojo.User;
import com.zhuxiaoxue.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserMapperTest {
    private Logger logger = Logger.getLogger(UserMapperTest.class);

    @Test
    public void testFindById() {

        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user =  userMapper.findById(1);

        sqlSession.close();
        
        SqlSession sqlSession2 = MybatisUtil.getSqlSession();
        UserMapper userMapper2 = sqlSession2.getMapper(UserMapper.class);

        User user2 =  userMapper2.findById(1);

        sqlSession2.close();

    }

    @Test
    public void testFindAll() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        List<User> userList = userMapper.findAll();

        sqlSession.close();
    }

    @Test
    public void testSave() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = new User();
        user.setName("上官玉清");
        user.setPassword("000000");
        user.setAddress("郑州");

        userMapper.save(user);

        sqlSession.commit();
        sqlSession.close();

    }

    @Test
    public void testUpdate() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = userMapper.findById(11);
        user.setName("等等");

        userMapper.update(user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testDelete() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        userMapper.delete(12);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testFindQueryParams() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        Map<String, Object> map = new HashMap<>();
        map.put("username", "等等");
        map.put("password", "5566");
        map.put("address", "郑州");

        List<User> userList = userMapper.findByQueryParams(map);
        for (User user :userList) {
            logger.info(user);
        }
        
        sqlSession.close();
    }

    @Test
    public void testBatchSave(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        List<User> userList = new ArrayList<>();

        User user1 = new User("大白","123","焦作");
        User user2 = new User("小白","321","漯河");

        userList.add(user1);
        userList.add(user2);

        userMapper.batchSave(userList);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testFindByparams(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = userMapper.findByParams("等等","5566");

        sqlSession.close();
    }


}
