package edu.hebeu.decompile;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Scanner;

/**
 * 这个例子展示如何通过反射机制实现反编译字节码文件中的Field
 * @author 13651
 *
 */
public class DecompileField {
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
		
		Field[] fields = cClass.getDeclaredFields(); // 获取这个类的全部Field对象
		for(Field f : fields) {
			cString.append("\t");
			int modifiersCode = f.getModifiers(); // 获取这个属性对象的修饰符列表的int数字
			String modifiersName = Modifier.toString(modifiersCode); // 通过上面的int数字获取这个int数字对应的String类型修饰符列表
			cString.append(modifiersName);
			cString.append(" ");
			
			Class<?> fieldTypeClass = f.getType(); // 获取这个属性对象的Class类型的类型名
			String fieldTypeName = fieldTypeClass.getSimpleName(); // 通过Class类型的类型名获取类型的名字
			cString.append(fieldTypeName);
			cString.append(" ");
			
			String fieldName = f.getName(); // 获取这个属性对象的名字
			cString.append(fieldName);
			cString.append(";\n");
		}
		
		cString.append("}");
		
		System.out.println(cString);
		
	}
}
