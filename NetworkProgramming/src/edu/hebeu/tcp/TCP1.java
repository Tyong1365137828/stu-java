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
 * ���������ʾһ������TCP�����̵İ������ͻ��������˷�����Ϣ
 * @author 13651
 *
 */
public class TCP1 {
	
	/**
	 * �������ģ��һ���ͻ���
	 */
	@Test
	public void client() {
		Socket socket = null;
		OutputStream outputStream = null;
		
		try {
			InetAddress inetAddress = InetAddress.getByName("127.0.0.1"); // ����Ҫ����ͨ�ŵ�������IP
			socket = new Socket(inetAddress, 8899);
			
			outputStream = socket.getOutputStream(); // ��ȡһ�������
			outputStream.write("���ǿͻ���client������Ҫ���㷢������".getBytes());
			
			
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
	 * �������ģ��һ�������
	 */
	@Test
	public void server() {
		ServerSocket serverSocket = null;
		Socket socket = null;
		InputStream inputStream = null;
		ByteArrayOutputStream baos = null; // ������ײ���һ�����Զ����ݵ��ֽ����飬�����յ��ֽڻ��ȴ�ţ���������ɺ��ֽ�����һ�����ת��(���������������Ļ���������ʱ���Բ����������)
		
		try {
			serverSocket = new ServerSocket(8899); // ����һ������ˣ�ָ���Լ��Ķ˿ں�
			socket = serverSocket.accept(); // �������տͻ��˵���Ϣ
			inputStream = socket.getInputStream(); // ��ȡ�ͻ��˷�������Ϣ��
			
			System.out.println("��ȡ���Է����" + socket.getInetAddress() + "����Ϣ��");
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
