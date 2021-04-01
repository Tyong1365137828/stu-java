package edu.hebeu.controller;

import edu.hebeu.entity.Account;
import edu.hebeu.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/params")
public class ParamsBinding {

    /**
     * 请求参数绑定测试，如果要实现参数自动绑定，就必须保持形参与request传入来的参数名保持一致
     * @return
     */
    @RequestMapping("/testParams")
    public String testParams(String username, String password) {
        System.out.println("testParams()方法执行了...");
        System.out.println("params: username = " + username + "; password = " + password);
        return "success";
    }

    /**
     * 将数据封装到JavaBean的类中，如果要实现参数自动绑定，就必须保持这个JavaBean对象内的属性名与request传入来的参数名保持一致
     * @return
     */
    @RequestMapping("/save_account")
    public String saveAccount(Account account) {
        System.out.println("saveAccount()方法执行了...");
        System.out.println(account);
        return "success";
    }

    /**
     * 将数据封装到User的JavaBean类中，该类中有一个Date类型的属性，
     * 以此来引出自定义类型转换器的定义和使用
     * @param user
     * @return
     */
    @RequestMapping("/save_user")
    public String saveUser(User user) {
        System.out.println("saveUser()方法执行了...");
        System.out.println(user);
        return "success";
    }

    @RequestMapping("/servlet")
    public String getServlet(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("getServlet()方法执行了...");
        System.out.println(request);

        HttpSession session = request.getSession();
        System.out.println(session);

        ServletContext servletContext = session.getServletContext();
        System.out.println(servletContext);

        System.out.println(response);

        return "success";
    }

}
