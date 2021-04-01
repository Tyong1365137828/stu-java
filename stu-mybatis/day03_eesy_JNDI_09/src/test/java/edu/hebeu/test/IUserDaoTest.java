package edu.hebeu.test;

import edu.hebeu.entity.User;
import edu.hebeu.mapper.IUserDao;
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

/**
 * 直接使用这中方式测试Dao接口就测不出来了，因为这种方式吗，没有经过服务器，而JNDI必须要经过服务器(使用服务器实现的数据源)！！！！
 */
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
            System.out.println(user);
        }
    }

}
