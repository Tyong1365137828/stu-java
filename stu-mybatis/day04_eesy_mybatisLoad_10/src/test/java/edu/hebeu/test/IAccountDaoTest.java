package edu.hebeu.test;

import edu.hebeu.dao.IAccountDao;
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

public class IAccountDaoTest {

    private InputStream inputStream;
    private SqlSession sqlSession;
    private IAccountDao iAccountDao;

    @Before
    public void start() throws IOException {
        inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = (new SqlSessionFactoryBuilder()).build(inputStream);
        sqlSession = sqlSessionFactory.openSession();
        iAccountDao = sqlSession.getMapper(IAccountDao.class);
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
        List<Account> accounts = iAccountDao.selectAccountAll();
        for (Account account : accounts) {
            System.out.println("---------------------------一条account记录---------------------------------");
            System.out.println(account);
            System.out.println(account.getUser());
            System.out.println();
            System.out.println();
        }
    }

    @Test
    public void selectAccountDim() {
        Account account = new Account();
        account.setUid(46);
        List<Account> accounts = iAccountDao.selectAccountDim(account);
        for (Account a : accounts) {
            System.out.println(a);
        }
    }

}
