package edu.hebeu.listener;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 统计在线人数的实现
 * @author 13651
 * 
 * 原理：使用session创建和销毁解决
	session创建时，人数+1，销毁时，人数-1；和是否登录没有关系，只与session创建个数有关；
	第一次访问时，就创建了session，人数+1；当浏览器关闭时，人数不会立刻-1，等到session最大的非活动间隔到session销毁才减1。
	统计在线人数也可以按照登录人数计算，也可以按照注销人数计算。
 *
 */
@WebListener
public class OnlineListener implements HttpSessionListener {

	private int count = 0;
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("OnlineListener监听器执行!!!!!");
		count++;
		ServletContext application=se.getSession().getServletContext();
		application.setAttribute("onlinecount", count);

		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("OnlineListener监听器销毁!!!!!");
		ServletContext application=se.getSession().getServletContext();
		application.setAttribute("onlinecount", count);

	}

}
