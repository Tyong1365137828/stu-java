package edu.hebeu.dao.impl;

import edu.hebeu.dao.IAccountDao;
import edu.hebeu.entity.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository("accountDao")
public class IAccountDaoImpl implements IAccountDao {

    @Autowired
    private QueryRunner queryRunner;

    public void insertAccount(Account account) {
        try {
            queryRunner.update("INSERT INTO account(name, money) VALUES(?, ?)",
                    account.getName(), account.getMoney());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteAccount(Integer accountId) {
        try {
            queryRunner.update("DELETE FROM account WHERE id = ?", accountId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateAccount(Account account) {
        try {
            queryRunner.update("UPDATE account SET name = ?, money = ? WHERE id = ?",
                    account.getName(), account.getMoney(), account.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Account> selectAccount() {
        try {
            return queryRunner.query("SELECT id, name, money FROM account",
                    new BeanListHandler<Account>(Account.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Account> selectAccount(Account account) {
        return null;
    }

    public Account selectAccount(Integer accountId) {
        try {
            return queryRunner.query("SELECT id, name, money FROM account WHERE id = ?",
                    new BeanHandler<Account>(Account.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
