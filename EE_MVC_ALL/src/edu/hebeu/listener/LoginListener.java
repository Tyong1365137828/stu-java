package edu.hebeu.listener;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

@WebListener
public class LoginListener implements ServletRequestListener {

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("LoginListener������������!!!!");

	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		// TODO Auto-generated method stub
		System.out.println("LoginListener��������ִ��!!!!");
		
		//��ȡ��ǰʱ��,�ͻ���ip,����URL��ַ
		Date now_date = new Date();//��ȡ��ǰʱ��
		HttpServletRequest request = (HttpServletRequest)sre.getServletRequest();
		String ip = request.getRemoteAddr();//��ȡIP��ַ
		StringBuffer url = request.getRequestURL();//	http://127.0.0.1:8080/��Ŀ��/.....(����ַ��������,���ܰ�������,����StringBuffer)
		String qs = request.getQueryString();//�൱��"?����1=..&����2=....&..."

//		�����ϵ���Ϣ���浽��־�ļ���
		PrintWriter pw = null;
		try{
			pw = new PrintWriter(new FileWriter("D:/javafiles/Neon/EE_MVC_ALL/WebContent/logs/login_log",true));
			if(qs == null){
				pw.println("��ǰʱ����:"+now_date+";	�ͻ��˵�IP��ַ��:"+ip+";		���ʵ�ַ��:"+url);
			}else{
				pw.println("��ǰʱ����:"+now_date+";	�ͻ��˵�IP��ַ��:"+ip+";		���ʵ�ַ��:"+url+"?"+qs);
			}
		}catch(FileNotFoundException e){
//			e.printStackTrace();
			System.err.println("�ļ�δ�ҵ�!!");
		} catch (IOException e) {
//			e.printStackTrace();
			System.err.println("д������");
		}finally{
			pw.close();
		}
	}

}
