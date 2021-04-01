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
import java.util.Date;
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

    @Test
    public void insertUserTest() {
        User user = new User();
        user.setUsername("tyong");
        user.setBirthday(new Date());
        user.setSex("男");
        user.setAddress("陕西省");
        System.out.println("插入User对象之前，user = " + user);

        iUserDao.insertUser(user);
        System.out.println("插入User对象之后，user = " + user);

        sqlSession.commit();
    }

    @Test
    public void selectUserAllTest() {
        List<User> users = iUserDao.selectUserAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void selectUserDimTest() {
        User user = new User();
        user.setUsername("王");
        List<User> userList = iUserDao.selectUserDim(user);
        for (User u : userList) {
            System.out.println(u);
        }
    }

    @After
    public void end() throws IOException{
        if(inputStream != null) {
            inputStream.close();
        }
        if(sqlSession != null) {
            sqlSession.close();
        }
    }

}
