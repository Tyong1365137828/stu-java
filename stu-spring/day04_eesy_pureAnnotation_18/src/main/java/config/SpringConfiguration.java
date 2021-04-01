package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 这个类是Spring的配置类，相当于 bean.xml配置文件
 */
@Configuration // 标注这个类是Spring的配置类(相等于bean.xml)，可以不写
@ComponentScan("edu.hebeu") // Spring创建IOC容器要扫描的包
@Import({JdbcConfiguration.class, TransactionConfiguration.class}) // 导入其他的配置类
@EnableTransactionManagement // 开启Spring注解事务的支持
public class SpringConfiguration {
}
