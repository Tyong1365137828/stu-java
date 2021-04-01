package edu.hebeu.test;

import edu.hebeu.dao.IAccountMapper;
import edu.hebeu.entity.Account;
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
    private SqlSession sqlSession;
    private IAccountMapper iAccountMapper;

    @Before
    public void start() throws IOException {
        inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = (new SqlSessionFactoryBuilder()).build(inputStream);
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

    @Test
    public void selectAccountAllTest() {
        List<Account> accounts = iAccountMapper.selectAccountAll();
        for (Account account : accounts) {
            System.out.println(account);
        }
    }

    /**
     * 测试 一对一 关系 查询的数据
     */
    @Test
    public void selectUserAllOOTest() {
        List<Account> accounts = iAccountMapper.selectAccountAllOO();
        for (Account account : accounts) {
            System.out.println("-----------------一条完整的account数据(一对一)");
            System.out.println(account);
            System.out.println(account.getUser());
        }
    }

}
