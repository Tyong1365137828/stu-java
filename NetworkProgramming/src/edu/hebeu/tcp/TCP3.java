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
 * ����һ������TCP�����̵����ӣ��ͻ��������˷����ļ�������˽��н��ղ����棬Ȼ�󷵻�"���ͳɹ�"���ͻ���
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
			ps = new PrintStream(new FileOutputStream("data\\log", true)); // ����������ķ���ı��� data\\printData\\log �ļ�������ָ�����̨
			System.setOut(ps); // ͨ������Ķ����޸�������򣬽���������ķ���ı��� data\\printData\\log �ļ�������ָ�����̨
			
			// 1��ͨ��Ҫͨ�ŵ�������IP�Ͷ˿ڽ���Socketʵ��
			socket = new Socket(InetAddress.getByName("127.0.0.1"), 3000);
			// 2��ͨ��Socketʵ����ȡһ��OutputStreamʵ��
			outputStream = socket.getOutputStream();
			// 3��ͨ���ļ�ʵ������һ��FileInputStreamʵ��
			fis = new FileInputStream(new File("data/client/demo.jpg"));
			// 4����fis��д�뵽OutputStreamʵ���У�ÿ�����д��1024���ֽ�
			byte[] bufferBytes = new byte[1024];
			int readCount;
			System.out.println("C:���ڷ�����Դ...");
			while((readCount = fis.read(bufferBytes)) != -1) {
				outputStream.write(bufferBytes, 0, readCount);
			}
			// 5���ر����ݵ����
			socket.shutdownOutput();
			// 6���������Է���˵���Ӧ����
			inputStream = socket.getInputStream();
			baos = new ByteArrayOutputStream();
			byte[] bufferBytes2 = new byte[1024];
			int readCount2;
			while((readCount2 = inputStream.read(bufferBytes2)) != -1) {
				baos.write(bufferBytes2, 0, readCount2);
			}
			System.out.println("C:���յ��������Ӧ��Ϣ:" + baos.toString());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			System.out.println("C:���ڹر���Դ...");
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
	 * �������ģ��һ�������
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
			ps = new PrintStream(new FileOutputStream("data\\log", true)); // ����������ķ���ı��� data\\printData\\log �ļ�������ָ�����̨
			System.setOut(ps); // ͨ������Ķ����޸�������򣬽���������ķ���ı��� data\\printData\\log �ļ�������ָ�����̨
			
			// 1������һ��ServerSocketʵ��
			serverSocket = new ServerSocket(3000);
			// 2��ͨ��ServerSocketʵ����ȡһ��Socketʵ��
			socket = serverSocket.accept(); // ���տͻ��˷�������Ϣ
			System.out.println("\nS:���յ�����" + socket.getInetAddress() + "����Դ�����ڽ���...");
			// 3��ͨ��Socketʵ����ȡһ��InputStreamʵ��
			inputStream = socket.getInputStream();
			// 4������һ��FileOutputStreamʵ�������ڽ��ձ���ͻ��˷������ļ�
			fos = new FileOutputStream(new File("data/server/get3.jpg"));
			// 5�����н��ձ���
			byte[] bufferBytes = new byte[1024];
			int readCount;
			while((readCount = inputStream.read(bufferBytes)) != -1) {
				fos.write(bufferBytes, 0, readCount);
			}
			System.out.println("S:���ճɹ���");
			// 6����ͻ��˷�����Ϣ
			outputStream = socket.getOutputStream();
			outputStream.write("SUCCESS".getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			System.out.println("S:���ڹر���Դ...");
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
