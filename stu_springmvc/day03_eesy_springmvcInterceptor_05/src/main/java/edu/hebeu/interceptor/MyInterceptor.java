package edu.hebeu.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义一个拦截器类
 */
public class MyInterceptor implements HandlerInterceptor {

    /**
     * 预处理方法，Controller层的对应方法执行之前执行
     *  返回值如果为true，表示将该请求方向，此时该请求会去下一个拦截器，如果下一个没有拦截器了，此时会执行Controller层的对应方法;
     *  返回值为false，表示该请求不会方向
     *  注意：这个方法内是可以进行跳转或重定向页面的，因为是在页面加载完成之前执行的这个方法
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("拦截器执行了111111...");

        System.out.println("preHandle()：Controller层对应方法执行之前执行我111111");
        return true; // 放行

//        request.getRequestDispatcher("/WEB-INF/pages/visitFailed.jsp").forward(request, response);
//        return false; // 不放行
    }

    /**
     * 后处理方法，Controller层的对应方法执行之后，页面加载完成之前执行
     *  注意：这个方法内是可以进行跳转或重定向页面的，因为是在页面加载完成之前执行的这个方法
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle()：Controller层的方法执行之后，页面加载完成之前执行我111111");

//        request.getRequestDispatcher("/WEB-INF/pages/visitFailed.jsp").forward(request, response);
    }

    /**
     * 最后执行这个方法，在Controller层对应方法执行之后 且 页面加载完成之后 执行
     *  注意：这个方法内进行跳转或重定向页面是无效的，因为要展示的页面已经加载完了
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion()：Controller层的方法执行之后，页面加载完成之后执行我111111");
    }
}
