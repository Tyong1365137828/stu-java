package edu.hebeu.custom_mybatis.cfg;

import java.util.HashMap;
import java.util.Map;

/**
 * 自定义mybatis的配置类用来存储解析的配置文件(xml)的的信息
 */
public class Configuration {

    private String driver;
    private String url;
    private String username;
    private String password;
    private Map<String, Mapper> mappers = new HashMap<String, Mapper>(); // 该集合是key部分是 namespace+"."+id；value部分是 一个Mapper对象，该对象内含执行的SQL语句和结果集的全限定类名

    public Map<String, Mapper> getMappers() {
        return mappers;
    }

    public void setMappers(Map<String, Mapper> mappers) {
        this.mappers.putAll(mappers); // 将后面传入的内容都追加到Map集合
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
