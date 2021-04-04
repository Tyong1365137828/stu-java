package edu.hebeu.test;

import java.lang.reflect.Method;

import edu.hebeu.annotation.MyAnnotation;
import edu.hebeu.annotation.MyAnnotation4;

/**
 * ���������������MyAnnotation4��ע��
 * @author 13651
 *
 */

public class MyAnnotation4Test {
	public static void main(String[] args) {
		
		Class<?> cClass = null;
		try {
			cClass = Class.forName("edu.hebeu.test.MyClass");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/**
		 * isAnnotationPresent(Annotation���͵��ֽ���)
		 * ������ʾ��
		 */
		boolean isExist = cClass.isAnnotationPresent(MyAnnotation4.class);
		System.out.println("MyClass���Ƿ����MyAnnotation4ע�⣿" + isExist);
		
		if(isExist) { // ���Ϊtrue����MyClass���ϴ���MyAnnotation4ע��
			/**
			 * public <A extends Annotation> A getAnnotation(Class<A> annotationClass)
			 * ͨ��Aע����ֽ����ȡA��ע����󣬷���Aע����Ķ���
			 * ������ʾ��
			 */
			MyAnnotation4 myAnnotation4 = (MyAnnotation4)cClass.getAnnotation(MyAnnotation4.class); // ����ת��
			System.out.println("MyClass���ϵ�ע�����" + myAnnotation4);
			
			/**
			 *��ȡע���������� ������ͨJava�����Ļ�ȡ����һ��
			 */
			String addressClassUseS = myAnnotation4.address();
			String describeClassUseS = myAnnotation4.describe();
			System.out.println("MyAnnotation4����ע������ԣ�address = " + addressClassUseS + "; describe = " + describeClassUseS);
			
			/**
			 * ��ȡ�����ϵ�ע������
			 */
			Method doSomeMethod = null;
			try {
				doSomeMethod = cClass.getDeclaredMethod("doSome"); // ��ȡ��Ϊ doSome() �ķ���
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(doSomeMethod.isAnnotationPresent(MyAnnotation4.class)) { // ���doSome()�����ϴ���MyAnnotation��ע��
				MyAnnotation4 myAnnotation4MethodUse = doSomeMethod.getAnnotation(MyAnnotation4.class);
				String addressMethodUseS = myAnnotation4MethodUse.address();
				String describeMethodUseS = myAnnotation4MethodUse.describe();
				System.out.println("MyAnnotation���doSome()�����ϵ�ע������ԣ�address = " + addressMethodUseS + "; describe = " + describeMethodUseS);
			}
			
		}
		
		boolean isExist2 = cClass.isAnnotationPresent(MyAnnotation.class);
		System.out.println("MyClass���Ƿ����MyAnnotationע�⣿" + isExist2);
		
		
		
		
	}
}

@MyAnnotation4(describe = "��")
class MyClass {
	
	@MyAnnotation4(address = "����ʡ", describe = "����")
	public void doSome() {
		System.out.println("doSome...");
	}
}
