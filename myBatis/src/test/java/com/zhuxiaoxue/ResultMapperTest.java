package com.zhuxiaoxue;

import com.zhuxiaoxue.mapper.ResultMapper;
import com.zhuxiaoxue.pojo.Result;
import com.zhuxiaoxue.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

public class ResultMapperTest {
    private Logger logger = Logger.getLogger(ResultMapperTest.class);

    @Test
    public void testFindById(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        ResultMapper resultMapper = sqlSession.getMapper(ResultMapper.class);

        Result result = resultMapper.findById(1);
        logger.info(result.getUser().getAddress());
        logger.info(result.getSubject().getName());

        sqlSession.close();

    }
}
