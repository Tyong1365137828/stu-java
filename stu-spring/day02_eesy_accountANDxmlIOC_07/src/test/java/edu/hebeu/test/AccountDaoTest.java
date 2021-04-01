package edu.hebeu.test;

import edu.hebeu.entity.Account;
import edu.hebeu.service.IAccountService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@ContextConfiguration(locations = "classpath:bean.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class AccountDaoTest {

//    private ApplicationContext applicationContext;
    @Autowired
    private IAccountService iAccountService;

    /**
     * 任何方法测试执行之前执行这个方法
     */
//    @Before
//    public void startTest() {
//         1、获取IOC容器
//        applicationContext = new ClassPathXmlApplicationContext("bean.xml");
//         2、获取业务层对象
//        iAccountService = applicationContext.getBean("accountService", IAccountService.class);
//    }

    /**
     * 在测试完成的最后执行这个方法
     */
//    @After
//    public void endTest() {
//        ((ClassPathXmlApplicationContext) applicationContext).close(); // 将IOC仓库销毁
//    }

    /**
     * 测试条件Account
     */
    @Test
    public void addAccountTest() {
        Account account = new Account();
        account.setName("测试账户");
        account.setMoney(4525744541.14f);
        iAccountService.addAccount(account);
    }

    /**
     * 测试删除Account
     */
    @Test
    public void cutAccountTest() {
        iAccountService.cutAccount(4);
    }

    /**
     * 测试修改Account
     */
    @Test
    public void alterAccountTest() {
        Account account = new Account();
        account.setId(4);
        account.setName("测试修改");
        account.setMoney(8584845845.415f);
        iAccountService.alterAccount(account);
    }

    /**
     * 测试查询全部Account
     */
    @Test
    public void findAccountAllTest() {
        List<Account> accounts = iAccountService.findAccountAll();
        for (Account account : accounts) {
            System.out.println(account);
        }
    }

    /**
     * 测试精确查询Account
     */
    @Test
    public void findAccountSingleTest() {
        Account account = iAccountService.findAccountSingle(2);
        System.out.println(account);
    }

}
