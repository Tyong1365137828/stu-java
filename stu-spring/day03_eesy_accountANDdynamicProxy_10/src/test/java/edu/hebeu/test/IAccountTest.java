package edu.hebeu.test;

import edu.hebeu.entity.Account;
import edu.hebeu.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@ContextConfiguration(locations = "classpath:bean.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class IAccountTest {

//    @Autowired
//    private IAccountService accountService;

    /**注入通过代理创建的accountService2Proxy对象(该对象的方法已经增强为带有事务控制的)*/
    @Autowired
    @Qualifier("accountService2Proxy")
    private IAccountService accountService;

    @Test
    public void addAccountTest() {
        Account account = new Account();
        account.setName("测试45");
        account.setMoney(3000745450f);
        accountService.addAccount(account);
    }

    @Test
    public void cutAccountTest() {
        accountService.cutAccount(5);
    }

    @Test
    public void alterAccountTest() {
        Account account = new Account();
        account.setId(5);
        account.setName("测试修改name");
        account.setMoney(585685789f);
        accountService.alterAccount(account);
    }

    @Test
    public void findAccountAllTest() {
        List<Account> accounts = accountService.findAccountAll();
        for (Account account : accounts) {
            System.out.println(account);
        }
    }

    @Test
    public void findAccountSingleTest() {
        Account account = accountService.findAccountSingle(3);
        System.out.println(account);
    }

    @Test
    public void transferTest() {
        accountService.transfer("aaa", "bbb", 200f);
    }
}
