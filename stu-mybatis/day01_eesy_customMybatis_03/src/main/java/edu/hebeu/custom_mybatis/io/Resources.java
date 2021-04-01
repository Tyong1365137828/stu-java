package edu.hebeu.custom_mybatis.io;

import java.io.InputStream;

public class Resources {

    /**
     * 通过参数(文件路径)返回一个InputStream流对象
     * @param filePath 文件路径
     * @return InputStream流对象
     */
    public static InputStream getResourceAsStream(String filePath) {
        return Resources.class.getClassLoader().getResourceAsStream(filePath);
    }
}
