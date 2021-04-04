package edu.hebeu.tcp;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import org.junit.Test;

/**
 * 这是一个关于TCP网络编程的例子，客户端向服务端发送文件，服务端进行接收并保存，然后返回"发送成功"给客户端
 * @author 13651
 *
 */
public class TCP3 {
	
	@Test
	public void client() {
		PrintStream ps = null;
		
		Socket socket = null;
		OutputStream outputStream = null;
		FileInputStream fis = null;
		ByteArrayOutputStream baos = null;
		InputStream inputStream = null;
		
		try {
			ps = new PrintStream(new FileOutputStream("data\\log", true)); // 将此输出流的方向改变至 data\\printData\\log 文件，不在指向控制台
			System.setOut(ps); // 通过上面的对象修改输出方向，将此输出流的方向改变至 data\\printData\\log 文件，不在指向控制台
			
			// 1、通过要通信的主机的IP和端口将来Socket实例
			socket = new Socket(InetAddress.getByName("127.0.0.1"), 3000);
			// 2、通过Socket实例获取一个OutputStream实例
			outputStream = socket.getOutputStream();
			// 3、通过文件实例创建一个FileInputStream实例
			fis = new FileInputStream(new File("data/client/demo.jpg"));
			// 4、将fis流写入到OutputStream实例中，每次最多写入1024个字节
			byte[] bufferBytes = new byte[1024];
			int readCount;
			System.out.println("C:正在发送资源...");
			while((readCount = fis.read(bufferBytes)) != -1) {
				outputStream.write(bufferBytes, 0, readCount);
			}
			// 5、关闭数据的输出
			socket.shutdownOutput();
			// 6、接收来自服务端的响应数据
			inputStream = socket.getInputStream();
			baos = new ByteArrayOutputStream();
			byte[] bufferBytes2 = new byte[1024];
			int readCount2;
			while((readCount2 = inputStream.read(bufferBytes2)) != -1) {
				baos.write(bufferBytes2, 0, readCount2);
			}
			System.out.println("C:接收到服务端响应信息:" + baos.toString());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			System.out.println("C:正在关闭资源...");
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
			if(ps != null) {
				ps.close();
			}
		}
	}
	
	/**
	 * 这个方法模仿一个服务端
	 */
	@Test
	public void server() {
		PrintStream ps = null;
		
		ServerSocket serverSocket = null;
		Socket socket = null;
		InputStream inputStream = null;
		OutputStream outputStream = null;
		FileOutputStream fos = null;
		
		try {
			ps = new PrintStream(new FileOutputStream("data\\log", true)); // 将此输出流的方向改变至 data\\printData\\log 文件，不在指向控制台
			System.setOut(ps); // 通过上面的对象修改输出方向，将此输出流的方向改变至 data\\printData\\log 文件，不在指向控制台
			
			// 1、创建一个ServerSocket实例
			serverSocket = new ServerSocket(3000);
			// 2、通过ServerSocket实例获取一个Socket实例
			socket = serverSocket.accept(); // 接收客户端发来的信息
			System.out.println("\nS:接收到来自" + socket.getInetAddress() + "的资源，正在接收...");
			// 3、通过Socket实例获取一个InputStream实例
			inputStream = socket.getInputStream();
			// 4、创建一个FileOutputStream实例，用于接收保存客户端发来的文件
			fos = new FileOutputStream(new File("data/server/get3.jpg"));
			// 5、进行接收保存
			byte[] bufferBytes = new byte[1024];
			int readCount;
			while((readCount = inputStream.read(bufferBytes)) != -1) {
				fos.write(bufferBytes, 0, readCount);
			}
			System.out.println("S:接收成功！");
			// 6、向客户端发送信息
			outputStream = socket.getOutputStream();
			outputStream.write("SUCCESS".getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			System.out.println("S:正在关闭资源...");
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
			if(serverSocket != null) {
				try {
					serverSocket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(ps != null) {
				ps.close();
			}
		}
	}
	
}
