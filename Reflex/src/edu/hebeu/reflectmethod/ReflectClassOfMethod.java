package edu.hebeu.reflectmethod;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * 这个例子展示如何反射类的方法
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
		
		/**获取这个字节码类的所有public修饰的方法*/
		Method[] methods = methodEntityClass.getMethods();
		for(Method m : methods) {
			/**
			 * Method的方法：
			 * 	String getName(); // 获取Method对象(此方法对象)的名称，以String形式返回
			 * 	Class getReturnType(); // 获取Method对象(此方法对象)的返回值类型，以Class形式返回
			 * 	Class[] getParameterTypes(); // 获取Method对象的(此方法对象)的参数类型列表，以Class[] 形式返回
			 */
			String methodName = m.getName();
			Class methodReturnTypeClass = m.getReturnType();
			String methodReturnType = methodReturnTypeClass.getSimpleName();
			int modifiersCode = m.getModifiers(); // 获取此方法对象的修饰符数值
			String modifiers = Modifier.toString(modifiersCode); // 获取此方法对象的修饰符
			Class[] paramTypes = m.getParameterTypes();
			
			
			System.out.print("方法名：" + methodName + "; 返回值类型：" + methodReturnType + "; 修饰符：" + modifiers);
			System.out.print("; 形参形式："); classArrayPrint(paramTypes);
		}
		
	}
	
	/**
	 * Class类型的数组输出方法
	 * @param cClass
	 */
	public static void classArrayPrint(Class[] cClass) {
		for(int i = 0; i < cClass.length; i++) {
			System.out.print(cClass[i].getSimpleName());
			if(i < cClass.length - 1) System.out.print(", ");
		}System.out.println();
	}
}
