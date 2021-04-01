package edu.hebeu.mapper;

import edu.hebeu.entity.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * 这个类学习mybatis的四个CRUD注解：
 *  有@SELECT @UPDATE @DELETE @INSERT
 *
 * 需要进行实体类的属性 与 数据库的查询结果集字段 的对应配置：
 *  通过@Results注解配置；
 * 讲解@Results注解：
 *  关键代码：
 *      @Retention(RetentionPolicy.RUNTIME)
 *      @Target({ElementType.METHOD})
 *      public @interface Results {
 *          String id() default ""; // 用来唯一标识这个@Result注解
 *
 *          Result[] value() default {}; // 用来配置 实体类对应的每个属性 和 数据库查询结果集字段
 *      }
 *
 *      Result类型：
 *          内含属性：
 *              String类型的column、property；
 *              boolean类型的id，用来标识是否为主键(是否为主键 ? true : false 默认为false)；
 *
 * 也可以直接引用上面的@Result注解
 *  通过@ResultMap注解配合要引用的@Result注解的id属性值 即可实现引用；
 *  讲解@ResultMap注解：
 *      关键代码：
 *          public @interface ResultMap {
 *              String[] value(); // 用来放置 引用的@Results注解的id属性值，可以引用多个
 *          }
 *
 */
@CacheNamespace(blocking = true) // 开启这个Interface类型的 二级缓存
public interface IUserMapper {

    /**
     * 添加用户
     * @param user
     */
    @Insert("INSERT INTO `user`(username, birthday, sex, address) VALUES(#{username}, #{birthday}, #{sex}, #{address});")
    void insertUser(User user);

    /**
     * 删除用户
     * @param userId
     */
    @Delete("DELETE FROM `user` WHERE id = #{id};")
    void deleteUser(Integer userId);

    /**
     * 修改用户
     * @param user
     */
    @Update("UPDATE `user` SET username = #{username}, birthday = #{birthday}, sex = #{sex}, address = #{address} WHERE id = #{随便写};")
    void updateUser(User user);

    /**
     * 一对多，查询全部的用户和每个用户的账户信息
     * @return
     */
    @Select("SELECT id, username, birthday, sex, address FROM `user`;")
    @Results(id = "userAccountsMap",
            value = {
                @Result(id = true, property = "id", column = "id"),

                @Result(property = "accounts", column = "id",
                        many = @Many(select = "edu.hebeu.mapper.IAccountMapper.selectAccountByUID",
                                fetchType = FetchType.LAZY))
            }
    )
    List<User> selectUserAll();

    /**
     * 通过用户id精确查询用户
     * @param userId 精确查询的用户id
     * @return
     */
    @Select("SELECT id, username, birthday, sex, address FROM `user` WHERE id = #{随便写};")
    User selectUserById(Integer userId);

    @Select("SELECT id, username, birthday, sex, address FROM `user` WHERE username LIKE CONCAT('%', #{username});")
    List<User> selectUserByUsername(String username);

    @Select("SELECT COUNT(*) FROM `user`;")
    int selectUserTotal();

}
