package edu.hebeu.custom_mybatis.session.impl;

import edu.hebeu.custom_mybatis.cfg.Configuration;
import edu.hebeu.custom_mybatis.session.SqlSession;
import edu.hebeu.custom_mybatis.session.proxy.MapperPoxy;
import edu.hebeu.custom_mybatis.util.DataSourceUtil;

import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * SqlSession接口的实现类
 */
public class SqlSessionImpl implements SqlSession {

    /**
     * Configuration对象，内含driver、url、username、password、和Map类型的集合(内含哪个映射配置文件的哪个标签的id：namespace.id 组成的key；Mapper类型的对象，该对象内含执行的SQL语句和结果集的全限定类名 组成的value)；
     */
    private Configuration configuration;

    /**
     * Connection连接对象
     */
    private Connection conn;

    public SqlSessionImpl(Configuration configuration) {
        this.configuration = configuration;
        this.conn = DataSourceUtil.getConnection(configuration); // 调用自定义工具类注册驱动，获取Connection连接对象
    }

    /**
     * 用于创建并返回一个 dao接口的代理对象
     * @param tClass dao接口的字节码
     * @param <T> dao接口的类型
     * @return 返回一个 dao类型的对象
     */
    public <T> T getMapper(Class<T> tClass) {

        /**
         * Proxy类的newProxyInstance(代理类型的类加载器，实现与代理类相同的接口，如何代理)静态方法
         */
        return (T) Proxy.newProxyInstance(tClass.getClassLoader(),
                new Class[]{tClass},
                new MapperPoxy(configuration.getMappers(), conn)
                );
    }

    /**
     * 用于释放资源
     */
    public void close() {
        if(conn != null) { // 如果连接不为空
            try {
                conn.close(); // 关闭连接
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
