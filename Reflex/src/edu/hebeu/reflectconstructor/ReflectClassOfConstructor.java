package edu.hebeu.reflectconstructor;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

/**
 * �������չʾ���ͨ��������ƻ�ȡ��Ĺ��췽��
 * @author 13651
 *
 */
public class ReflectClassOfConstructor {
	public static void main(String[] args) {
		Class constructorEntityClass = null;
		try {
			constructorEntityClass = Class.forName("edu.hebeu.entity.ConstructorEntity");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Constructor[] constructors = constructorEntityClass.getDeclaredConstructors(); // ��ȡ���������еĹ��췽��
		for(Constructor c : constructors) {
			int modifiersCode = c.getModifiers();
			String modifiers = Modifier.toString(modifiersCode);
			
			String constructorName = c.getName();
			
			Class[] paramTypesClass = c.getParameterTypes();
			
			System.out.print("���췽������" + constructorName + "; ���η���" + modifiers);
			System.out.print("; �β���ʽ��"); classArrayPrint(paramTypesClass);
			
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
