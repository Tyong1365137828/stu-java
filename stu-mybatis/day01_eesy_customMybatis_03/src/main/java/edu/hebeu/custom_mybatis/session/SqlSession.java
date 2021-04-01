package edu.hebeu.custom_mybatis.session;

public interface SqlSession {

    <T> T getMapper(Class<T> tClass);

    void close();
}
