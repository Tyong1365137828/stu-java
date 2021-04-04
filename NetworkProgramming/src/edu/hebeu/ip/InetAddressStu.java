package edu.hebeu.ip;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * �����ѧϰJava�ж������IP��װ���� InetAddress��
 * 
 * 1��InetAddress�����Ĺ��췽���Ѿ�˽�л���
 * 2����λ�ȡ InetAddress������ʵ��������������������
 * 		InetAddress getByName(String hostName); // �����������ͨ��IP��ַ ���� �������� InetAddressʵ��(����ע�⣺ǰ�߲������DNS�������������߻������������)
 * 		InetAddress getLocalHost(); // ��ȡ������IP��Ӧ�� InetAddressʵ��
 * 3��InetAddressʵ���ĳ��÷�����
 * 		String getHostName(); // ��ȡ��� InetAddressʵ����������
 * 		String getHostAddress(); // ��ȡ��� InetAddressʵ����IP��ַ
 * 
 * @author 13651
 *
 */
public class InetAddressStu {
	
	public static void main(String[] args) {
		try {
			InetAddress inetAddress = InetAddress.getByName("127.0.0.1"); // ��ȡIPΪ 127.0.0.1 ��������IP����
			InetAddress inetAddress2 = InetAddress.getByName("tyong-top.design"); // ��ȡ����Ϊ tyong-top.design ��������IP����
			InetAddress inetAddress3 = InetAddress.getLocalHost(); // ��ȡ����������IP����
			
			System.out.println("inetAddress: " + inetAddress.getHostName() + ", " + inetAddress.getHostAddress()); // ��ȡ���IP�����ע������IP��ַ
			System.out.println("inetAddress2: " + inetAddress2.getHostName() + ", " + inetAddress2.getHostAddress()); // ��ȡ���IP�����ע������IP��ַ
			System.out.println("inetAddress3: " + inetAddress3.getHostName() + ", " + inetAddress3.getHostAddress()); // ��ȡ���IP�����ע������IP��ַ
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
