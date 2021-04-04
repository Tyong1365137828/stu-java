package edu.hebeu.reflectconstructor;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

/**
 * 这个例子展示如何通过反射机制获取类的构造方法
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

		Constructor[] constructors = constructorEntityClass.getDeclaredConstructors(); // 获取这个类的所有的构造方法
		for(Constructor c : constructors) {
			int modifiersCode = c.getModifiers();
			String modifiers = Modifier.toString(modifiersCode);
			
			String constructorName = c.getName();
			
			Class[] paramTypesClass = c.getParameterTypes();
			
			System.out.print("构造方法名：" + constructorName + "; 修饰符：" + modifiers);
			System.out.print("; 形参形式："); classArrayPrint(paramTypesClass);
			
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
