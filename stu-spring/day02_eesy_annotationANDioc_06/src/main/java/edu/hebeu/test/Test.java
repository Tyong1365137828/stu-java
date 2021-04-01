package edu.hebeu.test;

import edu.hebeu.dao.IAccountDao;
import edu.hebeu.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    public static void main(String[] args) {
        // 1、通过配置文件指定的包下扫描相关的注解，以创建IOC仓库的内容
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("context.xml");

        IAccountService iAccountService = (IAccountService) applicationContext.getBean("accountService");
//        System.out.println(iAccountService);
//
//        IAccountDao iAccountDao = applicationContext.getBean("accountDao", IAccountDao.class);
//        System.out.println(iAccountDao);

        iAccountService.addAccount();

        IAccountService iAccountService1 = applicationContext.getBean("accountService", IAccountService.class);
        IAccountService iAccountService2 = applicationContext.getBean("accountService", IAccountService.class);
        System.out.println(iAccountService1 == iAccountService2);

        ((ClassPathXmlApplicationContext) applicationContext).close(); // 将IOC仓库销毁

    }

}
