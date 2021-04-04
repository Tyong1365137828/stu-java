package edu.hebeu.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import org.junit.Test;

/**
 * �������չʾѧϰUDP�����̵İ���
 * @author 13651
 *
 */
public class UDP1 {
	
	/**
	 * �ͻ���
	 */
	@Test
	public void client() {
		
		DatagramSocket ds = null;
		
		try {
			ds = new DatagramSocket();
			
			byte[] data = "����ͨ��UID��ʽ���͵��ַ���".getBytes(); // ׼��Ҫ���͵����ݣ�����ת��Ϊ�ֽ�����
			InetAddress targetAddress = InetAddress.getByName("127.0.0.1"); // Ҫ���͵���Ŀ���ַ
			DatagramPacket dp = new DatagramPacket(data, 0, data.length, targetAddress, 8899); // �������ݰ�
			ds.send(dp); // �������ݰ�
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
	 * �����
	 */
	@Test
	public void server() {
		DatagramSocket ds = null;
		
		try {
			ds = new DatagramSocket(8899);
			
			byte[] buffer = new byte[1000];
			DatagramPacket dp = new DatagramPacket(buffer, 0, buffer.length); // �������ݰ�����
			
			ds.receive(dp); // �������ݰ�
			
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
