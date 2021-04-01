package edu.hebeu.factory;

import edu.hebeu.service.IAccountService;
import edu.hebeu.service.impl.IAccountServiceImpl;

/**
 * 将这个类看作是jar包中的一个工厂类，用来创建 某种bean对象
 */
public class InstanceFactory {

    /**
     * 静态方法创建IAccountService对象
     * @return
     */
    public static IAccountService getAccountServiceStatic() {
        return new IAccountServiceImpl();
    }

    /**
     * 创建 IAccountService对象
     * @return
     */
    public IAccountService getAccountService() {
        return new IAccountServiceImpl();
    }

}
