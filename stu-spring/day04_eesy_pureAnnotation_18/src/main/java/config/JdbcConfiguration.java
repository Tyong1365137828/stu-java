package config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * 和连接数据库相关的类
 */
@PropertySource("db.properties")
public class JdbcConfiguration {

    @Value("${mysql.jdbc.driver}")
    private String driver;
    @Value("${mysql.jdbc.url}")
    private String url;
    @Value("${mysql.jdbc.username}")
    private String username;
    @Value("${mysql.jdbc.password}")
    private String password;

    /**
     * 创建JdbcTemplate对象
     * @param dataSource
     * @return
     */
    @Bean("jdbcTemplate") // 将这个类的返回值放入IOC容器，并将 key设为 jdbcTemplate
    public JdbcTemplate createJdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    /**
     * 创建一个数据源对象
     * @return
     */
    @Bean("dataSource") //
    public DataSource createDataSource() {
        DriverManagerDataSource dms = new DriverManagerDataSource();
        dms.setDriverClassName(driver);
        dms.setUrl(url);
        dms.setUsername(username);
        dms.setPassword(password);
        return dms;
    }
}
