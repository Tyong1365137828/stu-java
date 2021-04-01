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
import java.util.ArrayList;
import java.util.List;

public class IUserDaoTest {

    private InputStream inputStream;
    private SqlSession sqlSession;
    private IUserDao iUserDao;

    @Before
    public void start() throws IOException{
        inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = (new SqlSessionFactoryBuilder()).build(inputStream);
//        sqlSession = sqlSessionFactory.openSession(true); // 设置事务自动提交(每执行一次DML语句就提交一次事务)
        sqlSession = sqlSessionFactory.openSession();
        iUserDao = sqlSession.getMapper(IUserDao.class);
    }

    @After
    public void end() throws IOException {
        if(inputStream != null) {
            inputStream.close();
        }
        if(sqlSession != null) {
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

    @Test
    public void selectUserById() {
        User user = iUserDao.selectUserById(50);
        System.out.println(user);
    }

    @Test
    public void selectUserDim() {
        User user = new User();
        user.setUsername("王");
        user.setSex("女");

        List<User> users = iUserDao.selectUserDim(user);
        for (User u : users) {
            System.out.println(u);
        }
    }

    /**
     * 测试通过包装类查询
     * 测试 where、if、foreach标签的使用
     */
    @Test
    public void selectUserByVo() {
        User user = new User();
        List<Integer> userIds = new ArrayList<Integer>();
        userIds.add(56);
        userIds.add(59);
        userIds.add(42);
        userIds.add(41);
        user.setUsername("王");
        UserVo userVo = new UserVo();
//        userVo.setUser(user);
        userVo.setUserIds(userIds);

        List<User> users = iUserDao.selectUserByVo(userVo);
        for (User u : users) {
            System.out.println(u);
        }
    }

}
