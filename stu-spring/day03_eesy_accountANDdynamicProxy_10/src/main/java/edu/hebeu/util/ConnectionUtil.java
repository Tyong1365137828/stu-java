package edu.hebeu.util;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionUtil {

    private ThreadLocal<Connection> threadLocals = new ThreadLocal<Connection>();

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * 获取当前线程上的连接
     * @return
     */
    public Connection getThreadConnection() {
        // 1、先从ThreadLocal上获取
        Connection connection = threadLocals.get();
        // 2、判断当前线程上是否有连接
        if (connection == null) {
            // 3、从数据源中获取一个连接，并且存入threadLocals中(与当前线程绑定)
            try {
                connection = dataSource.getConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            threadLocals.set(connection);
        }
        // 4、返回当前线程上的连接
        return connection;
    }

    /**
     * 把连接和线程解绑
     */
    public void removeConnection() {
        threadLocals.remove();
    }
}
