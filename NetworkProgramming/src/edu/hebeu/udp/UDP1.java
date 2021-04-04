package edu.hebeu.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import org.junit.Test;

/**
 * 这个例子展示学习UDP网络编程的案例
 * @author 13651
 *
 */
public class UDP1 {
	
	/**
	 * 客户端
	 */
	@Test
	public void client() {
		
		DatagramSocket ds = null;
		
		try {
			ds = new DatagramSocket();
			
			byte[] data = "我是通过UID方式发送的字符串".getBytes(); // 准备要发送的数据，将其转换为字节数组
			InetAddress targetAddress = InetAddress.getByName("127.0.0.1"); // 要发送到的目标地址
			DatagramPacket dp = new DatagramPacket(data, 0, data.length, targetAddress, 8899); // 创建数据包
			ds.send(dp); // 发送数据包
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(ds != null) {
				ds.close();
			}
		}
	}
	
	/**
	 * 服务端
	 */
	@Test
	public void server() {
		DatagramSocket ds = null;
		
		try {
			ds = new DatagramSocket(8899);
			
			byte[] buffer = new byte[1000];
			DatagramPacket dp = new DatagramPacket(buffer, 0, buffer.length); // 创建数据包对象
			
			ds.receive(dp); // 接收数据包
			
			System.out.println(new String(dp.getData(), 0, dp.getLength()));
			
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(ds != null) {
				ds.close();
			}
		}
	}

}
