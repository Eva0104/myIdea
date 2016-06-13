package com.zhuxiaoxue.test;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.junit.Test;

public class Log4jTest {
    @Test
    public void testLog4j() {
        Logger logger = LoggerFactory.getLogger(Log4jTest.class);

        String name = "tom";
        String bookName="红";
        logger.trace("trance message");
        logger.debug("debug message");
        logger.info("{}借阅了{}",name,bookName);
        logger.warn("warn message");
        logger.error("error message");
    }
}
