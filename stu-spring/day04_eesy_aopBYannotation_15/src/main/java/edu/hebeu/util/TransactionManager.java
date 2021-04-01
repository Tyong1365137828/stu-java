package edu.hebeu.util;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

/**
 * 事务管理相关类;
 *  包含：
 *      开启事务
 *      提交事务
 *      回滚事务
 *      释放连接
 */
@Component("transactionManager")
@Aspect // 表示当前类是一个切面类
public class TransactionManager {

    @Autowired
    private ConnectionUtil connectionUtil;

    /**
     * 切入点表达式
     */
    @Pointcut("execution(* edu.hebeu.service.impl.*.*(..))")
    private void executionExpression(){}

    /**
     * 开启事务
     *  设置为前置通知
     */
//    @Before("executionExpression()")
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
     * 设置为后置通知
     */
//    @AfterReturning("executionExpression()")
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
     *  设置为异常通知
     */
//    @AfterThrowing("executionExpression()")
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
     *  设置为最终通知
     */
//    @After("executionExpression()")
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

    /**
     * 因为使用注解配置的AOP的通知类型执行有问题，这里使用环绕通知来实现环绕通知内的 前置、后置、异常、最终 通知
     * @param pjp
     * @return
     */
    @Around("executionExpression()")
    public Object aroundAdvice(ProceedingJoinPoint pjp) {
        Object rtValue = null;
        // 1、获取要执行方法的参数列表
        Object[] args = pjp.getArgs();
        try {
            // 2、开启事务(前置)
            this.startTransaction();
            // 3、执行切入点方法
            rtValue = pjp.proceed(args);
            // 4、提交事务(后置)
            this.commitTransaction();
            // 返回结果
            return rtValue;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            // 异常
            this.rollbackTranscation();
            throw new RuntimeException("edu.hebeu.util.TransactionManager.aroundAdvice()异常！");
        } finally {
            // 最终
            this.release();
        }
    }
}
