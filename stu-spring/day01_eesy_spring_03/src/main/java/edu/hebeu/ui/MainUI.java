package edu.hebeu.ui;

import edu.hebeu.dao.IAccountDao;
import edu.hebeu.service.IAccountService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import javax.annotation.Resources;

public class MainUI {

    /**
     * 获取Spring的IOC核心容器，并根据id创建对象；
     *
     *  ApplicationContext接口的三个常用实现类：
     *      ClassPathXmlApplicationContext：它可以加载类路径下的配置文件，要求加载的配置文件必须在类路径下；否则无法使用
     *      FileSystemXmlApplicationContext：它可以加载磁盘任意路径下的配置文件(必须要有访问权限)
     *      AnnotationConfigApplicationContext：它是用于读取注解创建容器的
     *
     *
     *  核心容器的两个接口引发出的问题：
     *      ApplicationContext：单例对象适用       实际开发中使用最多
     *          它在创建核心容器时，创建对象采取的策略是采用立即加载的方式，也就是说，只要以读取完配置文件马上就创建配置文件中配置的对象；
     *      BeanFactory：多例对象适用
     *          它在创建核心容器时，创建对象采取的策略是采用延迟加载的方式，也就是说，什么时候根据id获取对象了什么时候才创建真正的对象；
     *
     * @param args
     */
    public static void main(String[] args) {
//        applicationContextTest();
        beanFactoryTest();
    }

    /**
     * 通过ApplicationContext接口创建的核心容器对象
     */
    public static void applicationContextTest() {
        // 1、通过配置文件获取核心容器对象
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
//        ApplicationContext applicationContext = new FileSystemXmlApplicationContext("D:\\programme\\code\\java\\idea-space\\stu-spring\\day01_eesy_spring_03\\src\\main\\resources\\bean.xml");

        // 2、通过id获取Bean对象
        IAccountService iAccountService = (IAccountService) applicationContext.getBean("accountService"); // 此方式需要进行强转
        IAccountDao iAccountDao = applicationContext.getBean("accountDao", IAccountDao.class); // 也可以在传入一个 对应类型的字节码(类型.class)，会自动根据这个字节码获取对应的类型，不用强转

        System.out.println(iAccountService);
        System.out.println(iAccountDao);
    }

    /**
     * 通过BeanFactory接口创建的核心容器对象
     */
    public static void beanFactoryTest() {
        // 1、获取配置文件
        Resource resource = new ClassPathResource("bean.xml");
        // 2、通过读取的配置文件 创建 BeanFactory对象
        BeanFactory beanFactory = new XmlBeanFactory(resource);
        // 3、通过id创建bean对象
        IAccountDao iAccountDao = beanFactory.getBean("accountDao", IAccountDao.class);
        IAccountService iAccountService = beanFactory.getBean("accountService", IAccountService.class);

        System.out.println(iAccountDao);
        System.out.println(iAccountService);
    }

}
