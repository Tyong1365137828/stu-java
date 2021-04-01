package edu.hebeu.service.impl;

import edu.hebeu.dao.IAccountDao;
import edu.hebeu.entity.Account;
import edu.hebeu.service.IAccountService;
import edu.hebeu.util.TransactionManager;

import java.util.List;

public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao;

    private TransactionManager transactionManager;

    public void setTransactionManager(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public void addAccount(Account account) {
        try {
            // 1、开启事务
            transactionManager.startTransaction();
            // 2、执行操作
            accountDao.insertAccount(account);
            // 3、提交事务
            transactionManager.commitTransaction();
        } catch (Exception e) {
            e.printStackTrace();
            // 5、如果出现异常，则回滚操作
            transactionManager.rollbackTranscation();
        } finally {
            // 6、释放连接
            transactionManager.release();
        }
    }

    public void cutAccount(Integer accountId) {
        try {
            // 1、开启事务
            transactionManager.startTransaction();
            // 2、执行操作
            accountDao.deleteAccount(accountId);
            // 3、提交事务
            transactionManager.commitTransaction();
        } catch (Exception e) {
            e.printStackTrace();
            // 5、如果出现异常，则回滚操作
            transactionManager.rollbackTranscation();
        } finally {
            // 6、释放连接
            transactionManager.release();
        }
    }

    public void alterAccount(Account account) {
        try {
            // 1、开启事务
            transactionManager.startTransaction();
            // 2、执行操作
            accountDao.updateAccount(account);
            // 3、提交事务
            transactionManager.commitTransaction();
        } catch (Exception e) {
            e.printStackTrace();
            // 5、如果出现异常，则回滚操作
            transactionManager.rollbackTranscation();
        } finally {
            // 6、释放连接
            transactionManager.release();
        }
    }

    public List<Account> findAccountAll() {
        try {
            // 1、开启事务
            transactionManager.startTransaction();
            // 2、执行操作
            List<Account> accounts = accountDao.selectAccountAll();
            // 3、提交事务
            transactionManager.commitTransaction();
            // 4、返回结果
            return accounts;
        } catch (Exception e) {
            e.printStackTrace();
            // 5、如果出现异常，则回滚操作
            transactionManager.rollbackTranscation();
            /**程序执行到此，表示没有正常的返回结果*/
            return null;
        } finally {
            // 6、释放连接
            transactionManager.release();
        }
    }

    public Account findAccountSingle(Integer accountId) {
        try {
            // 1、开启事务
            transactionManager.startTransaction();
            // 2、执行操作
            Account account = accountDao.selectAccountSingle(accountId);
            // 3、提交事务
            transactionManager.commitTransaction();
            // 4、返回结果
            return account;
        } catch (Exception e) {
            e.printStackTrace();
            // 5、如果出现异常，则回滚操作
            transactionManager.rollbackTranscation();
            return null;
        } finally {
            // 6、释放连接
            transactionManager.release();
        }
    }

    public void transfer(String sourceName, String targetName, Float money) {

        try {
            // 1、开启事务
            transactionManager.startTransaction();
            // 2、执行操作
            // 2.1、根据名称查询转出账户
            Account accountSource = accountDao.selectAccountByName(sourceName);
            // 2。2、根据名称查询转入账户
            Account accountTarget = accountDao.selectAccountByName(targetName);
            // 2.3、转出账户减钱
            accountSource.setMoney(accountSource.getMoney() - money);
            // 2.4、转入账户加钱
            accountTarget.setMoney(accountTarget.getMoney() + money);
            // 2.5、更新转出账户
            accountDao.updateAccount(accountSource);

            int i = 1/0; // 模拟一个异常

            // 2.6、更新转入账户
            accountDao.updateAccount(accountTarget);

            // 3、提交事务
            transactionManager.commitTransaction();

        } catch (Exception e) {
            e.printStackTrace();
            // 5、如果出现异常，则回滚操作
            transactionManager.rollbackTranscation();
        } finally {
            // 6、释放连接
            transactionManager.release();
        }

    }

}
