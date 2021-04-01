package edu.hebeu.dao;

import edu.hebeu.entity.Account;

import java.util.List;

public interface IAccountDao {

    /**
     * 查询所有的账户，并将每个账户 对应的 用户 查询出来(这一个 一对一关系)
     * @return
     */
    List<Account> selectAccountAll();

    /**
     * 通过uid查询账户
     * @param userId 查询的uid
     * @return
     */
    List<Account> selectAccountByUID(Integer userId);

    /**
     * 通过条件查询出符合条件的账户
     * @param account 账户条件信息的对象
     * @return
     */
    List<Account> selectAccountDim(Account account);

}
