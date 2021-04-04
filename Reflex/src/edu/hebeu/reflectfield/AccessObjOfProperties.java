package edu.hebeu.reflectfield;

import java.lang.reflect.Field;
import java.util.Date;

/**
 * �������չʾ���ͨ��������Ʒ��ʶ��������
 * @author 13651
 *
 */
public class AccessObjOfProperties {
	public static void main(String[] args) {
		
		Class fieldEntityClass = null;
		try {
			fieldEntityClass = Class.forName("edu.hebeu.entity.FieldEntity");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Object obj = null;
		try {
			obj = fieldEntityClass.newInstance(); // ͨ���޲ι��췽����������ֽ����Ӧ��Ķ���
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Field fieldSex = null;
		try {
			/**
			 * Class�ķ�����
			 * 	Field getDeclaredField(String propertiesName); // ͨ����������ȡ������Ե�Field����
			 */
			fieldSex = fieldEntityClass.getDeclaredField("sex"); // ͨ����������ȡ���Զ���(Field����)
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/**
		 * �����Ҫ��Ĭ�ϵġ�protected��private�������ֶν���set(obj, value);���������ζ��ܷ��ʣ�����Ҫ��Ҫ���ʵ������ֶ�Field������Ʒ�װ
		 * 	�磺
		 * 		Field fieldAge = fieldEntityClass.getDeclaredField("age"); // ��ȡage���Զ�Ӧ��Field����
		 * 		fieldAge.setAccessible(true); // ��fieldAge Field������Ʒ�װ����Ϊage������protected��
		 * 
		 * ע�⣺���������������(������Ƶ�ȱ��)�����Ʒ�װ���ܻ�������������»��ᣡ
		 */
		
		try {
			/**
			 * Field�ķ�����
			 * 	void set(Class objClass, Object value); // ��objClass�ֽ����������Field�����Ӧ�����Ը�ֵΪvalue
			 * 		ע�⣬ֻ�ܷ���public���η�������(Ĭ�ϵġ�protected��private�����ܷ���)
			 */
			fieldSex.set(obj, 1); // ��obj��������sex���Ը�ֵΪ1
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Object fieldSexValue = null;
		try {
			/**
			 * Field������
			 * 	Object get(Object obj); // ��ȡobj�����Field����(�����ֶ�)��ֵ
			 */
			fieldSexValue = fieldSex.get(obj); // ��ȡobj�����fieldSex�����ֽ����ȡ��������ֵ
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(fieldSexValue);
	}
}
