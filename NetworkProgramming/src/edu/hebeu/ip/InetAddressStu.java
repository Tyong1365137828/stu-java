package edu.hebeu.ip;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 这个类学习Java中对网络的IP封装的类 InetAddress类
 * 
 * 1、InetAddress这个类的构造方法已经私有化了
 * 2、如何获取 InetAddress这个类的实例，有如下两个方法：
 * 		InetAddress getByName(String hostName); // 这个方法可以通过IP地址 或者 域名创建 InetAddress实例(但是注意：前者不会进行DNS域名解析，后者会进行域名解析)
 * 		InetAddress getLocalHost(); // 获取本机的IP对应的 InetAddress实例
 * 3、InetAddress实例的常用方法：
 * 		String getHostName(); // 获取这个 InetAddress实例的主机名
 * 		String getHostAddress(); // 获取这个 InetAddress实例的IP地址
 * 
 * @author 13651
 *
 */
public class InetAddressStu {
	
	public static void main(String[] args) {
		try {
			InetAddress inetAddress = InetAddress.getByName("127.0.0.1"); // 获取IP为 127.0.0.1 的主机的IP对象
			InetAddress inetAddress2 = InetAddress.getByName("tyong-top.design"); // 获取域名为 tyong-top.design 的主机的IP对象
			InetAddress inetAddress3 = InetAddress.getLocalHost(); // 获取本地主机的IP对象
			
			System.out.println("inetAddress: " + inetAddress.getHostName() + ", " + inetAddress.getHostAddress()); // 获取这个IP对象的注解名和IP地址
			System.out.println("inetAddress2: " + inetAddress2.getHostName() + ", " + inetAddress2.getHostAddress()); // 获取这个IP对象的注解名和IP地址
			System.out.println("inetAddress3: " + inetAddress3.getHostName() + ", " + inetAddress3.getHostAddress()); // 获取这个IP对象的注解名和IP地址
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
