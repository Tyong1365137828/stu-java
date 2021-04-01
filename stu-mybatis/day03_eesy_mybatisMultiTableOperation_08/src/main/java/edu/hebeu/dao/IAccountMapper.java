package edu.hebeu.dao;

import edu.hebeu.entity.Account;

import java.util.List;

public interface IAccountMapper {

    /**
     * 查询所有的账户
     * @return 账户泛型的List集合
     */
    List<Account> selectAccountAll();

    /**
     * 查询所有账户 并且包含账户的用户信息
     *  分析：这是一个 一对一 的关系，一个account 对应 一个user
     *     主表是account，从表是user
     *      因此主表类Account 中应该定义一个 从表类User的对象
     * @return
     */
    List<Account> selectAccountAllOO();

}
