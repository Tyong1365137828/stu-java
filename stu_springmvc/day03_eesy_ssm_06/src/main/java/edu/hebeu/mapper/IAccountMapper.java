package edu.hebeu.mapper;

import edu.hebeu.entity.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("accountMapper")
public interface IAccountMapper {

    /**
     * 插入一个账户信息
     * @param account
     */
    @Insert("INSERT INTO account(name, money) VALUES(#{name}, #{money})")
    void insertAccount(Account account);

    /**
     * 查询全部账户
     * @return
     */
    @Select("SELECT id, name, money FROM account")
    List<Account> selectAccount();
}
