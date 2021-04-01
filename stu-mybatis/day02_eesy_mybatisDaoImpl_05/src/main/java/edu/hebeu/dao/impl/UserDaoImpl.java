package edu.hebeu.dao.impl;

import edu.hebeu.dao.IUserDao;
import edu.hebeu.entity.User;
import edu.hebeu.entity.UserVo;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class UserDaoImpl implements IUserDao {

    private SqlSessionFactory sqlSessionFactory;

    public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public void insertUser(User user) {
        // 1、获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        /**这个方法的参数：
         参数1、获取SQL语句，对应是xml文件的 "mapper标签的namespace属性值.mapper标签的直接子标签id属性值"，
         参数2、获取#{}或${}内的值，类型与xml文件中对应的insert、delete、update、select标签的parameterType属性值一致
         返回值：与xml文件中对应的insert、delete、update、select标签的resultType/resultMap属性值一致，或者当作返回的集合的泛型，
         如果没有resultType/resultMap属性，则无返回值
         */
        sqlSession.insert("edu.hebeu.dao.IUserDao.insertUser", user);
        sqlSession.commit();
        sqlSession.close();

    }

    public void deleteUser(Integer userId) {
        // 1、获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        /**这个方法的参数：
         参数1、获取SQL语句，对应是xml文件的 "mapper标签的namespace属性值.mapper标签的直接子标签id属性值"，
         参数2、获取#{}或${}内的值，类型与xml文件中对应的insert、delete、update、select标签的parameterType属性值一致
         返回值：与xml文件中对应的insert、delete、update、select标签的resultType/resultMap属性值一致，或者当作返回的集合的泛型，
         如果没有resultType/resultMap属性，则无返回值
         */
        sqlSession.delete("edu.hebeu.dao.IUserDao.deleteUser", userId);
        sqlSession.commit();
        sqlSession.close();

    }

    public void updateUser(User user) {
        // 1、获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        /**这个方法的参数：
         参数1、获取SQL语句，对应是xml文件的 "mapper标签的namespace属性值.mapper标签的直接子标签id属性值"，
         参数2、获取#{}或${}内的值，类型与xml文件中对应的insert、delete、update、select标签的parameterType属性值一致
         返回值：与xml文件中对应的insert、delete、update、select标签的resultType/resultMap属性值一致，或者当作返回的集合的泛型，
         如果没有resultType/resultMap属性，则无返回值
         */
        sqlSession.update("edu.hebeu.dao.IUserDao.updateUser", user);

        sqlSession.commit();
        sqlSession.close();

    }

    public List<User> selectUserAll() {
        // 1、获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        /**这个方法的参数：
         参数1、获取SQL语句，对应是xml文件的 "mapper标签的namespace属性值.mapper标签的直接子标签id属性值"，
         参数2、获取#{}或${}内的值，类型与xml文件中对应的insert、delete、update、select标签的parameterType属性值一致
         返回值：与xml文件中对应的insert、delete、update、select标签的resultType/resultMap属性值一致，或者当作返回的集合的泛型，
         如果没有resultType/resultMap属性，则无返回值
         */
        List<User> users = sqlSession.selectList("edu.hebeu.dao.IUserDao.selectUserAll");

        sqlSession.close();
        return users;
    }

    public User selectUserById(Integer userId) {
        // 1、获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        /**这个方法的参数：
         参数1、获取SQL语句，对应是xml文件的 "mapper标签的namespace属性值.mapper标签的直接子标签id属性值"，
         参数2、获取#{}或${}内的值，类型与xml文件中对应的insert、delete、update、select标签的parameterType属性值一致
         返回值：与xml文件中对应的insert、delete、update、select标签的resultType/resultMap属性值一致，或者当作返回的集合的泛型，
         如果没有resultType/resultMap属性，则无返回值
         */
        User user = sqlSession.selectOne("edu.hebeu.dao.IUserDao.selectUserById", userId);

        sqlSession.close();
        return user;
    }

    public int selectUserTotal() {
        // 1、获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        /**这个方法的参数：
         参数1、获取SQL语句，对应是xml文件的 "mapper标签的namespace属性值.mapper标签的直接子标签id属性值"，
         参数2、获取#{}或${}内的值，类型与xml文件中对应的insert、delete、update、select标签的parameterType属性值一致
         返回值：与xml文件中对应的insert、delete、update、select标签的resultType/resultMap属性值一致，或者当作返回的集合的泛型，
         如果没有resultType/resultMap属性，则无返回值
         */
        int userCount = sqlSession.selectOne("edu.hebeu.dao.IUserDao.selectUserTotal");

        sqlSession.close();
        return userCount;
    }

    public List<User> selectUserByVoDim(UserVo userVo) {
        // 1、获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        /**这个方法的参数：
         参数1、获取SQL语句，对应是xml文件的 "mapper标签的namespace属性值.mapper标签的直接子标签id属性值"，
         参数2、获取#{}或${}内的值，类型与xml文件中对应的insert、delete、update、select标签的parameterType属性值一致
         返回值：与xml文件中对应的insert、delete、update、select标签的resultType/resultMap属性值一致，或者当作返回的集合的泛型，
         如果没有resultType/resultMap属性，则无返回值
         */
        List<User> users = sqlSession.selectList("edu.hebeu.dao.IUserDao.selectUserByVoDim", userVo);

        sqlSession.close();
        return users;
    }

}
