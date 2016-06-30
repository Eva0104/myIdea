package com.zhuxiaoxue;

import com.zhuxiaoxue.mapper.TopicMapper;
import com.zhuxiaoxue.pojo.Topic;
import com.zhuxiaoxue.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

public class TopicMapperTest {

    private Logger logger = Logger.getLogger(TopicMapperTest.class);

    @Test
    public void testFindById(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        TopicMapper topicMapper = sqlSession.getMapper(TopicMapper.class);

        Topic topic = topicMapper.findById(1);
        logger.info(topic.getUser().getUsername());
        logger.info(topic.getNode().getNodename());

        sqlSession.close();
    }
}
