package edu.hebeu.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class B
 */
													//Servlet3.0��ʽ���ó�ʼ��������ʽ�����õ�ǰServlet��ʼ�����ȷ���������ע��3.0Ҫ����web��������ʱ�����Ҫ��web.xml��ʽ(�ο�Servlet2.5����web������ʽ)
@WebServlet(value="/Servlet30Test",loadOnStartup=1,initParams= {@WebInitParam(name="Servlet30Param",value="Servlet30Value" ) } )
public class Servlet30 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet30() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init() throws ServletException{/*Servlet��ʼ��,�÷�������Servlet���ز�ʵ�����Ժ�ִ��,����һ�η�
		��Servletʱ�ᱻִ��(��ִ��һ��);��������Ϊ�������һ������Servlet3.0
		�汾��ע����д��value="/servlet��",loadOnStartup=1*/
    	System.out.println("Servlet3.0�ĳ�ʼ������(init())");
    	
    	//ͨ��init()�����õ���ʼ������(��ǰ��Servlet������web�����Ĳ���)
    	String Servlet30Value = super.getInitParameter("Servlet30Param");//super��ʾ����HttpServlet�ĸ���GenericServlet(getInitParameter����ServletConfig��������,GenericServlet�Ǹó�����������)
    	System.out.println("��ǰServlet3.0��'Servlet30Param'�����ĳ�ʼֵ��'"+Servlet30Value+"'");
    	
    	//��ȡweb�����ĳ�ʼ������,
    	ServletContext servletContext = super.getServletContext();//getServletContext()�������ڻ�ȡServlet�������Ķ���,
    	String GlobleValue30Get = servletContext.getInitParameter("ServletAllGloabParam");//getInitParameter()���������ڵ�ǰServlet��Χ�ڻ�ȡ��Ϊ""�Ĳ���ֵ(��ʼ������)
    	System.out.println("��ǰServlet3.0ȡ��web������'ServletAllGloabParam'�����ĳ�ʼֵ��'"+GlobleValue30Get+"'");
    }
    
    //Servlet�ķ���Service���󷽷�(�ص���doGet()��doPost()����),���ü�����ִ�м���
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet3.0��Service���󷽷�(service())���ص㷽��(doGet()��doPost())");
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
		System.out.println("Servlet3.0�����ٷ���(destroy())");
	}
	
}
