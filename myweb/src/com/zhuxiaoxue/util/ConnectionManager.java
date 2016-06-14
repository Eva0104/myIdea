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
      /*  Properties properties = new Properties();

        try {
            properties.load(ConnectionManager.class.getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            throw new DataAccessException("读取config.properties异常");
        }*/

        dataSource.setDriverClassName(Config.getConfig("jdbc.driver"));
        dataSource.setUrl(Config.getConfig("jdbc.url"));
        dataSource.setUsername(Config.getConfig("jdbc.username"));
        dataSource.setPassword(Config.getConfig("jdbc.password"));

        dataSource.setInitialSize(Integer.parseInt(Config.getConfig("jdbc.initsize", "5")));
        dataSource.setMaxTotal(Integer.parseInt(Config.getConfig("jdbc.maxsize", "20")));
        dataSource.setMaxWaitMillis(Integer.parseInt(Config.getConfig("jdbc.maxwait", "5000")));
        dataSource.setMaxIdle(Integer.parseInt(Config.getConfig("jdbc.maxidel", "10")));
        dataSource.setMinIdle(Integer.parseInt(Config.getConfig("jdbc.minidel", "5")));
    }

    public static BasicDataSource getDataSource() {
        return dataSource;
    }

    public static Connection getConnection() {
        try {
            Connection connection = dataSource.getConnection();
            return connection;
        } catch (SQLException e) {
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
