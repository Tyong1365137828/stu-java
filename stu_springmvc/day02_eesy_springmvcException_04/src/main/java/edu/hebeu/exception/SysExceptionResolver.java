package edu.hebeu.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义异常类SysException类的 异常处理器
 */
public class SysExceptionResolver implements HandlerExceptionResolver {

    /**
     * 处理这个异常发生时的业务逻辑
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param e 抛出的异常对象
     * @return
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        System.out.println("resolveException()方法执行了...");
        /**获取到异常对象*/
        // 声明一个这个 异常处理器要处理的 异常对象
        SysException sysException;
        // 将 获取到的抛出的异常对象(e) 进行转型
        if (e instanceof SysException) { // 如果抛出的异常对象 是这个异常处理器 要处理的类型的异常
            sysException = (SysException) e; // 将该对象进行强转
        } else { // 否则，即抛出的异常对象 不是这个异常处理器 要处理的类型的异常
            sysException = new SysException("正在维护..."); // 创建一个该异常处理器 要处理的类型的异常对象
        }
        /**创建ModelAndView，来存放异常如何处理的信息*/
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("errorMessage", sysException.getMessage()); // 将这个异常处理器
        modelAndView.setViewName("exceptionView"); // 跳转到视图解析器对应 哪个文件页面(所在文件夹和文件后缀名由视图解析器决定，文件名由这里决定)
        return modelAndView;
    }
}
