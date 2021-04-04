package edu.hebeu.decompile;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

/**
 * 这个例子展示反编译方法
 * @author 13651
 *
 */
public class DecompileMethod {
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
		
		cString.append(Modifier.toString(cClass.getModifiers())); // 获取类的修饰符信息
		cString.append(" class ");
		cString.append(cClass.getSimpleName()); // 获取类的简写类名(不包括包名)
		cString.append(" {\n");
		
		Method[] methods = cClass.getDeclaredMethods(); // 获取这个类的全部Method对象
		for(Method m : methods) {
			cString.append("\t");
			int modifiersCode = m.getModifiers(); // 获取这个属性对象的修饰符列表的int数字
			String modifiersName = Modifier.toString(modifiersCode); // 通过上面的int数字获取这个int数字对应的String类型修饰符列表
			cString.append(modifiersName);
			cString.append(" ");
			
			Class<?> methodReturnTypeClass = m.getReturnType(); // 获取这个方法对象的返回值的Class类型的类型名
			String methodReturnTypeName = methodReturnTypeClass.getSimpleName(); // 通过Class类型的类型名获取类型的名字
			cString.append(methodReturnTypeName);
			cString.append(" ");
			
			String methodName = m.getName(); // 获取这个方法对象(Method对象)的名字
			cString.append(methodName);
			cString.append("(");
			
			Class[] paramClassTypes = m.getParameterTypes(); // 获取这个方法的形参类型，Class数组形式接收
			for(Class paramClassType : paramClassTypes) {
				cString.append(paramClassType.getSimpleName());
				cString.append(",");
			}
			int commaSubScript = cString.lastIndexOf(",");  // 获取最后一个 "," 的下标，如果没有 "," 就返回 -1
			if(commaSubScript != -1) cString.deleteCharAt(commaSubScript); // 截取掉倒数第一位的下标(即截取掉最后的 "," 1位字符)
			
			cString.append(") {}\n");
		}
		
		cString.append("}");
		
		System.out.println(cString);
	}
}
