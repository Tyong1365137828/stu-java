package edu.hebeu.decompile;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.Scanner;

/**
 * 这个例子展示反编译构造方法
 * @author 13651
 *
 */
public class DecompileConstructor {
	public static void main(String[] args) {
		
		StringBuilder cString = new StringBuilder(); // 创建一个StringBuilder对象，用来存放反编译class文件之后的字符串信息
		
		Class<?> cClass = null; // 声明一个类的字节码
		
		Scanner scanner = null;
		try {
			scanner = new Scanner(System.in);
			System.out.print("请输入要反编译的类：");
			String className = scanner.next();
			cClass = Class.forName(className); // 获取整个类的字节码
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(null != scanner) {
				scanner.close();
			}
		}
		
		/**获取类的修饰符列表*/
		cString.append(Modifier.toString(cClass.getModifiers())); // 获取类的修饰符信息
		cString.append(" class ");
		/**获取类的简写名*/
		cString.append(cClass.getSimpleName()); // 获取类的简写类名(不包括包名)
		cString.append(" {\n");
		
		/**获取所有的构造方法*/
		Constructor[] constructors = cClass.getDeclaredConstructors();
		for(Constructor c : constructors) {
			cString.append("\t");
			
			/**获取构造方法的修饰符列表*/
			int modifiersCode = c.getModifiers();
			String modifiers = Modifier.toString(modifiersCode);
			cString.append(modifiers);
			cString.append(" ");
			
			/**获取构造方法名(构造方法名就是类的简写名)*/
			String constructorName = cClass.getSimpleName();
			cString.append(constructorName);
			cString.append(" ");
			
			/**获取形参列表*/
			cString.append("(");
			Class[] paramTypesClass = c.getParameterTypes();
			for(Class<?> paramTypeClass : paramTypesClass) {
				String paramType = paramTypeClass.getSimpleName(); // 获取参数类型简写名
				cString.append(paramType);
				cString.append(",");
			}
			int endCommaSubScript = cString.lastIndexOf(",");  // 获取最后一个 "," 的下标，如果没有 "," 就返回 -1
			if(endCommaSubScript != -1) cString.deleteCharAt(endCommaSubScript); // 截取掉倒数第一位的下标(即截取掉最后的 "," 1位字符)
			
			cString.append(") {}\n");
		}
		
		cString.append("}");
		
		System.out.println(cString);
		
	}
}
