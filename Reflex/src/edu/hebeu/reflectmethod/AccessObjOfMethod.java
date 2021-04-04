package edu.hebeu.reflectmethod;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * �������չʾ���ͨ���������ִ�з���(��ͨ���������ʵ�ֶ������ʵ������)
 * @author 13651
 *
 */
public class AccessObjOfMethod {
	public static void main(String[] args) {
		Class methodEntityClass = null;
		try {
			methodEntityClass = Class.forName("edu.hebeu.entity.MethodEntity");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Object obj = null;
		try {
			obj = methodEntityClass.newInstance(); // �����޲ι��췽��ͨ���ֽ��봴������
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Method loginMethod =null;
		try {
			loginMethod = methodEntityClass.getDeclaredMethod("login", String.class, String.class); // ͨ�����������β����ͻ�ȡmethodEntityClass(MethodEntity�ֽ���)��login(String, String)����(Method����)
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Object loginSuccess = null;
		try {
			/**
			 * ������ʾ��
			 * 	����obj�����loginMethod����(login��Ӧ��Method����)�����ݲ��� "1365137828", "0727316052"������ֵͨ��loginSuccess����
			 */
			loginSuccess = loginMethod.invoke(obj, "1365137828", "0727316052"); // ����ʵ������(ִ��)
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("��¼�ɹ����" + loginSuccess);
		
	}
}
