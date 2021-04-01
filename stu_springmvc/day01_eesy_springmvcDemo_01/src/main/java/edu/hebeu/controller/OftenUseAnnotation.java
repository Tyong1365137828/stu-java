package edu.hebeu.controller;

import edu.hebeu.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.Date;
import java.util.Map;

/**
 * 这个类用来测试验证常用注解的使用
 */
@Controller
@RequestMapping("/annotation")
@SessionAttributes(value = {"message"}) // 表示将request域中的 key为message的 key=value对 加入到 session域中;
public class OftenUseAnnotation {

    /**
     * 测试 @RequestParams注解的使用
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("/test_request_params")
    public String testRequestParams(@RequestParam("name") String username, @RequestParam("pwd") String password) {
        System.out.println("testRequestParams()方法执行了...");
        System.out.println("username = " + username + "; password = " + password);
        return "success";
    }

    /**
     * 测试@RequestBody注解的使用
     * @param body
     * @return
     */
    @RequestMapping("/test_request_body")
    public String testRequestBody(@RequestBody String body) {
        System.out.println("testRequestBody()方法执行...");
        System.out.println(body);
        return "success";
    }

    /**
     * 测试 @PathVariable注解的使用
     * @return
     */
    @RequestMapping("/test_path_variable/{uid}")
    public String testPathVariable(@PathVariable("uid") String id) {
        System.out.println("testPathVariable()方法执行...");
        System.out.println("id = " + id);
        return "success";
    }

    /**
     * 测试 @RequestHeader注解的使用
     * @param header
     * @return
     */
    @RequestMapping("/test_request_header")
    public String testRequestHeader(@RequestHeader(value = "Accept") String header) {
        System.out.println("testRequestHeader()方法执行...");
        System.out.println("header = " + header);
        return "success";
    }

    /**
     * 测试 @CookieValue注解的使用
     * @param cookie
     * @return
     */
    @RequestMapping("/test_cookie_value")
    public String testCookieValue(@CookieValue(value = "JSESSIONID") String cookie) {
        System.out.println("testCookieValue()方法执行...");
        System.out.println("cookie = " + cookie);
        return "success";
    }

    /**
     * 测试 @ModelAttribute注解
     *  这个是使用的ModelAttribute注解标注的方法存在返回值时的用法
     * @return
    @RequestMapping(value = "/test_model_attribute", method = RequestMethod.POST)
    public String testModelAttribute(User user) {
        System.out.println("testModelAttribute()方法执行...");
        System.out.println(user);
        return "success";
    }
    /**
     * 这个方法被 @ModelAttribute注解标志，此时这个方法会先执行
     *  这个是存在返回值的写法
     * @param username
     * @param age
    @ModelAttribute
    public User showUser(String username, Integer age) {
        System.out.println("showUser()方法执行了...");
        System.out.println("username = " + username + "; age = " + age);
        // 1、通过username等信息(参数自动绑定机制)查询数据库中的用户信息(模拟)
        User user = new User();
        user.setUname(username);
        user.setAge(age);
        user.setRegisterDate(new Date());
        // 2、将查询到的信息返回
        return user;
    }
    */

    /**测试 @ModelAttribute注解
     *  这个是使用的ModelAttribute注解标注的方法没有返回值时的用法(在参数上使用@ModelAttribute注解，通过key值获取
     *  被@ModelAttribute注解标注的方法里存入Map集合的POJO属性)
     * @param user
     * @return
     */
    @RequestMapping("/test_model_attribute")
    public String testModelAttribute(@ModelAttribute(value = "user1") User user) {
        System.out.println("testModelAttribute()方法执行...");
        System.out.println(user);
        return "success";
    }

    /**这个方法被 @ModelAttribute注解标志，此时这个方法会先执行
     *  这个是没有返回值的写法
     * @param username
     * @param age
     * @param userMap
     */
    @ModelAttribute
    public void showUser(String username, Integer age, Map<String, User> userMap) {
        System.out.println("showUser()方法执行了...");
        System.out.println("username = " + username + "; age = " + age);
        // 1、通过username等信息(参数自动绑定机制)查询数据库中的用户信息(模拟)
        User user = new User();
        user.setUname(username);
        user.setAge(age);
        user.setRegisterDate(new Date());
        // 2、将查询到的信息存入到map集合中
        userMap.put("user1", user);
    }

    /**
     * 测试将key=value对添加到 request域中
     *  注意：Model类是接口类型的
     * @param model
     * @return
     */
    @RequestMapping("/test_session_attribute")
    public String testSessionAttribute(Model model) {
        System.out.println("testSessionAttribute()方法执行...");
        // 底层会将这个key=value对 存入request域对象中
        model.addAttribute("message", "测试request域和session域");
        model.addAttribute("id", 156);
        model.addAttribute("birthday", new Date());
        return "success";
    }

    /**
     * 获取session域内指定的key=value对
     *  注意：ModelMap类是Model接口类的实现类
     * @param modelMap
     * @return
     */
    @RequestMapping("/test_get_session")
    public String testGetSession(ModelMap modelMap) {
        System.out.println("testGetSession()方法执行...");
        String msg = (String) modelMap.get("message");
        System.out.println("msg = " + msg);
        return "success";
    }

    /**
     * 删除session域内的key=value对
     *  注意：SessionStatus类是一个接口类型
     * @param sessionStatus
     * @return
     */
    @RequestMapping("/test_delete_session")
    public String testDeleteSession(SessionStatus sessionStatus) {
        System.out.println("testDeleteSession()方法执行...");
        sessionStatus.setComplete();
        return "success";
    }


}
