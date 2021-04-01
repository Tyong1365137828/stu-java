package edu.hebeu.service.impl;

import edu.hebeu.dao.IAccountDao;
import edu.hebeu.entity.Account;
import edu.hebeu.service.IAccountService;

import java.util.List;

/**
 * 业务层 Account接口类的实现类
 */
public class IAccountServiceImpl implements IAccountService {

    private IAccountDao accountDao;

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    /**
     * 添加账户的方法
     * @param account
     */
    public void addAccount(Account account) {
        accountDao.insertAccount(account);
    }

    /**
     * 删除账户的方法
     * @param accountId
     */
    public void cutAccount(Integer accountId) {
        accountDao.deleteAccount(accountId);
    }

    /**
     * 修改账户的方法
     * @param account
     */
    public void alterAccount(Account account) {
        accountDao.updateAccount(account);
    }

    /**
     * 查询全部账户的方法
     * @return
     */
    public List<Account> findAccountAll() {
        return accountDao.selectAccountAll();
    }

    /**
     * 精确查询账户的方法
     * @param accountId
     * @return
     */
    public Account findAccountSingle(Integer accountId) {
        return accountDao.selectAccountById(accountId);
    }

    /**
     * 按照条件模糊查询账户的方法
     * @param account
     * @return
     */
    public List<Account> findAccountDim(Account account) {
        return null;
    }
}
