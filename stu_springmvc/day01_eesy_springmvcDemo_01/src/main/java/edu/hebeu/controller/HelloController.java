package edu.hebeu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 控制器的类
 */
@Controller
@RequestMapping("/hello")
public class HelloController {

    /**
     * -@RequestMapping注解：用于建立请求URL和处理请求方法之间的对应关系
     *  出现位置：
     *      仅在方法上出现：表示处理请求来的url;
     *      出现在类上，表示处理请求来的url的一级url,此时在方法上出现的就是处理请求来的url的二级url;
     *  属性：
     *      method：用于指定请求的类型，使用方式：RequestMethod.请求类型
             RequestMethod类的源码：
                public enum RequestMethod {
                 GET,
                 HEAD,
                 POST,
                 PUT,
                 PATCH,
                 DELETE,
                 OPTIONS,
                 private RequestMethod() {
                 }
                }
            params：用于指定限制请求参数的条件，它支持简单的表达式，要求请求参数的key和value必须和配置一模一样！！！
                如：
                    params = {"accountName"} // 表示请求参数必须有accountName
                    params = {"username=root} // 表示请求参数中的username必须是root
                    params = {"money!10"} // 要求请求参数中的money不能是10
            headers：用于指定限制请求消息头的条件
     * @return
     */
    @RequestMapping(path = "/hello")
    public String getHello() {
        System.out.println("Hello SpringMVC");
        return "success"; // 会跳转到 success.后缀名 文件
    }

    @RequestMapping(value = "testRequestMapping", method = {RequestMethod.GET},
            params = {"username", "password"}, headers = {"Accept"})
    public String testRM() {
        System.out.println("Hello testRm");
        return "success";
    }
}
