package edu.hebeu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/servlet/suibianxie")//�������������ַ�Դ�Ϊ׼
public class ZiDingYiServlet extends HttpServlet {
	//ִ��servlet�����ַ�ʽ
	/*1������web.xml
	 * ��</web-app>����һ������
 <servlet>
	<servlet-name>���е�servlet�������</servlet-name>  ע�⣺������������������Ҫ���е�servlet�������Բ�һ�����������һ��
	<servlet-class>����.Ҫ���е�servlet����(��Ҫ���е�servlet�ļ��ڵ�·��)</servlet-class>  ע�⣺����.����(��������Ǵ�����(����.class)����һ��,����������.class)������ѡ�����������Copy Quali..�������֣���ֹ�������
  </servlet>
  <servlet-mapping>
	<servlet-name>���е�servlet�������</servlet-name>	ע�⣺�����������Ҫһ��
	<url-pattern>/��Ҫ���е�servlet�������һ��url��ַ</url-pattern>  ע�⣺���servlet�Ǹ���������������֣�������������servlet
  </servlet-mapping>

���еĹ��̣�1)��<url-pattern>/��Ҫ���е�servlet�������һ��url��ַ</url-pattern> ---2)��<servlet-name>���е�servlet�������</servlet-name>--
	    3)��<servlet-name>���е�servlet�������</servlet-name>--4)��<servlet-class>����.Ҫ���е�servlet����(��Ҫ���е�servlet�ļ���·��)</servlet-class>
	 * 
	 * 
	 * 
	 * 2��ע�ⷽʽ��������߷�����ǰ��ӱ�־
	 * �����ǰ���@WebServlet("/.../...(�������·�����д��ע�⿪ͷ��"/"��ע���������������ַ�Դ�Ϊ׼)")
	 * 							
	 * 								//ע�⿪ͷ��"/"
	 * ����@WebServlet(name="",urlPatterns={"·��1","·��2"},loadOnStartup=0/1/2/3/4/5)
	 * name��ʾ�����������	urlPatterns��ʾ���Է��ʵ�·��	loadOnStartup(Ĭ��Ϊ0)��ʾ�������Ⱥ�ԽСԽ��������0��ʾ�������һ������
	 * 
	 * */
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//��source��ѡ��override/Implement Methods��Ȼ��ֻѡ��doGet��doPost�ύ
	//ע�⣺һ��get��post��ֻ����һ���͹��ˣ���һ������ֱ���ô������д����һ��
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);;
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("��һ��servlet");
		System.out.println("��һ��servlet��ע�ⷽʽ");
	}


	
}
