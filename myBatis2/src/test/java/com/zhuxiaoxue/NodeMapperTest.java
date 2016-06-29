package com.zhuxiaoxue;

import com.zhuxiaoxue.mapper.NodeMapper;
import com.zhuxiaoxue.pojo.Node;
import com.zhuxiaoxue.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.List;

public class NodeMapperTest {

    private Logger logger = Logger.getLogger(Test.class);

    @Test
    public void testFinfbyId() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        NodeMapper nodeMapper = sqlSession.getMapper(NodeMapper.class);
        Node node = nodeMapper.findById(1);

        logger.info(node);

        sqlSession.close();

    }

    @Test
    public void testFindAll() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        NodeMapper nodeMapper = sqlSession.getMapper(NodeMapper.class);
        List<Node> nodeList = nodeMapper.findAll();
        for (Node node : nodeList) {
            logger.info(nodeList);
        }

        sqlSession.close();
    }

}
