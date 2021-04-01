package edu.hebeu.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component("logger")
@Aspect // 表示当前类是一个切面类
public class Logger {

    /**
     * 配置切入点表达式
     */
    @Pointcut("execution(* edu.hebeu.service.impl.AccountServiceImpl.*(..))")
    public void pointCutExpression() {
    }


    /**
     * 前置通知的方法
    @Before("pointCutExpression()") // 指定该方法为前置通知
    public void beforeAdvice() {
        System.out.println("前置通知执行...");
    }
    */

    /**
     * 后置通知的方法
    @AfterReturning("pointCutExpression()") // 指定该方法为后置通知
    public void afterAdvice() {
        System.out.println("后置通知执行...");
    }
    */

    /**
     * 异常通知的方法
    @AfterThrowing("pointCutExpression()") // 指定该方法为异常通知
    public void throwAdvice() {
        System.out.println("异常通知执行...");
    }
    */

    /**
     * 最终通知的方法

    @After("pointCutExpression()") // 指定该方法为最终通知
    public void finallyAdvice() {
        System.out.println("最终通知执行...");
    }
    */

    /**
     * 环绕通知：
     *  问题：
     *      当我们配置了环绕通知之后，切入点方法没有执行，而通知方法执行了;
     *  分析：
     *      通过对比动态代理中的环绕通知代码，发现动态代理的环绕通知有明确的切入点方法调用，而此处的代码中没有;
     *  解决：
     *      Spring框架为我们提供了一个接口：ProceedingJoinPoint，该接口有一个方法proceed()，此方法相当于明确调用
     *  切入点方法，该接口可以作为环绕通知的方法参数，在程序执行时，Spring会为我们创建该接口的实现类供我们使用;
     *
     *  使用直接编码的方式实现(也可以使用配置的方式实现)
     *
     *  Spring中的环绕通知：
     *      它是Spring框架为我们提供的一种可以在代码中手动控制增强方法何时执行的方式;
     * @param pjp
     * @return
     */
    @Around("pointCutExpression()") // 指定该方法为环绕通知
    public Object aroundAdvice(ProceedingJoinPoint pjp) {
        Object returnValue = null;
        Object[] args = pjp.getArgs(); // 获取方法执行所需的参数
        try {
            System.out.println("环绕通知执行...前置");

            returnValue = pjp.proceed(); // 明确调用业务层方法(切入点方法)

            System.out.println("环绕通知执行...后置");

            return returnValue;
        } catch (Throwable throwable) {
            System.out.println("环绕通知执行...异常");
            throwable.printStackTrace();
            throw new RuntimeException(throwable);
        } finally {
            System.out.println("环绕通知执行...最终");
        }

    }
}
