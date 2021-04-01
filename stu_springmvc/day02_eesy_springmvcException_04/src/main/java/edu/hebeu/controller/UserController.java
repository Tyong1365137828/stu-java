package edu.hebeu.controller;

import edu.hebeu.exception.SysException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    /***
     * 这个方法演示传统默认的异常出现时如何处理
     * @return
     * @throws Exception
     */
    @RequestMapping("/test_exception")
    public String testException1() throws Exception {
        System.out.println("testException()方法执行了...");

        // 模拟一个异常
        int  i = 1 / 0;

        return "success";
    }

    /**
     * 这个方法演示通过SpringMVC的异常处理配合自定义异常类实现 出现异常时如何处理
     * @return
     */
    @RequestMapping("/test_sysException")
    public String testSysException() throws SysException {
        System.out.println("testSysException()方法执行了...");

        try {
            // 模拟一个异常
            int i = 1 / 0;
        } catch (Exception e) {
            e.printStackTrace();
            throw new SysException("自定义类型的异常发生了！");
        }

        return "success";
    }
}
