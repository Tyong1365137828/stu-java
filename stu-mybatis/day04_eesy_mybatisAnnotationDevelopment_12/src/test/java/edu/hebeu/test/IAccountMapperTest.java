package edu.hebeu.test;

import edu.hebeu.entity.Account;
import edu.hebeu.mapper.IAccountMapper;
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

public class IAccountMapperTest {
    private InputStream inputStream;
    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;
    private IAccountMapper iAccountMapper;

    @Before
    public void start() throws IOException {
        inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        sqlSessionFactory = (new SqlSessionFactoryBuilder()).build(inputStream);
        sqlSession = sqlSessionFactory.openSession();
        iAccountMapper = sqlSession.getMapper(IAccountMapper.class);
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
     * 一对一测试
     */
    @Test
    public void selectAccountAllTest() {
        List<Account> accounts = iAccountMapper.selectAccountAll();
        for (Account account : accounts) {
            System.out.println("一条account");
            System.out.println(account);
            System.out.println(account.getUser());
            System.out.println();
            System.out.println();
        }
    }

}
