package edu.hebeu.test;

import edu.hebeu.entity.Account;
import edu.hebeu.service.IAccountService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class IAccountTest {

    private ApplicationContext applicationContext;
    private IAccountService accountService;

    @Before
    public void start() {
        applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        accountService = applicationContext.getBean("accountService", IAccountService.class);
    }

    @After
    public void end() {
        ((ClassPathXmlApplicationContext) applicationContext).close();
    }

    @Test
    public void findAccountAllTest() {
        List<Account> accounts = accountService.findAccountAll();
        for (Account account : accounts) {
            System.out.println(account);
        }
    }
}
