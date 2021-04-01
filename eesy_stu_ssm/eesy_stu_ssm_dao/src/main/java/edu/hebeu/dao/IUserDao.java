package edu.hebeu.dao;

import edu.hebeu.domain.Role;
import edu.hebeu.domain.UserInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userDao")
public interface IUserDao {

    /**
     * 添加一条用户记录UserInfo
     * @param userInfo
     */
    @Insert("INSERT INTO users(email,username,password,phoneNum,status) " +
            " VALUES(#{email},#{username},#{password},#{phoneNum},#{status})")
    void insert(UserInfo userInfo) throws Exception;

    /**
     * 修改用户信息
     * @param userInfo
     * @throws Exception
     */
    @Update("UPDATE users SET username = #{username}, email = #{email}, password = #{password}, phoneNum = #{phoneNum}, " +
            " status = #{status} WHERE id = #{id}")
    void update(UserInfo userInfo) throws Exception;

    /**
     * 查询全部的用户记录UserInfo
     * @return
     * @throws Exception
     */
    @Select("SELECT * FROM users ORDER BY username")
    List<UserInfo> selectAll() throws Exception;

    /**
     * 通过username查询一条用户记录UserInfo
     * @param username
     * @return
     * @throws Exception
     */
    @Select("SELECT * FROM users WHERE username = #{ty}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "email", column = "email"),
            @Result(property = "password", column = "password"),
            @Result(property = "phoneNum", column = "phoneNum"),
            @Result(property = "status", column = "status"),
            @Result(property = "roles",column = "id",  javaType = java.util.List.class,
                    many = @Many(select = "edu.hebeu.dao.IRoleDao.selectByUserId"))
    })
    UserInfo selectByUsername(String username) throws Exception;

    /**
     * 通过Id精确查询一条UserInfo用户记录
     * @param userId
     * @return
     * @throws Exception
     */
    @Select("SELECT * FROM users WHERE id=#{id}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "email", property = "email"),
            @Result(column = "password", property = "password"),
            @Result(column = "phoneNum", property = "phoneNum"),
            @Result(column = "status", property = "status"),
            @Result(column = "id", property = "roles", javaType = List.class,
                    many = @Many(select = "edu.hebeu.dao.IRoleDao.selectByUserId"))
    })
    UserInfo selectById(String userId) throws Exception;

    /**
     * 查询能够为该用户添加的角色
     * @param userId
     * @return
     */
    @Select("SELECT * FROM role WHERE id NOT IN (SELECT roleId FROM users_role WHERE userId = #{ty}) ORDER BY roleName")
    List<Role> canInsertRoles(String userId) throws Exception;

    /**
     * 给该用户添加一个角色Role信息
     * @param userId
     * @param roleId
     */
    @Insert("INSERT INTO users_role(userId,roleId) VALUES(#{userId},#{roleId})")
    void insertRole(@Param("userId") String userId, @Param("roleId") String roleId) throws Exception;

    /**
     * 移除该用户的某个角色信息
     * @param userId
     * @param roleId
     * @throws Exception
     */
    @Delete("DELETE FROM users_role WHERE userId = #{userId} AND roleId = #{roleId}")
    void deleteRole(@Param("userId") String userId, @Param("roleId") String roleId) throws Exception;
}
