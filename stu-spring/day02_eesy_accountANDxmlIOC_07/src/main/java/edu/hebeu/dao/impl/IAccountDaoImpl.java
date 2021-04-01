package edu.hebeu.dao.impl;

import edu.hebeu.dao.IAccountDao;
import edu.hebeu.entity.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * 持久层 Account接口类的实现类
 */
public class IAccountDaoImpl implements IAccountDao {

    private QueryRunner queryRunner;

    public void setQueryRunner(QueryRunner queryRunner) {
        this.queryRunner = queryRunner;
    }

    /**
     * 添加账户
     * @param account
     */
    public void insertAccount(Account account) {
        try {
            queryRunner.update("INSERT INTO account(name, money) VALUES(?, ?)",
                    account.getName(), account.getMoney());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除账户
     * @param accountId
     */
    public void deleteAccount(Integer accountId) {
        try {
            queryRunner.update("DELETE FROM account WHERE id = ?",
                    accountId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 修改账户
     * @param account
     */
    public void updateAccount(Account account) {
        try {
            queryRunner.update("UPDATE account SET name = ?, money = ? WHERE id = ?",
                    account.getName(), account.getMoney(), account.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 查询数据库的account表的全部信息
     * @return
     */
    public List<Account> selectAccountAll() {
        List<Account> accounts = null;
        try {
            accounts =  queryRunner.query("SELECT id, name, money FROM account",
                    new BeanListHandler<Account>(Account.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accounts;
    }

    /**
     * 通过id精确查询账户信息
     * @param accountId
     * @return
     */
    public Account selectAccountById(Integer accountId) {
        Account account = null;
        try {
            account = queryRunner.query("SELECT id, name, money FROM account WHERE id = ?",
                    new BeanHandler<Account>(Account.class),
                    accountId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return account;
    }

    /**
     * 通过条件模糊查询账户 Account
     * @param account
     * @return
     */
    public List<Account> selectAccountByCondition(Account account) {
        return null;
    }

}
