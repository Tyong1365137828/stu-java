package edu.hebeu.custom_mybatis.session;

public interface SqlSessionFactory {

    /**
     * 创建一个新的数据库操作对象
     * @return
     */
    SqlSession openSession();
}
