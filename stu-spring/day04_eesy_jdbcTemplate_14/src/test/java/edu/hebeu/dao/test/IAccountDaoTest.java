package edu.hebeu.dao.test;

import edu.hebeu.dao.IAccountDao;
import edu.hebeu.entity.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IAccountDaoTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        IAccountDao accountDao = applicationContext.getBean("accountDao", IAccountDao.class);

        Account account = accountDao.selectAccountByName("aaa");
        System.out.println(account);
    }
}
