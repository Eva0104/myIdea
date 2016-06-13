package com.zhuxiaoxue.test;

import org.apache.log4j.Logger;
import org.junit.Test;

public class Log4jTest {
    @Test
    public void testLog4j() {
        Logger logger = Logger.getLogger(Log4jTest.class);

        logger.trace("trance message");
        logger.debug("debug message");
        logger.info("info message");
        logger.warn("warn message");
        logger.error("error message");
        logger.fatal("fatal message");
    }
}
