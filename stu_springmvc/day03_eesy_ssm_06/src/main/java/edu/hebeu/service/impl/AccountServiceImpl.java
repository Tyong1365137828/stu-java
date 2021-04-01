package edu.hebeu.service.impl;

import edu.hebeu.entity.Account;
import edu.hebeu.mapper.IAccountMapper;
import edu.hebeu.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private IAccountMapper accountMapper;

    /**
     * 添加账户的业务层代码实现
     * @param account
     */
    @Override
    public void addAccount(Account account) {
        accountMapper.insertAccount(account);
    }

    /**
     * 查询全部账户的业务层代码实现
     * @return
     */
    @Override
    public List<Account> findAccount() {
        return accountMapper.selectAccount();
    }
}
