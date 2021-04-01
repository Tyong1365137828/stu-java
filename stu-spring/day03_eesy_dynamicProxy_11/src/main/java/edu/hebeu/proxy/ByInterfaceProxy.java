package edu.hebeu.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

public class ByInterfaceProxy {

    public static void main(String[] args) {
        final Producer producer = new Producer(); // 匿名内部类使用类成员属性，要求改类成员属性必须是 final 关键字修饰的！！！

        /**
         * 基于接口的动态代理：
         *     涉及的类：Proxy(JDK官方提供);
         *     如何创建代理对象：
         *         使用Proxy中的newProxyInstance()方法
         *     创建代理对象的要求：
         *         被代理的对象对应的类最少实现一个接口，如果没有则不能使用;
         *     方法：
         *         public static Object newProxyInstance(ClassLoader loader,
         *                                           Class<?>[] interfaces,
         *                                           InvocationHandler h))方法：
         *             参数：
         *                 参数1、ClassLoader   类加载器
         *                     用于加载代理对象字节码的，写的是被代理对象加载器(和被代理对象使用相同的类加载器)，固定写法;
         *                 参数2、Class[]    字节码数组
         *                     用于让代理对象和被代理对象有相同的方法(代理谁)，固定写法;
         *                 参数3、InvocationHandler    用于提供增强的代码
         *                     用于提供增强的代码(即如何代理，我们一般写一个该接口的实现类，通常情况下是直接写匿名内部类，但不是必须的)，
         *                     此接口的实现类都是谁用谁写;
         */
        IProducer proxyProducer = (IProducer) Proxy.newProxyInstance(producer.getClass().getClassLoader(),
                producer.getClass().getInterfaces(),
                new InvocationHandler() {
                    /**
                     * 执行被代理对象的任何接口方法都会经过该方法;
                     * @param proxy 代理对象的引用
                     * @param method 当前执行的方法
                     * @param args 当前执行方法所需的参数
                     * @return 与被代理对象方法有相同的返回值
                     * @throws Throwable
                     */
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        List<Object> proxyMethods = new ArrayList<Object>();
                        // 提供增强的代码
                        // 判断是否是要增强的方法
                        if ("saleProduce".equals(method.getName())) { // 如果是销售的方法(saleProduce()方法)
                            // 获取此方法执行的参数
                            Float money = (Float) args[0];
                            // 进行相应的增强
                            proxyMethods.add(method.invoke(producer, money * 0.90f)); // 将Producer的saleProduce()方法的money只能传入赋值的 0.90倍
                        }
                        if ("saleAfterService".equals(method.getName())) { // 如果是售后的方法(saleAfterService()方法)
                            // 获取此方法执行的参数
                            Float money = (Float) args[0];
                            proxyMethods.add(method.invoke(producer, money * 0.98f)); // 将Producer的saleProduce()方法的money只能传入赋值的 0.98倍
                        }

                        return proxyMethods;
                    }
                });


        // 调用增强后的对象的方法
        proxyProducer.saleProduce(30000);
        proxyProducer.saleAfterService(300);

    }
}
