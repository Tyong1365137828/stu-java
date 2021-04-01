package edu.hebeu.custom_mybatis.session;

import edu.hebeu.custom_mybatis.cfg.Configuration;
import edu.hebeu.custom_mybatis.session.impl.SqlSessionFactoryImpl;
import edu.hebeu.custom_mybatis.util.XMLConfigBuilder;

import java.io.InputStream;

/**
 * 该类用于创建一个SqlSessionFactory接口的对象
 */
public class SqlSessionFactoryBuilder {

    /**
     * 通过参数(配置文件的字节输入流对象)创建SqlSessionFactory接口对象
     * @param inputStreamConfig 配置文件字节输入流对象
     * @return SqlSessionFactory接口对象
     */
    public SqlSessionFactory build(InputStream inputStreamConfig) {
        Configuration configuration = XMLConfigBuilder.loadConfiguration(inputStreamConfig); // 将 .xml文件字节流对象 解析成 Configuration对象
        return new SqlSessionFactoryImpl(configuration);
    }
}
