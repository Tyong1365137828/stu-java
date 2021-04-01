package edu.hebeu.test;

import edu.hebeu.dao.IUserDao;
import edu.hebeu.dao.impl.UserDaoImpl;
import edu.hebeu.entity.User;
import edu.hebeu.entity.UserVo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * IUserDao接口的测试类
 */
public class IUserDaoTest {

    private InputStream inputStream;
    private IUserDao iUserDao;

    @Before
    public void start() throws IOException {
        System.out.println("开始测试...");
        // 1、读取主配置文件
        inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 2、创建SqlSessionFactory工厂对象
        SqlSessionFactory sqlSessionFactory = (new SqlSessionFactoryBuilder()).build(inputStream);
        // 3、使用工厂对象和多态机制创建dao的impl对象
        iUserDao = new UserDaoImpl(sqlSessionFactory);
    }

    /**
     * 测试 insertUser(User user)方法
     */
    @Test
    public void insertUserTest() {
        User user = new User();
        user.setUsername("测试1111");
        user.setBirthday(new Date());
        user.setSex("男");
        user.setAddress("浙江省");
        System.out.println("插入User对象之前，user = " + user);

        iUserDao.insertUser(user);
        System.out.println("插入User对象之后，user = " + user);
    }

    /**
     * 测试 deleteUser()方法
     */
    @Test
    public void deleteUserTest() {
        Integer userId = 57;
        iUserDao.deleteUser(userId);
    }

    /**
     * 测试 updateUser()方法
     */
    @Test
    public void updateUserTest() {
        User user = new User();
        user.setId(53);
        user.setUsername("测试修改");
        user.setBirthday(new Date());
        user.setSex("女");
        user.setAddress("浙江省");

        iUserDao.updateUser(user);
    }

    /**
     * 测试 selectUserAll()方法
     */
    @Test
    public void selectUserAllTest() {
        List<User> users = iUserDao.selectUserAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

    /**
     * 测试 selectUserById()方法
     */
    @Test
    public void selectUserByIdTest() {
        Integer userId = 54;
        User user = iUserDao.selectUserById(userId);
        System.out.println(user);
    }

    /**
     * 测试 selectUserTotal()方法
     */
    @Test
    public void selectUserTotalTest() {
        int userCount = iUserDao.selectUserTotal();
        System.out.println(userCount);
    }

    /**
     * 测试 selectUserByVoDim()方法
     */
    @Test
    public void selectUserByVoDimTest() {
        UserVo userVo = new UserVo();
        User user = new User();
        user.setUsername("测");
        userVo.setUser(user);

        List<User> users = iUserDao.selectUserByVoDim(userVo);
        for (User u : users) {
            System.out.println(u);
        }
    }

    @After
    public void end() throws IOException {
        System.out.println("结束测试...");
        if(inputStream != null) {
            System.out.println("关闭InputStream对象");
            inputStream.close();
        }
    }

}
