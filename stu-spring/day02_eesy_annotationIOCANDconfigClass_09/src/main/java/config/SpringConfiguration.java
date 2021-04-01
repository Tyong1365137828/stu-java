package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

/**
 * 这个类的作用是一个配置类，作用和bean.xml文件一样！！！
 *  Spring的新注解：
 ***********************************************************************************************************************
 *      -@Configuration注解：
 *          作用：指定当前类是一个配置类;
 *          细节：
 *              当配置类的class 作为 AnnotationConfigApplicationContext的构造方法的参数，
 *            即 new AnnotationConfigApplicationContext(配置类.class))，该注解了可以不用标注 -@Configuration注解;
 ***********************************************************************************************************************
 *      -@ComponentScans注解：
 *          内含多个ComponentScan类型的注解;
 ***********************************************************************************************************************
 *      -@ComponentScan
 *          作用：指定Spring在创建容器时要扫描的包;
 *          关键代码：
 *              @AliasFor("basePackages")
 *              String[] value() default {};
 *
 *              @AliasFor("value")
 *              String[] basePackages() default {};
 *          因为有AliasFor别名注解互相指向彼此的属性名，因此，这两个属性在使用时都是一样的！！！
 *              -@AliasFor注解：用于指定的属性名的别名等于什么
 *          重要属性：
 *              String[] value()：指定创建IOC容器时要扫描的包(注意指定的路径必须是类路径)
 *              String[] basePackages()：同String[] value()属性(注意指定的路径必须是类路径)
 *          相当于xml文件的：
 *                  <context:component-scan base-package="edu.hebeu"/>
 *
 ***********************************************************************************************************************
 *      -@Bean注解：
 *          作用：将当前标注的方法的返回值作为bean对象添加到Spring的IOC容器中，并默认将方法名作为bean的id;
 *          关键代码：
 *              @AliasFor("name")
 *              String[] value() default {};
 *
 *              @AliasFor("value")
 *              String[] name() default {};
 *
 *              Autowire autowire() default Autowire.NO;
 *
 *              String initMethod() default "";
 *
 *              String destroyMethod() default "(inferred)";
 *          关键属性：
 *              name：用于指定bean的id，默认值是当前方法的名称;
 *          细节：
 *              当使用注解配置方法时，如果方法有参数，Spring会 根据参数名做要查找的bean的id 去容器中查找有没有可用的bean对象(查找的方式和@Autowired注解方式一样的);
 ***********************************************************************************************************************
 *          -@Import注解：
 *              作用：用于导入其他的配置类;
 *              关键代码：
*                   Class<?>[] value();
 *              属性：
*                   Class<?>[] value(); // 导入的配置类的字节码(可以导入多个配置类)
 *               注意：当使用@Import注解后，有@Import标注的注解的类就是父配置类，引入的的类就是子配置类;
 ***********************************************************************************************************************
 *          -@PropertySources注解：内含多个@PropertySource注解(一个PropertySource类型的数组)
 *
 *          -@PropertySource注解：
 *              作用：用于指定 以.properties结尾的文件的位置
 *              属性：
 *                  value：指定文件的名称和路径;
 *                      注意：classpath:文件路径 表示该文件路径在类路径下(classpath是关键字，用来指示后面的文件路径在类路径下)
 *
 */
//@Configuration
//@ComponentScan(basePackages = {"edu.hebeu", "config"})
@ComponentScan(basePackages = "edu.hebeu")
@Import(JDBCConfiguration.class)
//@EnableAspectJAutoProxy // 标注该类配置AOP相关()
public class SpringConfiguration {
}
