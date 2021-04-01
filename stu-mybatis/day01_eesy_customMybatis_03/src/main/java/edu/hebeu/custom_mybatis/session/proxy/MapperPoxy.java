package edu.hebeu.custom_mybatis.session.proxy;

import edu.hebeu.custom_mybatis.cfg.Mapper;
import edu.hebeu.custom_mybatis.util.Executor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.Map;

/**
 *
 */
public class MapperPoxy implements InvocationHandler {

    /**
     * 这个Map集合：
     *      key：全限定类名(namespace) + 方法名(id)
     *      value：一个Mapper对象，内含执行的SQL语句和结果集的全限定类名
     */
    private Map<String, Mapper> mappers;

    /**
     * 连接
     */
    private Connection conn;

    public MapperPoxy(Map<String, Mapper> mappers, Connection conn) {
        this.mappers = mappers;
        this.conn = conn;
    }

    /**
     * 用于对方法进行增强，这里我们的增强就是调用 selectList()方法
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 1、获取方法名
        String methodName = method.getName();
        // 2、获取方法所在类的名称
        String className = method.getDeclaringClass().getName();
        // 3、组合key
        String key = className + "." + methodName;
        // 4、通过key获取mappers中的Mapper对象
        Mapper mapper = mappers.get(key);
        // 5、判断以下是否有mapper
        if(mapper == null) { // 如果mapper为空
            throw new IllegalArgumentException("传入的参数有误！！！"); // 注意这个异常时RunTimeException(运行时异常)，如果出现这个异常，程序就停止了
        }
        // 6、调用工具类执行查询所有
        return new Executor().selectList(mapper, conn);
    }
}
