package edu.hebeu.test;

import edu.hebeu.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        // 1、通过配置文件创建IOC容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        // 2、通过配置文件的bean标签的 id属性值 创建对应的bean对象
        IAccountService iAccountService1 = applicationContext.getBean("accountService", IAccountService.class);
//        IAccountService iAccountService2 = applicationContext.getBean("accountService", IAccountService.class);

        System.out.println(iAccountService1);
//        System.out.println(iAccountService2);
//        System.out.println("iAccountService1 == iAccountService2 ?" + (iAccountService1 == iAccountService2));

        // 手动关闭容器
        ((ClassPathXmlApplicationContext) applicationContext).close();
    }
}
