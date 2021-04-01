package edu.hebeu.controller;

import edu.hebeu.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/user")
public class UserController {

    /**
     * 返回值是String类型的
     *  会根据springmvc.xml文件的配置去 请求返回值对应的文件名(不包括后缀，后缀是在springmvc.xml文件中配置的)
     * @param model
     * @return
     */
    @RequestMapping("/return_string")
    public String returnString(Model model) {
        System.out.println("returnString()方法执行了...");
        // 模拟从数据库中查询到User对象
        User user = new User();
        user.setUsername("root");
        user.setPassword("0727316052");
        user.setAge(21);
        // 将查询到的数据存起来(存入request域中)
        model.addAttribute("userKey", user);

        return "success";
    }

    /**
     * 返回值是void类型的
     *  如果没有编写请求转发到何处的代码，默认会根据springmvc.xml文件的配置去 请求该方法名对应的文件名(不包括后缀，
     *  后缀是在springmvc.xml文件中配置的),
     *  此例就是去请求 /WEB-INF/pages/文件夹下的 returnVoi.jsp文件;
     *
     *
     *  需要知道：
     *      转发是一次请求，不用编写项目名称;
     *      手动调用转发方法时(即：request.getRequestDispatcher("转发路径").forward(request, response);)，就不会通过视图解
     *      析器去解析要转发的字符串进而得到文件，此时就要求写清楚请求的文件路径(包括后缀)
     *
     *      重定向是两次请求(重新发一次新的请求)，需要编写项目名称;
     *
     */
    @RequestMapping("/return_void")
    public void returnVoid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("returnVoid()方法执行了...");

        /**
         * 编写请求转发的代码
         */
//        request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request, response);

        /**
         * 编写请求重定向的代码
         */
//        response.sendRedirect(request.getContextPath() + "/user/return_string");
//        response.sendRedirect(request.getContextPath() + "/index.jsp");

        // 设置中文编码，解决中文乱码问题
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        /**
         * 直接响应
         */
        response.getWriter().println("你好SpringMVC");

        return;
    }

    /**
     * 返回值是ModelAndView类型的
     *  ModelAndView：SpringMVC为我们提供的一个对象，该对象可以作为控制器方法的返回值;
     * @return
     */
    @RequestMapping("/return_modelAndView")
    public ModelAndView returnModelAndView() {
        System.out.println("returnModelAndView()方法执行了...");
        // 1、创建ModelAndView对象
        ModelAndView mdv= new ModelAndView();
        // 2、模拟从旁那个数据库查询到的User对象
        User user = new User();
        user.setUsername("1365137");
        user.setPassword("072731");
        user.setAge(21);
        // 3、将查询到的User对象存储到ModeAndView对象
        mdv.addObject("userKey", user);
        // 4、通过配置的视图解析器配置的文件夹和文件后缀名，以及下面给ModelAndView对象传入的文件名，决定跳转到哪个页面
        mdv.setViewName("success");
        // 返回ModelAndView对象
        return mdv;
    }

    /**
     * 这个方法演示如何通过关键字实现转发或者重定向
     * @return
     */
    @RequestMapping("/test_keyWord_to_forward_redirect")
    public String testKeyWordToForwardOrRedirect() {
        System.out.println("testKeyWordToForwardOrRedirect()方法执行了...");

        /**
         * 进行转发
         */
//        return "forward:/WEB-INF/pages/success.jsp";

        /**
         * 进行重定向
         */
        //        return "redirect:index.jsp";
        return "redirect:/user/return_string";
    }

    /**
     * 这个方法展示如何接收响应Ajax请求
     *
     *  当接受的JSON数据的key部分与POJO对象的属性名一致时，可以导入JSON相关的jar包配合使用@RequestBody注解实现数据的自动封装！！！
     *
     *  -@RequestBody注解：
     *   将接收的request请求的参数转换为被标注的参数类型;
     *
     * -@Response注解：
     *  将方法的返回值转为JSON类型的数据;
     *
     * @param user
     */
    @RequestMapping("/test_ajax")
    public @ResponseBody User testAjax(@RequestBody User user) {
        System.out.println("testAjax()方法执行...");
        System.out.println(user);
        // 进行响应，模拟通过相应来的username查询数据库得到的User对象
        user.setPassword("52554");
        user.setAge(24);
        // 做响应
        return user;
    }
}
