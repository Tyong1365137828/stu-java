package edu.hebeu.reflectfield;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * 这个例子展示如何通过反射机制访问类的字段(属性)
 * @author 13651
 *
 */
public class ReflectClassOfField {
	public static void main(String[] args) {
		
		Class fieldEntityClass = null;
		try {
			fieldEntityClass = Class.forName("edu.hebeu.entity.FieldEntity"); // 获取这个类的字节码
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/**
		 * 获取字节码对象的类名：
		 * 	String fullName getName(); // 获取Class对象的全类名(包括包名)
		 * 	String simpleName getSimpleName(); // 获取Class对象的简写类名(不包括包名)
		 */
		String fieldEntityClassName = fieldEntityClass.getName();
		String fieldEntityClassSimpleName = fieldEntityClass.getSimpleName();
		System.out.println("字节码对象的类名：" + fieldEntityClassName + ";Simple类名：" + fieldEntityClassSimpleName);
		
		/**
		 * Class的方法：
		 * 获取这个类中所有的由public修饰的属性字段：Field[] getFields();
		 */
		Field[] fields = fieldEntityClass.getFields();
		System.out.println("通过getFields()方法获取所有的public属性长度：" + fields.length);
		for(Field f : fields) {
			/**
			 * Field类的方法：
			 * 	获取Field对象的属性名：String getName()；
			 * 	获取Field对象的属性类型：Class getType();
			 * 	获取Field对象的属性修饰符列表：int getModifiers();
			 * 
			 * Modifier类的方法：
			 * 	通过修饰符的int类型码转变为String类型的修饰符名：String static toString(int modifierCode);
			 * 		如：String modifierName = Modifier.toString(1); // public
			 * 
			 */
			String fieldName = f.getName();
			Class fieldTypeclass = f.getType();
			String fieldTypeName = fieldTypeclass.getSimpleName();
			int modifierCode = f.getModifiers();
			
			System.out.print("属性名:" + fieldName + ",属性类型:" + fieldTypeName + ",属性修饰符列表：【" + Modifier.toString(modifierCode) + "】;		");
		}System.out.println();
		
		/**
		 * Class类的方法：
		 * 	获取这个类所有的属性字段：Field[] getDeclaredFields();
		 */
		Field[] fields2 = fieldEntityClass.getDeclaredFields();
		System.out.println("通过getDeclaredFields()方法获取所有的属性字段长度：" + fields2.length);
		for(Field f : fields2) {
			/**
			 * Field类的方法：
			 * 	获取Field对象的属性名：String getName();
			 * 	获取Field对象的类型：Class getType();
			 * 	获取Field对象的属性修饰符列表：int getModifiers();
			 * 
			 * Modifier类的方法：
			 * 	通过修饰符的int类型码转变为String类型的修饰符名：String static toString(int modifierCode);
			 * 		如：String modifierName = Modifier.toString(2); // private
			 */
			String fieldName = f.getName();
			Class fieldTypeclass = f.getType();
			String fieldTypeName = fieldTypeclass.getSimpleName();
			int modifierCode = f.getModifiers();
			
			System.out.print("属性名:" + fieldName + ",属性类型:" + fieldTypeName + ",属性修饰符列表：【" + Modifier.toString(modifierCode) + "】;		");
		}System.out.println();
		
	}
}
