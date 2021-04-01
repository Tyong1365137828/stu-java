package edu.hebeu.dao.impl;

import edu.hebeu.dao.IAccountDao;
import edu.hebeu.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("accountDao")
public class AccountDaoImpl implements IAccountDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertAccount(Account account) {
        jdbcTemplate.update("INSERT INTO account(name, money) VALUES(?, ?)",
                account.getName(), account.getMoney());
    }

    public void deleteAccount(Integer accountId) {
        jdbcTemplate.update("DELETE FROM account WHERE id = ?",
                accountId);
    }

    public void updateAccount(Account account) {
        jdbcTemplate.update("UPDATE account SET name = ?, money = ? WHERE id = ?",
                account.getName(), account.getMoney(), account.getId());
    }

    public Account selectAccountById(Integer accountId) {
        List<Account> accounts = jdbcTemplate.query("SELECT id, name, money FROM account WHERE id = ?",
                new BeanPropertyRowMapper<Account>(Account.class), accountId);
        return accounts.get(0);
    }

    public Account selectAccountByName(String name) {
        List<Account> accounts = jdbcTemplate.query("SELECT id, name, money FROM account WHERE name= ?",
                new BeanPropertyRowMapper<Account>(Account.class), name);
        if (accounts.isEmpty()) {
            return null;
        }
        if (accounts.size() > 1) {
            throw new RuntimeException("edu.hebeu.dao.impl.AccountDaoImpl.selectAccountByName()方法异常，结果集不唯一！");
        }
        return accounts.get(0);
    }

}
