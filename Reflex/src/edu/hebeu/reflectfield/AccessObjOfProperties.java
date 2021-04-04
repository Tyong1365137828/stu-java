package edu.hebeu.reflectfield;

import java.lang.reflect.Field;
import java.util.Date;

/**
 * 这个例子展示如何通过反射机制访问对象的属性
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
			obj = fieldEntityClass.newInstance(); // 通过无参构造方法创建这个字节码对应类的对象
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
			 * Class的方法：
			 * 	Field getDeclaredField(String propertiesName); // 通过属性名获取这个属性的Field对象
			 */
			fieldSex = fieldEntityClass.getDeclaredField("sex"); // 通过属性名获取属性对象(Field类型)
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/**
		 * 如果想要对默认的、protected、private的属性字段进行set(obj, value);即四种修饰都能访问，就需要将要访问的属性字段Field对象打破封装
		 * 	如：
		 * 		Field fieldAge = fieldEntityClass.getDeclaredField("age"); // 获取age属性对应的Field对象
		 * 		fieldAge.setAccessible(true); // 将fieldAge Field对象打破封装，因为age属性是protected的
		 * 
		 * 注意：这样做会产生问题(反射机制的缺点)：打破封装可能会给不法分子留下机会！
		 */
		
		try {
			/**
			 * Field的方法：
			 * 	void set(Class objClass, Object value); // 将objClass字节码对象的这个Field对象对应的属性赋值为value
			 * 		注意，只能访问public修饰符的属性(默认的、protected、private都不能访问)
			 */
			fieldSex.set(obj, 1); // 将obj这个对象的sex属性赋值为1
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
			 * Field方法：
			 * 	Object get(Object obj); // 获取obj对象的Field对象(属性字段)的值
			 */
			fieldSexValue = fieldSex.get(obj); // 获取obj对象的fieldSex属性字节码获取它的属性值
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
