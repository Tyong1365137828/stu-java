package edu.hebeu.url;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * �������չʾѧURL�����̵İ���
 * @author 13651
 *
 */
public class URL1 {
	
	public static void main(String[] args) {
		try {
			URL url = new URL("https://www.bilibili.com:9999/video/BV1Kb411W75N?p=629&spm_id_from=pageDriver");
			// public String getProtocol(); // ��ȡURLʵ�������Э����
			System.out.println("Э������" + url.getProtocol());
			// public String getHost(); // ��ȡURLʵ�������������
			System.out.println("��������" + url.getHost());
			// public String getPort(); // ��ȡURLʵ������Ķ˿ں�
			System.out.println("�˿ںţ�" + url.getPort());
			// public String getPath(); // ��ȡURLʵ��������ļ�·��
			System.out.println("�ļ�·����" + url.getPath());
			// public String getFile(); // ��ȡURLʵ��������ļ���
			System.out.println("�ļ�����" + url.getFile());
			// public String getQuery(); // ��ȡURLʵ������Ĳ�ѯ��
			System.out.println("��ѯ����" + url.getQuery());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
