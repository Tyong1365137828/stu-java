package edu.hebeu.service.impl;

import edu.hebeu.dao.IAccountDao;
import edu.hebeu.entity.Account;
import edu.hebeu.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("accountService")
public class IAccountServiceImpl implements IAccountService {

    @Autowired
    private IAccountDao accountDao;

    public void addAccount(Account account) {
        accountDao.insertAccount(account);
    }

    public void cutAccount(Integer accountId) {
        accountDao.deleteAccount(accountId);
    }

    public void alterAccount(Account account) {
        accountDao.updateAccount(account);
    }

    public List<Account> findAccountAll() {
        return accountDao.selectAccountAll();
    }

    public Account findAccountSingle(Integer accountId) {
        return accountDao.selectAccountById(accountId);
    }

    public List<Account> findAccountDim(Account account) {
        return accountDao.selectAccountByCondition(account);
    }
}
