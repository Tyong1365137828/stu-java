package edu.hebeu.custom_mybatis.session.impl;

import edu.hebeu.custom_mybatis.cfg.Configuration;
import edu.hebeu.custom_mybatis.session.SqlSession;
import edu.hebeu.custom_mybatis.session.SqlSessionFactory;

/**
 * SqlSessionFactory接口的实现类
 */
public class SqlSessionFactoryImpl implements SqlSessionFactory {

    /**
     * 操作数据库的必要信息，内含driver、url、username、password、Map类型的集合(内含哪个映射配置文件的哪个标签id：namespace.id 组成的key；Mapper类型的对象，该对象内含执行的SQL语句和结果集的全限定类名 组成的value)；
     */
    private Configuration configuration;

    public SqlSessionFactoryImpl(Configuration configuration) {
        this.configuration = configuration;
    }

    /**
     * 用于创建并返回 一个新的数据库操作对象
     * @return 一个新的数据库操作对象，SqlSession对象
     */
    public SqlSession openSession() {
        return new SqlSessionImpl(configuration); // 返回SqlSessionImpl(SqlSession的实现类)对象
    }
}
