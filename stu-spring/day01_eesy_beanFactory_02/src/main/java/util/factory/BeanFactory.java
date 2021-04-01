package util.factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 一个创建Bean对象的工厂：
 *  这个工厂用来创建 service和dao对象的；
 *
 *  须知：
 *      Bean：可重用组件的含义；
 *      JavaBean：用Java语言编写的Bean；
 *          注意：JavaBean >>> Java中的实体类(JavaBean 不是 Java中的实体类，JavaBean表示的范围远大于Java中的实体类)；
 *
 *  设计思路：
 *      第一、需要一个配置文件来配置我们的service和dao，配置内容：唯一标识=全限定类名(即 key=value结构)；
 *      第二、通过读取配置文件中的配置内容，反射创建对象；
 *      第三、配置文件的类型：可以是properties、也可以是xml等；
 *
 */
public class BeanFactory {

    /**存储读取的bean配置文件内的数据*/
    private static Properties beanProperties;

    /**存储bean对象的容器*/
    private static Map<String, Object> beans;

    static {
        InputStream inputStream = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties"); // 读取properties配置文件
        try {
            beanProperties = new Properties(); // 创建Properties集合
            beanProperties.load(inputStream); // 将获取properties文件的字节流加载到Properties集合对象

            beans = new HashMap<String, Object>(); // 创建beans仓库的实例
            Enumeration beanKeys = beanProperties.keys(); // 获取Properties的所有的key(Enumeration是枚举类型)
            // 遍历所有的key
            while (beanKeys.hasMoreElements()) {
                String beanKey = beanKeys.nextElement().toString(); // 获取一个key
                String beanValue = beanProperties.getProperty(beanKey); // 通过一个key获取一个value

                Object bean = Class.forName(beanValue).newInstance(); // 通过一个key创建一个bean对象

                beans.put(beanKey, bean); // 将key(一个bean的key)、value(通过一个bean的value创建的bean对象)存入beans
            }

        } catch (IOException e) {
            e.printStackTrace();
            throw new ExceptionInInitializerError("初始化beanProperties失败！！！");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 通过beanKey(一个bean的key)去仓库获取(不是创建)一个对应的bean对象；
     *
     * 注意：这个方式对外界使用来说是单例的
     * @param beanKey
     * @return 一个bean对象
     */
    public static Object getBeanForBeans(String beanKey) {
        return beans.get(beanKey);
    }

    /**
     * 通过读取的bean配置文件的一个key获取一个value，并通过这个value创建一个bean对象；
     * 不推荐使用这个方法，推荐使用getBeanForBeans()方法；
     *
     * 注意：这种方式对外界使用来说是多例的
     * @param beanKey 配置文件的key
     * @return 一个创建好的bean对象
     */
    @Deprecated
    public static Object getBean(String beanKey) {
        Object bean = null;

        String beanValue = beanProperties.getProperty(beanKey); // 获取全限定类名
        try {
            bean = Class.forName(beanValue).newInstance(); // 通过全限定类名创建bean对象
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return bean;
    }

}
