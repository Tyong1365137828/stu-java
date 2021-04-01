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
    private SqlSession sqlSession;
    private IUserDao iUserDao;

    @Before
    public void start() throws IOException {
        inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = (new SqlSessionFactoryBuilder()).build(inputStream);
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

    @Test
    public void selectUserAllTest() {
        List<User> users = iUserDao.selectUserAll();
        for (User user : users) {
            System.out.println("------------------------------一条用户记录----------------------------------");
            System.out.println(user);
            System.out.println(user.getAccounts());
        }
    }

    @Test
    public void selectUserByIdTest() {
        User user = iUserDao.selectUserById(50);
        System.out.println(user);
    }

}
