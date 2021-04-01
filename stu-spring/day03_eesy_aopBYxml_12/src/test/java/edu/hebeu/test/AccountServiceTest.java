package edu.hebeu.test;

import edu.hebeu.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试AOP的配置
 */
public class AccountServiceTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("aop.xml");
        IAccountService accountService = applicationContext.getBean("accountService", IAccountService.class);
        accountService.addAccount();
//        accountService.deleteAccount();
    }
}
