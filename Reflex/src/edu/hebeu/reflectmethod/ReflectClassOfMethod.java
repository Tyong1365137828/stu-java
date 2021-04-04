package edu.hebeu.reflectmethod;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * �������չʾ��η�����ķ���
 * @author 13651
 *
 */
public class ReflectClassOfMethod {
	public static void main(String[] args) {
		
		Class methodEntityClass = null;
		try {
			methodEntityClass = Class.forName("edu.hebeu.entity.MethodEntity");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/**��ȡ����ֽ����������public���εķ���*/
		Method[] methods = methodEntityClass.getMethods();
		for(Method m : methods) {
			/**
			 * Method�ķ�����
			 * 	String getName(); // ��ȡMethod����(�˷�������)�����ƣ���String��ʽ����
			 * 	Class getReturnType(); // ��ȡMethod����(�˷�������)�ķ���ֵ���ͣ���Class��ʽ����
			 * 	Class[] getParameterTypes(); // ��ȡMethod�����(�˷�������)�Ĳ��������б���Class[] ��ʽ����
			 */
			String methodName = m.getName();
			Class methodReturnTypeClass = m.getReturnType();
			String methodReturnType = methodReturnTypeClass.getSimpleName();
			int modifiersCode = m.getModifiers(); // ��ȡ�˷�����������η���ֵ
			String modifiers = Modifier.toString(modifiersCode); // ��ȡ�˷�����������η�
			Class[] paramTypes = m.getParameterTypes();
			
			
			System.out.print("��������" + methodName + "; ����ֵ���ͣ�" + methodReturnType + "; ���η���" + modifiers);
			System.out.print("; �β���ʽ��"); classArrayPrint(paramTypes);
		}
		
	}
	
	/**
	 * Class���͵������������
	 * @param cClass
	 */
	public static void classArrayPrint(Class[] cClass) {
		for(int i = 0; i < cClass.length; i++) {
			System.out.print(cClass[i].getSimpleName());
			if(i < cClass.length - 1) System.out.print(", ");
		}System.out.println();
	}
}
