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
 * ��ʾһ������TCP�����̵����ӣ��ͻ��������˷����ļ�������˽��ļ����浽����
 * @author 13651
 *
 */
public class TCP2 {
	
	/**
	 * �������ģ��һ���ͻ���
	 */
	@Test
	public void client() {
		Socket socket = null;
		OutputStream outputStream = null;
		FileInputStream fis = null;
		
		try {
			// 1��ͨ��Ҫͨ�ŵ�������IP�Ͷ˿ڽ���Socketʵ��
			socket = new Socket(InetAddress.getByName("127.0.0.1"), 3000);
			// 2��ͨ��Socketʵ����ȡһ��OutputStreamʵ��
			outputStream = socket.getOutputStream();
			// 3��ͨ���ļ�ʵ������һ��FileInputStreamʵ��
			fis = new FileInputStream(new File("data/client/demo.jpg"));
			// 4����fis��д�뵽OutputStreamʵ���У�ÿ�����д��1024���ֽ�
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
	 * �������ģ��һ�������
	 */
	@Test
	public void server() {
		ServerSocket serverSocket = null;
		Socket socket = null;
		InputStream inputStream = null;
		FileOutputStream fos = null;
		
		try {
			// 1������һ��ServerSocketʵ��
			serverSocket = new ServerSocket(3000);
			// 2��ͨ��ServerSocketʵ����ȡһ��Socketʵ��
			socket = serverSocket.accept(); // ���տͻ��˷�������Ϣ
			System.out.println("S:���յ�����" + socket.getInetAddress() + "����Դ�����ڽ���...");
			// 3��ͨ��Socketʵ����ȡһ��InputStreamʵ��
			inputStream = socket.getInputStream();
			// 4������һ��FileOutputStreamʵ�������ڽ��ձ���ͻ��˷������ļ�
			fos = new FileOutputStream(new File("data/server/get.jpg"));
			// 5�����н��ձ���
			byte[] bufferBytes = new byte[1024];
			int readCount;
			while((readCount = inputStream.read(bufferBytes)) != -1) {
				fos.write(bufferBytes, 0, readCount);
			}
			System.out.println("S:������ɣ�");
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
