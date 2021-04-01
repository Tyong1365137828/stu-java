package edu.hebeu.jdbc;

import edu.hebeu.entity.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * JDBCTemplate的最基本用法
 */
public class JDBCTemplateDemo1 {

    public static void main(String[] args) {
        // 准备数据源，使用Spring的内置数据源
        /**DriverManagerDataSource dds = new DriverManagerDataSource();
        dds.setDriverClassName("com.mysql.jdbc.Driver");
        dds.setUrl("jdbc:mysql://localhost:3306/eesy_spring");
        dds.setUsername("root");
        dds.setPassword("072731");

        // 1、创建JDBCTemplate对象
//        JdbcTemplate jdbcTemplate = new JdbcTemplate(dds);
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dds);*/

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);

        // 2、执行操作
//        jdbcTemplate.execute("INSERT  INTO account(name, money) VALUES('ddddb', 1000.57);");

        // 保存操作
//        jdbcTemplate.update("INSERT INTO account(name, money) VALUES(?, ?)", "test添加", 200.01);

        // 更新
//        jdbcTemplate.update("UPDATE account SET name = ?, money = ? WHERE id = ?", "测试修改", 1003.25, 6);

        // 删除
//        jdbcTemplate.update("DELETE FROM account WHERE id = ?", 6);

        // 查询多个，使用自定义的封装策略
        List<Account> accounts = jdbcTemplate.query("SELECT id, name, money FROM account WHERE money > ?",
                new AccountRowMapper(), 2000f);

        // 查询多个(使用Spring中的封装策略)
//        List<Account> accounts = jdbcTemplate.query("SELECT id, name, money FROM account WHERE money > ?",
//                new BeanPropertyRowMapper<Account>(Account.class), 1000f);
        for (Account account : accounts) {
            System.out.println(account);
        }

        // 查询一个
//        List<Account> account = jdbcTemplate.query("SELECT id, name, money FROM account WHERE id = ?",
//                new BeanPropertyRowMapper<Account>(Account.class) , 1);
//        System.out.println(account.isEmpty() ? "没有找到数据" : account.get(0));

        // 查询一行一列(不使用 ORDER BY 的基础上使用聚集函数)
//        Long count = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM account WHERE money > ?",
//                Long.class, 1600f);
//        System.out.println(count);

//        Integer count2 = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM account WHERE money > ?",
//                Integer.class, 1600f);
//        System.out.println(count2);

    }
}

/**
 * 自定义Account的封装策略
 */
class AccountRowMapper implements RowMapper<Account> {

    public Account mapRow(ResultSet resultSet, int i) throws SQLException {
        Account account = new Account();
        account.setId(resultSet.getInt("id"));
        account.setName(resultSet.getString("name"));
        account.setMoney(resultSet.getFloat("money"));

        return account;
    }
}