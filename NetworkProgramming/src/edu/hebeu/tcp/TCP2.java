package edu.hebeu.tcp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import org.junit.Test;

/**
 * 演示一个关于TCP网络编程的例子：客户端向服务端发送文件，服务端将文件保存到本地
 * @author 13651
 *
 */
public class TCP2 {
	
	/**
	 * 这个方法模仿一个客户端
	 */
	@Test
	public void client() {
		Socket socket = null;
		OutputStream outputStream = null;
		FileInputStream fis = null;
		
		try {
			// 1、通过要通信的主机的IP和端口将来Socket实例
			socket = new Socket(InetAddress.getByName("127.0.0.1"), 3000);
			// 2、通过Socket实例获取一个OutputStream实例
			outputStream = socket.getOutputStream();
			// 3、通过文件实例创建一个FileInputStream实例
			fis = new FileInputStream(new File("data/client/demo.jpg"));
			// 4、将fis流写入到OutputStream实例中，每次最多写入1024个字节
			byte[] bufferBytes = new byte[1024];
			int readCount;
			while((readCount = fis.read(bufferBytes)) != -1) {
				outputStream.write(bufferBytes, 0, readCount);
			}
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(fis!= null) {
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
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
		FileOutputStream fos = null;
		
		try {
			// 1、创建一个ServerSocket实例
			serverSocket = new ServerSocket(3000);
			// 2、通过ServerSocket实例获取一个Socket实例
			socket = serverSocket.accept(); // 接收客户端发来的信息
			System.out.println("S:接收到来自" + socket.getInetAddress() + "的资源，正在接收...");
			// 3、通过Socket实例获取一个InputStream实例
			inputStream = socket.getInputStream();
			// 4、创建一个FileOutputStream实例，用于接收保存客户端发来的文件
			fos = new FileOutputStream(new File("data/server/get.jpg"));
			// 5、进行接收保存
			byte[] bufferBytes = new byte[1024];
			int readCount;
			while((readCount = inputStream.read(bufferBytes)) != -1) {
				fos.write(bufferBytes, 0, readCount);
			}
			System.out.println("S:接收完成！");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(fos != null) {
				try {
					fos.close();
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
