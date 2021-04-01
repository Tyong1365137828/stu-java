package edu.hebeu.test;

import edu.hebeu.dao.IUserDao;
import edu.hebeu.dao.impl.UserDaoImpl;
import edu.hebeu.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class Test {
    public static void main(String[] args) throws Exception{
        //1.读取配置文件
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        //3.创建Dao对象，因为此时已经实现了Dao，所以不需要进行反向代理创建接口对象，而是直接使用Dao的实现类
        IUserDao iUserDao = new UserDaoImpl(sqlSessionFactory);
        //4.使用代理对象执行方法
        List<User> userList = iUserDao.findAll();
        for (User user : userList) {
            System.out.println(user);
        }
        //5.释放资源
        inputStream.close();
    }
}
