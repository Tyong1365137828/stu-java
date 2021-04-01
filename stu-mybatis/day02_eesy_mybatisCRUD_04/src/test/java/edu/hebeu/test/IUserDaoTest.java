package edu.hebeu.test;

import edu.hebeu.dao.IUserDao;
import edu.hebeu.entity.User;
import edu.hebeu.entity.UserVo;
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

/**
 * 测试IUserDao接口的方法
 */
public class IUserDaoTest {

    /**声明一个用于保存主配置文件信息内容的字节流对象*/
    private InputStream inputStream;

    /**声明一个SqlSession对象*/
    private SqlSession sqlSession;

    /**声明一个IUserDao接口的对象*/
    private IUserDao iUserDao;

    /**
     * 任何测试方法执行之前会执行这个方法
     * @throws IOException
     */
    @Before
    public void startTest() throws IOException{
        System.out.println("开始测试...");
        // 1、读取主配置文件
        inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 2、获取SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = (new SqlSessionFactoryBuilder()).build(inputStream);
        // 3、获取SqlSession对象
        sqlSession = sqlSessionFactory.openSession();
        // 4、获取Dao的代理对象
        iUserDao = sqlSession.getMapper(IUserDao.class);
    }

    /**
     * 任何测试方法执行之后会执行这个方法
     * @throws IOException
     */
    @After
    public void endTest() throws IOException {
        System.out.println("测试结束");
        // 7、关闭资源
        if (sqlSession != null) {
            System.out.println("SqlSession对象关闭...");
            sqlSession.close();
        }
        if (inputStream != null) {
            System.out.println("InputStream对象关闭...");
            inputStream.close();
        }
    }

    /**
     * 测试 insertUser(User user)方法
     */
    @Test
    public void insertUserTest() {
        User user = new User();
        user.setUserAddress("陕西省渭南市");
        user.setUserBirthday(new Date());
        user.setUserSex("男");
        user.setUserName("测试009");

        System.out.println("插入之前：" + user); // 会发现user对象的id值为null

        iUserDao.insertUser(user);
        System.out.println("插入之后：" + user); // 会发现user对象的id值已经拿回来了(此时的id值就是user对象在数据库中存储的记录的id)
        sqlSession.commit(); // 提交事务(因为INSERT是DML类型的SQL语句)
    }

    /**
     * 测试 deleteUser(Integer userId)方法
     */
    @Test
    public void deleteUserTest() {
        Integer userId = 52;
        iUserDao.deleteUser(userId);
        sqlSession.commit(); // 提交事务(因为DELETE是DML类型的SQL语句)
    }

    /**
     * 测试 updateUser(User user)方法
     */
    @Test
    public void updateUserTest() {
        User user = new User();
        user.setUserId(52);
        user.setUserName("测试修改");
        user.setUserSex("女");
        user.setUserBirthday(new Date());
        user.setUserAddress("陕西省");

        iUserDao.updateUser(user);
        sqlSession.commit(); // 提交事务(因为UPDATE是DML类型的SQL语句)
    }

    /**
     * 测试 selectAll()方法
     */
    @Test
    public void selectAllTest() {
        // 5、执行方法
        List<User> users = iUserDao.selectAll();
        // 6、遍历结果集
        for (User user : users) {
            System.out.println(user);
        }
    }

    /**
     * 测试 selectUserById(Integer userId)方法
     */
    @Test
    public void selectUserByIdTest() {
        // 5、执行方法
        User user = iUserDao.selectUserById(46);
        System.out.println(user);
    }

    /**
     * 测试 selectUserCondition(User user)方法
     */
    @Test
    public void selectUserConditionTest() {
        User user = new User();
        user.setUserName("王");

        // 5、执行方法
        List<User> users = iUserDao.selectUserDim(user);
        for (User u : users) {
            System.out.println(u);
        }
    }

    /**
     * 测试 totalUser()方法
     */
    @Test
    public void totalUserTest() {
        // 5、执行方法
        int totalUser = iUserDao.totalUser();
        System.out.println("用户总记录数：" + totalUser);
    }

    /**
     * 测试 selectUserByUserVo(UserVo userVo)方法
     */
    @Test
    public void selectUserByVo() {
        // 5、执行方法
        UserVo userVo = new UserVo();
        User user = new User();
        user.setUserName("测");
        userVo.setUser(user);

        List<User> users = iUserDao.selectUserByVo(userVo);
        for (User u : users) {
            System.out.println(u);
        }

    }

}
