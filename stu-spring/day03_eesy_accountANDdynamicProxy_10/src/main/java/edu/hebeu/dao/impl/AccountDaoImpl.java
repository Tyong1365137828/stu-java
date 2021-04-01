package edu.hebeu.dao.impl;

import edu.hebeu.dao.IAccountDao;
import edu.hebeu.entity.Account;
import edu.hebeu.util.ConnectionUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class AccountDaoImpl implements IAccountDao {

    private QueryRunner queryRunner;

    private ConnectionUtil connectionUtil;

    public void setConnectionUtil(ConnectionUtil connectionUtil) {
        this.connectionUtil = connectionUtil;
    }

    public void setQueryRunner(QueryRunner queryRunner) {
        this.queryRunner = queryRunner;
    }

    public void insertAccount(Account account) {
        try {
            queryRunner.update(connectionUtil.getThreadConnection(),
                    "INSERT INTO account(name, money) VALUES(?, ?)",
                    account.getName(), account.getMoney());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteAccount(Integer accountId) {
        try {
            queryRunner.update(connectionUtil.getThreadConnection(),
                    "DELETE FROM account WHERE id = ?",
                    accountId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateAccount(Account account) {
        try {
            queryRunner.update(connectionUtil.getThreadConnection(),
                    "UPDATE account SET name = ?, money = ? WHERE id = ?",
                    account.getName(), account.getMoney(), account.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Account> selectAccountAll() {
        List<Account> accounts;
        try {
            accounts = queryRunner.query(connectionUtil.getThreadConnection(),
                    "SELECT id, name, money FROM account",
                    new BeanListHandler<Account>(Account.class));
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return accounts;
    }

    public Account selectAccountSingle(Integer accountId) {
        Account account;
        try {
            account = queryRunner.query(connectionUtil.getThreadConnection(),
                    "SELECT id, name, money FROM account WHERE id = ?",
                    new BeanHandler<Account>(Account.class),
                    accountId);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return account;
    }

    /**
     * 通过name查询账户，如果查询的结果为空或元素为0，则返回空;
     * 如果查询的结果的元素大于1，则抛出异常;
     * 如果查询结果的元素等于1，则返回查询的结果
     * @param accountName
     * @return
     */
    public Account selectAccountByName(String accountName) {
        List<Account> accounts = null;
        try {
            accounts = queryRunner.query(connectionUtil.getThreadConnection(),
                    "SELECT id, name, money FROM account WHERE name = ?",
                    new BeanListHandler<Account>(Account.class),
                    accountName);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (accounts == null || accounts.size() == 0) {
            return null;
        }
        if (accounts.size() > 1) {
            throw new RuntimeException("异常信息查询账户结果不唯一！！！");
        }
        return accounts.get(0);
    }
}
