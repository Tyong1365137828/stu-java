package edu.hebeu.util;

import java.sql.SQLException;

/**
 * 事务管理相关类;
 *  包含：
 *      开启事务
 *      提交事务
 *      回滚事务
 *      释放连接
 */
public class TransactionManager {

    private ConnectionUtil connectionUtil;

    public void setConnectionUtil(ConnectionUtil connectionUtil) {
        this.connectionUtil = connectionUtil;
    }

    /**
     * 开启事务
     */
    public void startTransaction() {
        try {
            // 将自动提交关闭
            connectionUtil.getThreadConnection().setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 提交事务
     */
    public void commitTransaction() {
        try {
            // 提交事务
            connectionUtil.getThreadConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 回滚事务
     */
    public void rollbackTranscation() {
        try {
            // 回滚事务
            connectionUtil.getThreadConnection().rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 关闭连接
     */
    public void release() {
        try {
            // 将连接归还入线程池(不是关闭连接)
            connectionUtil.getThreadConnection().close();
            // 进行解绑
            connectionUtil.removeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
