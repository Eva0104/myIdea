package com.zhuxiaoxue.util;

import com.zhuxiaoxue.exception.DataAccessException;
import org.apache.commons.dbcp2.BasicDataSource;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager {

    private static BasicDataSource dataSource = new BasicDataSource();




    static {
        Properties properties = new Properties();

        try {
            properties.load(ConnectionManager.class.getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            throw new DataAccessException("读取config.properties异常");
        }

        dataSource.setDriverClassName(properties.getProperty("jdbc.driver"));
        dataSource.setUrl(properties.getProperty("jdbc.url"));
        dataSource.setUsername(properties.getProperty("jdbc.username"));
        dataSource.setPassword(properties.getProperty("jdbc.password"));

        dataSource.setInitialSize(Integer.parseInt(properties.getProperty("jdbc.initsize","5")));
        dataSource.setMaxTotal(Integer.parseInt(properties.getProperty("jdbc.maxsize","20")));
        dataSource.setMaxWaitMillis(Integer.parseInt(properties.getProperty("jdbc.maxwait","5000")));
        dataSource.setMaxIdle(Integer.parseInt(properties.getProperty("jdbc.maxidel","10")));
        dataSource.setMinIdle(Integer.parseInt(properties.getProperty("jdbc.minidel","5")));
    }
    public static Connection getConnection() {
        try {
            Connection connection = dataSource.getConnection();
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DataAccessException("连接数据库异常");
        }
    }

    public static void closeConnection(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new DataAccessException("关闭数据库连接异常", e);
        }
    }


}
