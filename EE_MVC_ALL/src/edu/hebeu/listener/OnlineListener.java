package edu.hebeu.listener;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * ͳ������������ʵ��
 * @author 13651
 * 
 * ԭ��ʹ��session���������ٽ��
	session����ʱ������+1������ʱ������-1�����Ƿ��¼û�й�ϵ��ֻ��session���������йأ�
	��һ�η���ʱ���ʹ�����session������+1����������ر�ʱ��������������-1���ȵ�session���ķǻ�����session���ٲż�1��
	ͳ����������Ҳ���԰��յ�¼�������㣬Ҳ���԰���ע���������㡣
 *
 */
@WebListener
public class OnlineListener implements HttpSessionListener {

	private int count = 0;
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("OnlineListener������ִ��!!!!!");
		count++;
		ServletContext application=se.getSession().getServletContext();
		application.setAttribute("onlinecount", count);

		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("OnlineListener����������!!!!!");
		ServletContext application=se.getSession().getServletContext();
		application.setAttribute("onlinecount", count);

	}

}
