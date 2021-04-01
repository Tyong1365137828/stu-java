package edu.hebeu.test;

import edu.hebeu.dao.IUserMapper;
import edu.hebeu.entity.Account;
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

public class IUserMapperTest {

    private InputStream inputStream;
    private SqlSession sqlSession;
    private IUserMapper iUserMapper;

    @Before
    public void start() throws IOException {
        inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = (new SqlSessionFactoryBuilder()).build(inputStream);
        sqlSession = sqlSessionFactory.openSession();
        iUserMapper = sqlSession.getMapper(IUserMapper.class);
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

    @Test
    public void selectUserAllTest() {
        List<User> users = iUserMapper.selectUserAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

    /**
     * 测试 一对多关系 的查询结果
     */
    @Test
    public void selectUserAllOM() {
        List<User> users = iUserMapper.selectUserAllOM();
        for (User user : users) {
            System.out.println("------------------------一条用户记录--------------------------");
            System.out.println(user);
//            List<Account> accounts = user.getAccounts();
//            for (Account account : accounts) {
                System.out.println(user.getAccounts());
//            }
        }
    }

    /**
     * 测试 多对多关系 的查询结果
     */
    @Test
    public void selectUserAllMM() {
        List<User> users = iUserMapper.selectUserAllMM();
        for (User user : users) {
            System.out.println("----------------------一条user记录----------------------------");
            System.out.println(user);
            System.out.println(user.getRoles());
        }
    }


}
