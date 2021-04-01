package edu.hebeu.factory;

import edu.hebeu.service.IAccountService;
import edu.hebeu.util.TransactionManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 这个类用于创建Service类的代理对象的工厂
 */
public class ServiceFactory {

    private IAccountService accountService;

    private TransactionManager transactionManager;

    public final void setAccountService(IAccountService accountService) {
        this.accountService = accountService;
    }

    public void setTransactionManager(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    public IAccountService getAccountServiceAndProxy() {
        return (IAccountService) Proxy.newProxyInstance(accountService.getClass().getClassLoader(),
                accountService.getClass().getInterfaces(),
                new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object returnValue = null;
                        try {
                            // 1、开启事务
                            transactionManager.startTransaction();
                            System.out.println("事务已经开启...");
                            // 2、增强方法，执行操作
                            returnValue = method.invoke(accountService, args);
                            // 3、提交事务
                            transactionManager.commitTransaction();
                            System.out.println("事务已经提交");
                            return returnValue;
                        } catch (Exception e) {
                            e.printStackTrace();
                            // 5、如果出现异常，则回滚操作
                            transactionManager.rollbackTranscation();
                            System.out.println("事务已经回滚");
                            throw new RuntimeException("edu.hebeu.factory.ServiceFactory类型的getAccountServiceAndProxy()方法出现异常！！！");
                        } finally {
                            // 6、释放连接
                            transactionManager.release();
                            System.out.println("连接已经释放");
                        }
                    }
                });
    }
}
