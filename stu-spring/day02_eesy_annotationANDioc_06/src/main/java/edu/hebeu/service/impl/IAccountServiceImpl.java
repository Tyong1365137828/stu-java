package edu.hebeu.service.impl;

import edu.hebeu.dao.IAccountDao;
import edu.hebeu.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/**
 * 使用xml文件方式配置IOC时的关键部分：
 *      <bean id="accountService" class="edu.hebeu.service.impl.IAccountServiceImpl"
 *            scope="" init-method="" destroy-method="">
 *          <property name="" value=""或ref=""></property>
 *      </bean>
 *
 * 思考：那么在使用注解方式时就至少需要以下几种注解：
 *  用于创建对象的注解：
 *      它们的作用和xml文件的 <bean/>标签实现的功能是一样的
 *      -@Component注解：
 *          作用：把当前类对象存入Spring容器中;
 *          出现位置：在类上；
 *          属性：
 *              value：用于指定bean的id，这个属性的默认值是当前类名且首字母小写;
 *
 *  以下的三个注解它们的作用和属性与Component注解是一模一样的，是Spring为我们提供明确的三层架构使用的注解，
 *  使我们的三层对象更加清晰；
 *      -@Controller注解：一般用于表现层
 *
 *      -@Service注解：一般用于业务层
 *
 *      -@Respository注解：一般用于持久层
 *
 ***********************************************************************************************************************************
 *
 *  用于注入数据的注解：
 *      它们的作用和xml文件的 <property/>标签的作用是一样的；
 *      -@Autowired注解：
 *          作用：自动按照类型注入，只要容器中有 唯一的一个bean对象类型 和 要注入的变量类型匹配，就可以注入成功;
 *              如果IOC容器中没有任何一个bean的类型和要注入的变量类型匹配，则报错！
 *              如果IOC容器中有多个(不止一个)类型匹配时，会先圈定这些匹配的类型，之后在通过这些相同类型的变量名做要注入的bean的id
 *              去匹配圈定的类型，当匹配成功时，则对这个id的bean进行注入，否则会报错！
 *          出现的位置：可以是属性上，也可以是方法上;
 *          细节：在使用注解注入时，set方法就不是必须的了！
 *
 *      -@Qualifier注解：
 *          作用：在按照类型注入(@Autowired)的基础之上再按照名称注入。
 *          注意：
 *              它在给类成员注入时，不能单独使用，必须要和@Autowired注解配合使用；
 *              但是再给方法参数注入时可以单独使用(用来给参数指定 使用 哪个id的bean);
 *          属性：
 *              value：用于指定注入bean的id;
 *
 *      -@Resource注解：
 *          作用：直接按照bean的id注入;
 *          注意：
 *              name：用于指定bean的id;
 *
 *      以上三种方式的注入 都只能注入其他bean类型的数据，而基本类型String类型无法使用上述的注解方式实现，另外集合数据类型
 *      只能使用xml文件方式实现注入
 *
 *      -@Value注解：
 *          作用：用于注入基本类型和String类型的数据;
 *          属性：
 *              value：用于指定数据的值，它可以使用Spring中的SpEL表达式(也就是Spring中的EL表达式);
 *                  SpEL表达式的写法：${表达式}
 *
 *****************************************************************************************************************************
 *
 *  用于改变作用范围的注解：
 *      它们的作用和 <bean/>标签使用的 scope属性实现的功能是一样的
 *      -@Scope注解：
 *          作用：用于指定bean的作用范围;
 *          属性：
 *              value：指定范围的取值。常用取值：singleton(单例的)    prototype(多例的)
 *
 *******************************************************************************************************************************
 *
 *  和生命周期相关的注解(了解)：
 *      它们的作用和<bean/>标签使用的 init-method属性和destroy-method属性实现的功能是一样的
 *      -@PreDestroy注解：
 *          作用：用于指定销毁方法；
 *      -@PostConstruct注解：
 *          作用：用于指定初始化方法；
 */
//@Scope("prototype")
@Service("accountService")
public class IAccountServiceImpl implements IAccountService {

    @PostConstruct
    public void init() {
        System.out.println("IAccountServiceImpl类型初始化...");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("IAccountServiceImpl类型的bean销毁...");
    }

//    @Autowired
//    private IAccountDao iAccountDao;
//    @Autowired
//    private IAccountDao accountDao1;
//    @Autowired
//    private IAccountDao accountDao2;

    /**给属性为IAccount类型，id为accountDao1的 bean注入*/
//    @Autowired
//    @Qualifier("accountDao1")
//    private IAccountDao iAccountDao;

    @Resource(name = "accountDao1")
    private IAccountDao iAccountDao;

    public void addAccount() {
        System.out.println("调用插入账户方法...");
//        iAccountDao.insertAccount();
//        accountDao1.insertAccount();
//        accountDao2.insertAccount();

        iAccountDao.insertAccount();
    }
}
