package edu.hebeu.test;

import edu.hebeu.custom_mybatis.io.Resources;
import edu.hebeu.custom_mybatis.session.SqlSession;
import edu.hebeu.custom_mybatis.session.SqlSessionFactory;
import edu.hebeu.custom_mybatis.session.SqlSessionFactoryBuilder;
import edu.hebeu.dao.IUserDao;
import edu.hebeu.entity.User;

import java.io.InputStream;
import java.util.List;

public class Test {
    public static void main(String[] args) throws Exception{
        // 1.读取配置文件
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        // 3.使用工厂生产SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 4.使用动态代理(使用SqlSession创建Dao接口的代理对象)
        IUserDao iUserDao = sqlSession.getMapper(IUserDao.class);
        // 5.使用代理对象执行方法
        List<User> userList = iUserDao.findAll();
        for (User user : userList) {
            System.out.println(user);
        }
        // 6.释放资源
        sqlSession.close();
        inputStream.close();
    }
}
