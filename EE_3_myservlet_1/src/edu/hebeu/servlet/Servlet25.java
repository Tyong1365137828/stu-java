package edu.hebeu.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet25
 */
//@WebServlet("/Servlet25Test")
public class Servlet25 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet25() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init() throws ServletException{/*Servlet��ʼ��,�÷�������Servlet���ز�ʵ�����Ժ�ִ��,����һ�η�
											��Servletʱ�ᱻִ��(��ִ��һ��);��������Ϊ�������һ������Servlet2.5
											���巽������web.xml�ļ�,Servlet2.5�汾��web.xml�ļ����ڸ�Servlet��
											<servlet>��ǩ��д��<load-on-startup>1</load-on-startup>*/
    	System.out.println("Servlet2.5�ĳ�ʼ������(init())");
    	
    	//ͨ��init()������ȡ��ǰServlet�ĳ�ʼ������
    	String Servlet25Value = super.getInitParameter("Servlet25Param");//super��ʾ����HttpServlet�ĸ���GenericServlet(getInitParameter����ServletConfig��������,GenericServlet�Ǹó�����������)
    	System.out.println("��ǰServlet2.5��'Servlet25Param'�����ĳ�ʼֵ��'"+Servlet25Value+"'");
    	
    	//��ȡweb�����ĳ�ʼ������
    	ServletContext servletContext = super.getServletContext();//getServletContext()�������ڻ�ȡServlet�������Ķ���,
    	String GlobleValue25Get = servletContext.getInitParameter("ServletAllGloabParam");//getInitParameter()���������ڵ�ǰServlet��Χ�ڻ�ȡ��Ϊ""�Ĳ���ֵ(��ʼ������)
    	System.out.println("��ǰServlet2.5ȡ��web������'ServletAllGloabParam'�����ĳ�ʼֵ��'"+GlobleValue25Get+"'");
    	
    }
    
  //Servlet�ķ���Service���󷽷�(�ص���doGet()��doPost()����),���ü�����ִ�м���
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet2.5��Service���󷽷�(service())���ص㷽��(doGet()��doPost())");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	//Servlet������,��Servers������������Ż�ִ���������
		public void destroy(){
			System.out.println("Servlet2.5�����ٷ���(destroy())");
		}

}
