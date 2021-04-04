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
		System.out.println("LoginListener监听器已销毁!!!!");

	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		// TODO Auto-generated method stub
		System.out.println("LoginListener监听器已执行!!!!");
		
		//获取当前时间,客户端ip,访问URL地址
		Date now_date = new Date();//获取当前时间
		HttpServletRequest request = (HttpServletRequest)sre.getServletRequest();
		String ip = request.getRemoteAddr();//获取IP地址
		StringBuffer url = request.getRequestURL();//	http://127.0.0.1:8080/项目名/.....(即地址栏的内容,可能包括参数,则用StringBuffer)
		String qs = request.getQueryString();//相当于"?参数1=..&参数2=....&..."

//		将以上的信息保存到日志文件中
		PrintWriter pw = null;
		try{
			pw = new PrintWriter(new FileWriter("D:/javafiles/Neon/EE_MVC_ALL/WebContent/logs/login_log",true));
			if(qs == null){
				pw.println("当前时间是:"+now_date+";	客户端的IP地址是:"+ip+";		访问地址是:"+url);
			}else{
				pw.println("当前时间是:"+now_date+";	客户端的IP地址是:"+ip+";		访问地址是:"+url+"?"+qs);
			}
		}catch(FileNotFoundException e){
//			e.printStackTrace();
			System.err.println("文件未找到!!");
		} catch (IOException e) {
//			e.printStackTrace();
			System.err.println("写入有误");
		}finally{
			pw.close();
		}
	}

}
