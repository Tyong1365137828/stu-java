package edu.hebeu.reflectconstructor;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

/**
 * �������չʾ���ͨ��������Ƶ��ù��췽�����Դ�������
 * @author 13651
 *
 */
public class AccessObjOfConstructor {
	public static void main(String[] args) {
		Class constructorEntityClass = null;
		try {
			constructorEntityClass = Class.forName("edu.hebeu.entity.ConstructorEntity");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Object obj = null;
		try {
			obj = constructorEntityClass.newInstance(); // �����޲������췽����������JDK9֮���Ѿ���ʱ�����ù��췽������ʹ������ķ�ʽ��
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("obj��" + obj);
		
		Object obj2 = null;
		Constructor constructor = null;
		try {
			constructor = constructorEntityClass.getDeclaredConstructor(int.class, boolean.class, String.class, Date.class); // �����β�����Ϊ int��boolean��String��Date �Ĺ��췽��
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			obj2 = constructor.newInstance(110, true, "tyong", new Date()); // ͨ����ȡ���Ĺ��췽������ʵ�ν��е���������췽��
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		System.out.println("obj2��" + obj2);
		
	}
}
