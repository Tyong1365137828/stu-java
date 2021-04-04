package edu.hebeu.url;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * 这个例子展示学URL网络编程的案例
 * @author 13651
 *
 */
public class URL1 {
	
	public static void main(String[] args) {
		try {
			URL url = new URL("https://www.bilibili.com:9999/video/BV1Kb411W75N?p=629&spm_id_from=pageDriver");
			// public String getProtocol(); // 获取URL实例对象的协议名
			System.out.println("协议名：" + url.getProtocol());
			// public String getHost(); // 获取URL实例对象的主机名
			System.out.println("主机名：" + url.getHost());
			// public String getPort(); // 获取URL实例对象的端口号
			System.out.println("端口号：" + url.getPort());
			// public String getPath(); // 获取URL实例对象的文件路径
			System.out.println("文件路径：" + url.getPath());
			// public String getFile(); // 获取URL实例对象的文件名
			System.out.println("文件名：" + url.getFile());
			// public String getQuery(); // 获取URL实例对象的查询名
			System.out.println("查询名：" + url.getQuery());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
