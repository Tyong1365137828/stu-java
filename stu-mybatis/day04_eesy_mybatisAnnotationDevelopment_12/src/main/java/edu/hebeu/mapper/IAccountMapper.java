package edu.hebeu.mapper;

import edu.hebeu.entity.Account;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

import static org.apache.ibatis.mapping.FetchType.EAGER;

public interface IAccountMapper {

    /**
     * 一对一，查询所有的account，并且每个account对应的用户信息
     * @return
     */
    @Select("SELECT id, uid, money FROM account;")
    @Results(id = "accountUserMap",
            value = {
            @Result(id = true, property = "id", column = "id"),

            @Result(property = "user", column = "uid",
                    /**one属性值：表示account 与 property属性值对应的类型是 一对一 的关系；
                     *      ------：@One()的select属性值表示通过哪个方法，且使用column属性值为查询条件，进行此种 关系的查询；
                     *      ------：@One()的fetchType属性值：LAZY(延时加载)、EAGER(立即加载)、DEFAULT(默认加载)
                    */
                    one = @One(select = "edu.hebeu.mapper.IUserMapper.selectUserById", fetchType = EAGER))
            }
    )
    List<Account> selectAccountAll();


    /**
     * 通过用户的id查询用户的账户信息
     * @param userId
     * @return
     */
    @Select("SELECT id, uid, money FROM account WHERE uid = #{随便写};")
    List<Account> selectAccountByUID(Integer userId);

}
