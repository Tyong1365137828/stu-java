package edu.hebeu.custom_mybatis.util;

import edu.hebeu.custom_mybatis.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * 用于创建数据源的工具类
 */
public class DataSourceUtil {

    /**
     * 用于获取一个连接
     * @param cfg
     * @return
     */
    public static Connection getConnection(Configuration cfg){
        try {
            Class.forName(cfg.getDriver()); // 注册驱动
            return DriverManager.getConnection(cfg.getUrl(), cfg.getUsername(), cfg.getPassword()); // 通过url、用户名、密码获取Connection连接对象
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}
