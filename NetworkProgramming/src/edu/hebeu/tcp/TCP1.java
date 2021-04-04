package edu.hebeu.tcp;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import org.junit.Test;

/**
 * 这个例子演示一个关于TCP网络编程的案例：客户端向服务端发送消息
 * @author 13651
 *
 */
public class TCP1 {
	
	/**
	 * 这个方法模仿一个客户端
	 */
	@Test
	public void client() {
		Socket socket = null;
		OutputStream outputStream = null;
		
		try {
			InetAddress inetAddress = InetAddress.getByName("127.0.0.1"); // 创建要进行通信的主机的IP
			socket = new Socket(inetAddress, 8899);
			
			outputStream = socket.getOutputStream(); // 获取一个输出流
			outputStream.write("我是客户端client，我需要给你发送数据".getBytes());
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(outputStream != null) {
				try {
					outputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
			}
			if(socket != null) {
				try {
					socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
			}
		}
	}
	
	/**
	 * 这个方法模仿一个服务端
	 */
	@Test
	public void server() {
		ServerSocket serverSocket = null;
		Socket socket = null;
		InputStream inputStream = null;
		ByteArrayOutputStream baos = null; // 这个流底层是一个会自动扩容的字节数组，将接收的字节会先存放，待接收完成后将字节数组一起进行转换(因此这个流处理中文或其他文字时绝对不会出现乱码)
		
		try {
			serverSocket = new ServerSocket(8899); // 创建一个服务端，指明自己的端口号
			socket = serverSocket.accept(); // 用来接收客户端的信息
			inputStream = socket.getInputStream(); // 获取客户端发来的信息流
			
			System.out.println("获取来自服务端" + socket.getInetAddress() + "的信息：");
			baos = new ByteArrayOutputStream();
			int readCount;
			byte[] bytes = new byte[3];
			while((readCount = inputStream.read(bytes)) != -1) {
				baos.write(bytes, 0, readCount);
			}
			System.out.println(baos.toString());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(baos != null) {
				try {
					baos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(socket != null) {
				try {
					socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(serverSocket != null) {
				try {
					serverSocket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
