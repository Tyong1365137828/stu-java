package edu.hebeu.map.hashtable.properties;

import java.util.Properties;

/**
 * ��ʾProperties���ϵ�ѧϰ��
 * 	Properties��Map���ϣ��̳�Hashtable���ϣ�Properties���ϵ�key��value����String���ͣ�
 * 	Properties����Ϊ���������Properties���̰߳�ȫ�ģ�
 * 
 * ���÷�����
 * 	void setProperty(String key, String value); // �����Hashtable��put()����������һ��Ԫ��
 * 	String value = getProperty(String key); // ͨ��key��ȡvalue
 * @author 13651
 *
 */
public class PropertiesStu {
	public static void main(String[] args) {
		// ����һ��Properties����
		Properties p = new Properties();
		
		// Properties��Ԫ�أ�ע������key��value��ֻ����String���͵�
		p.setProperty("url", "jdbc:mysql://127.0.0.1:3306/test");
		p.setProperty("driver", "com.mysql.jdbc.Driver");
		p.setProperty("username", "root");
		p.setProperty("password", "0727316052");
		
		// PropertiesȡԪ��
		String s1 = p.getProperty("url");
		String s2 = p.getProperty("driver");
		String s3 = p.getProperty("username");
		String s4 = p.getProperty("password");
		
		System.out.println("URL��" + s1 + "; ������" + s2 + "; �û�����" + s3 + "; ���룺" + s4);
	}
}
