package com.zhuxiaoxue;

import com.zhuxiaoxue.pojo.User;
import com.zhuxiaoxue.util.MybatisUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class test {

    @Test
    public void testFindById(){
        try {
            Reader reader = Resources.getResourceAsReader("mybatis.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            SqlSession sqlSession = sqlSessionFactory.openSession();

            User user = sqlSession.selectOne("com.zhuxiaoxue.mapper.userMapper.findById",1);

            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFindAll(){
        try {
            Reader reader = Resources.getResourceAsReader("mybatis.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            SqlSession sqlSession = sqlSessionFactory.openSession();

            List<User> userList = sqlSession.selectList("com.zhuxiaoxue.mapper.userMapper.findAll");
            for(User u : userList){
                System.out.println(u);
            }
            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testSave(){
        try {
            Reader reader = Resources.getResourceAsReader("mybatis.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            SqlSession sqlSession = sqlSessionFactory.openSession();

            User user = new User();
            user.setName("小李子");
            user.setPassword("123456");
            user.setAddress("开封");

            sqlSession.insert("com.zhuxiaoxue.mapper.userMapper.save",user);

            sqlSession.commit();
            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testUpdate(){
        try {
            Reader reader = Resources.getResourceAsReader("mybatis.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            SqlSession sqlSession = sqlSessionFactory.openSession();

            User user = sqlSession.selectOne("com.zhuxiaoxue.mapper.userMapper.findById",4);

            user.setName("大白");
            user.setPassword("111111");
            user.setAddress("开封");

            sqlSession.update("com.zhuxiaoxue.mapper.userMapper.update",user);

            sqlSession.commit();
            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDelete(){
            SqlSession sqlSession = MybatisUtil.getSqlSession();

            sqlSession.delete("com.zhuxiaoxue.mapper.userMapper.delete",13);

            sqlSession.commit();
            sqlSession.close();
    }
}
