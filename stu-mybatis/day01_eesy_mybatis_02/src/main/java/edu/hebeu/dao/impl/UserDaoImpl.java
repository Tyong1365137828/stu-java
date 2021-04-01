package edu.hebeu.dao.impl;

import edu.hebeu.dao.IUserDao;
import edu.hebeu.entity.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class UserDaoImpl implements IUserDao {
    private SqlSessionFactory sqlSessionFactory;

    /**
     * 重写覆盖构造方法
     * @param sqlSessionFactory
     */
    public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public List<User> findAll() {
        //1.创建SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //2.通过IUserDao.xml文件内的对应方法执行对应的sql   namespace + id
        List<User> userList = sqlSession.selectList("edu.hebeu.dao.IUserDao.findAll");
        //3.关闭sqlSession
        sqlSession.close();
        //4.返回查询结果
        return userList;
    }
}
