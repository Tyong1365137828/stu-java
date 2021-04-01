package edu.hebeu.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 这个例子展示通过子类实现代理
 */
public class ByChildClassProxy {

    public static void main(String[] args) {
        final Producer producer = new Producer();

        /**
         * 基于子类实现代理的步骤：
         *  提供者：第三方cglib库
         *  涉及到的类：Enhancer类
         *  如何创建代理：
         *      Enhancer类的create()方法
         *      create方法的参数：
         *          Class：字节码
         *              用于指定被代理对象的字节码;
         *          Callback：用于提供增强的代码，我们一般写的都是该接口的子接口实现类：MethodInterceptor;
         *
         * 注意：要求被代理类不能是最终类！！！
         */
        Producer proxyProducer = (Producer) Enhancer.create(producer.getClass(), new MethodInterceptor() {
            /**
             * 执行被代理对象的任何方法都会经过该方法，
             * @param proxy
             * @param method
             * @param args
             *  以上三个参数和基于接口的动态代理中invoke方法的参数是一样的
             * @param methodProxy 当前执行方法的代理对象
             * @return
             * @throws Throwable
             */
            public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                // 提供增强的代码
                // 判断是否是要增强的方法
                if ("saleProduce".equals(method.getName())) { // 如果是销售的方法(saleProduce()方法)
                    // 获取此方法执行的参数
                    Float money = (Float) args[0];
                    // 进行相应的增强
                    method.invoke(producer, money * 0.90f); // 将Producer的saleProduce()方法的money只能传入赋值的 0.90倍
                }
                if ("saleAfterService".equals(method.getName())) { // 如果是售后的方法(saleAfterService()方法)
                    // 获取此方法执行的参数
                    Float money = (Float) args[0];
                    method.invoke(producer, money * 0.98f); // 将Producer的saleProduce()方法的money只能传入赋值的 0.98倍
                }
                return null;
            }
        });

        // 调用增强后的对象的方法
        proxyProducer.saleProduce(51265222);
        proxyProducer.saleAfterService(112301);

    }
}
