package com.zhuxiaoxue.util;

import java.io.IOException;
import java.util.Properties;

/**
 * 读取etc文件夹下的配置文件config.properties
 * @author Eric
 */
public class Config {
    private static Properties properties = new Properties();

    static {
        try {
            properties.load(Config.class.getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getConfig(String key) {
        return properties.getProperty(key);
    }

    public static String getConfig(String key, String defultValue) {
        return properties.getProperty(key, defultValue);
    }
}
