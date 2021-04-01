package edu.hebeu.test;

import edu.hebeu.entity.User;
import edu.hebeu.mapper.IUserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class IUseMapperTest {

    private InputStream inputStream;
    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;
    private IUserMapper iUserMapper;

    @Before
    public void start() throws IOException{
        inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        sqlSessionFactory = (new SqlSessionFactoryBuilder()).build(inputStream);
        sqlSession = sqlSessionFactory.openSession();
        iUserMapper = sqlSession.getMapper(IUserMapper.class);
    }

    @After
    public void end() throws IOException {
        if (inputStream != null) {
            inputStream.close();
        }
        if (sqlSession != null) {
            sqlSession.close();
        }
    }

    @Test
    public void insertUserTest() {
        User user = new User();
        user.setUsername("注解添加");
        user.setBirthday(new Date());
        user.setSex("女");
        user.setAddress("江苏省");

        iUserMapper.insertUser(user);
        sqlSession.commit();
    }

    @Test
    public void deleteUserTest() {
        iUserMapper.deleteUser(56);
        sqlSession.commit();
    }

    @Test
    public void updateUser() {
        User user = new User();
        user.setId(61);
        user.setUsername("注解修改");
        user.setBirthday(new Date());
        user.setSex("男");
        user.setAddress("浙江省");

        iUserMapper.updateUser(user);
        sqlSession.commit();
    }

    /**
     * 一对多测试
     */
    @Test
    public void selectUserAllTest() {
        List<User> users = iUserMapper.selectUserAll();
        /**for (User user : users) {
            System.out.println("---------------------------------------一条用户记录----------------------------------------");
            System.out.println(user);
            System.out.println(user.getAccounts());
            System.out.println();
            System.out.println();
        }/**/
    }

    /**
     * 测试 一级缓存
     */
    @Test
    public void testL1Load() {
        User user1 = iUserMapper.selectUserById(61);
        System.out.println(user1);

        User user2 = iUserMapper.selectUserById(61);
        System.out.println(user2);

        System.out.println("user1等于user2吗(内存地址相等吗)？" + (user1 == user2));
    }

    /**
     * 测试 二级缓存
     */
    @Test
    public void testL2Load() {
        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        IUserMapper iUserMapper1 = sqlSession1.getMapper(IUserMapper.class);
        User user1 = iUserMapper1.selectUserById(61);
        System.out.println(user1);

        sqlSession1.close(); // 关闭掉sqlSession1对象，此时sqlSession1对象的缓存区域会被清空掉，导致 一级缓存 会消失

        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        IUserMapper iUserMapper2 = sqlSession2.getMapper(IUserMapper.class);
        User user2 = iUserMapper2.selectUserById(61);
        System.out.println(user2);
        sqlSession2.close();

        System.out.println("user1 == user2吗?" + (user1 == user2));
    }

    @Test
    public void selectUserByIdTest() {
        User user = iUserMapper.selectUserById(61);
        System.out.println(user);
    }

    @Test
    public void selectUserByUsernameTest() {
        List<User> users = iUserMapper.selectUserByUsername("王");
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void selectUserTotalTest() {
        int userCount = iUserMapper.selectUserTotal();
        System.out.println("总用户数：" + userCount);
    }

}
