package edu.hebeu.test;

import edu.hebeu.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");

        /**通过构造函数注入*/
//        IAccountService iAccountService = applicationContext.getBean("accountService", IAccountService.class);
//        System.out.println(iAccountService);
//        iAccountService.addAccount();

        /**通过set方法注入*/
//        IAccountService iAccountService2 = applicationContext.getBean("accountService2", IAccountService.class);
//        System.out.println(iAccountService2);
//        iAccountService2.addAccount();

        /**通过set方法给赋值数据类型的属性注入*/
        IAccountService iAccountService3 = applicationContext.getBean("accountService3", IAccountService.class);
        System.out.println(iAccountService3);
        iAccountService3.addAccount();

    }
}
