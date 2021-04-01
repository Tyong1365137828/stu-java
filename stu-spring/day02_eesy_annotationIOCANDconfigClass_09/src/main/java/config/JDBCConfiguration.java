package config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

//@Configuration
@PropertySource("classpath:db/db.properties")
public class JDBCConfiguration {

    @Value("${mysql.jdbc.driver}")
    private String driver;

    @Value("${mysql.jdbc.url}")
    private String url;

    @Value("${mysql.jdbc.username}")
    private String username;

    @Value("${mysql.jdbc.password}")
    private String password;

    /**
     * 通过QueryRunner类的 构造方法 创建 一个QueryRunner类型的对象
     * @param dataSource
     * @return 一个QuerRunner类型的对象
     */
    @Bean(name = "queryRunner")
    @Scope("prototype")
//  public QueryRunner createQuerRunnerObj(DataSource dataSource) {
    public QueryRunner createQuerRunnerObj(@Qualifier("dataSource1") DataSource dataSource) {
        return new QueryRunner(dataSource);
    }

    /**
     * 创建DataSource类型的 数据源对象
     * @return
     */
//  @Bean(name = "dataSource")
    @Bean(name = "dataSource1")
    public DataSource createDataSourceObj() {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        try {
            comboPooledDataSource.setDriverClass(driver);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        comboPooledDataSource.setJdbcUrl(url);
        comboPooledDataSource.setUser(username);
        comboPooledDataSource.setPassword(password);

        return comboPooledDataSource;
    }
}
