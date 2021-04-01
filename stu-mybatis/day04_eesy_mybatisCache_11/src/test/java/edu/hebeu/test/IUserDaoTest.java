package edu.hebeu.test;

import edu.hebeu.dao.IUserDao;
import edu.hebeu.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class IUserDaoTest {

    private InputStream inputStream;
    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;
    private IUserDao iUserDao;

    @Before
    public void start() throws IOException{
        inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        sqlSessionFactory = (new SqlSessionFactoryBuilder()).build(inputStream);
        sqlSession = sqlSessionFactory.openSession();
        iUserDao = sqlSession.getMapper(IUserDao.class);
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

    /**
     * 通过测试 updateUser();
     * 通过此例 验证测试mybatis的 缓存同步
     */
    @Test
    public void CacheSynchronizationTest() {

        // 第一次查询数据
        User user1 = iUserDao.selectUserById(56);
        System.out.println(user1);

        User user = new User();
        user.setId(56);
        user.setUsername("测试测试测试0");
        user.setAddress("北京市");
        // 更新用户
        iUserDao.updateUser(user);
        sqlSession.commit();

        // 第二次查询数据
        User user2 = iUserDao.selectUserById(56);
        System.out.println(user2);

        System.out.println("user1 == user 吗?" + (user1 == user2));
    }

    /**
     * 测试 selectUserById();
     *  通过此例 验证测试mybatis的 一级缓存
     */
    @Test
    public void testL1Cache() {
        User user1 = iUserDao.selectUserById(50);
        System.out.println(user1);

        // 如果关闭SqlSession对象，此时一级缓存就没有了，之后再创建SqlSession对象并再次查询上面的相同的数据会发现又会执行一次查询
//        sqlSession.close();
//        sqlSession = sqlSessionFactory.openSession();
//        iUserDao = sqlSession.getMapper(IUserDao.class);

        // 或者使用SqlSession的clearCache()方法 // 此方法的作用是清空缓存
//        sqlSession.clearCache();

        User user2 = iUserDao.selectUserById(50);
        System.out.println(user2);

        System.out.println("user1 == user 吗?" + (user1 == user2));
        /**
         * 观察打印台发现：
         *  只执行了一次查询，因为 使用的同一个SqlSession对象都是查询相同的值 去获取的user1和user2相等(内存地址一样)；
         */
    }

    /**
     * 通过此例 验证测试mybatis的 二级缓存
     */
    @Test
    public void testL2Cache() {
        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        IUserDao iUserDao1 = sqlSession1.getMapper(IUserDao.class);
        User user1 = iUserDao1.selectUserById(56);
        System.out.println(user1);
        sqlSession1.close(); // 关闭掉sqlSession1对象，此时sqlSession1对象的缓存区域会被清空掉，导致 一级缓存 会消失

        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        IUserDao iUserDao2 = sqlSession2.getMapper(IUserDao.class);
        User user2 = iUserDao2.selectUserById(56);
        System.out.println(user2);
        sqlSession2.close();

        System.out.println("user1 == user2吗?" + (user1 == user2));
    }

    @Test
    public void selectUserAllTest() {
        List<User> users = iUserDao.selectUserAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

}
