package edu.hebeu.test;

import config.JDBCConfiguration;
import config.SpringConfiguration;
import edu.hebeu.entity.Account;
import edu.hebeu.service.IAccountService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Junit整合Spring的步骤：
 *  1、导入Spring整合Junit的jar包
 *      <dependency>
 *             <groupId>org.springframework</groupId>
 *             <artifactId>spring-test</artifactId>
 *             <version>5.0.2.RELEASE</version>
 *      </dependency>
 *  2、使用Junit提供的注解把原有的main()方法替换成Spring提供的运行器;
 *      如：-@Runwith(SpringJUnit4ClassRunner.class)
 *  3、告知Spring运行器，Spring的IOC创建是基于xml还是注解，并且说明位置;
 *      如：-@ContextConfiguration()
 *          属性：
 *              locations：指定xml文件的位置，加上 classpath:关键字 表示在类路下;
 *              classes：指定注解所在的位置;
 *
 *  注意：当我们使用Spring 5.x版本时，要求 Junit必须是 4.12及以上版本;
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class AccountTest {

//    private ApplicationContext applicationContext;
    @Autowired
    private IAccountService accountService;

//    @Before
//    public void start() {
        // 创建IOC容器(通过被注解标注的class配置类创建)
//        applicationContext = new AnnotationConfigApplicationContext(SpringConfiguration.class);
//        applicationContext = new AnnotationConfigApplicationContext(
//                SpringConfiguration.class,
//                JDBCConfiguration.class);
//        applicationContext = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        // 获取bean对象
//        accountService = applicationContext.getBean("accountService", IAccountService.class);

//        QueryRunner queryRunner1 = (QueryRunner) applicationContext.getBean("queryRunner");
//        QueryRunner queryRunner2 = (QueryRunner) applicationContext.getBean("queryRunner");
//        System.out.println("queryRunner1 == queryRunner2 ? " + (queryRunner1 == queryRunner2));
//    }

//    @After
//    public void end() {
//        if (applicationContext != null) {
//            ((AnnotationConfigApplicationContext) applicationContext).close();
//        }
//    }

    @Test
    public void findAccountAllTest() {
        List<Account> accounts = accountService.findAccount();
        for (Account account : accounts) {
            System.out.println(account);
        }
    }

}
