package edu.hebeu.getbytecode;

import java.util.Date;

/**
 * 要操作一个类的字节码，首先要获取这个类的字节码；
 * 
 * 第一种方式获取类的字节码：Class c = Class.forName("完整类名带包名");
 * java.lang.Class类的静态方法forName(String classFullName);
 * 
 * 	如：	Class static forName(String classFullName); // 获取classFullName类的字节码，注意classFullName类必须是类的全限定名(即包括包名)；
 * 		Class c1 = Class.forName("java.lang.String");
 * 
 * 
 * 
 * 第二种方式获取类的字节码: Class c = 对象.getClass();
 * java中任何一个对象都有getClass()方法
 * 
 * 如：String s = "abc"; Class c = s.getClass();
 * 
 * 
 * 
 * 第三种方式获取类的字节码：Java语言中，任何一种类型，包括基本数据类型，都有class属性；
 * 	如：	Class c1 = int.class;	Class c2 = Object.class;	Class c3 = Date.class;	Class c4 = String.class;
 * 
 * @author 13651
 *
 */
public class GetByteCode01 {
	public static void main(String[] args) {
		
		/**第一种方式获取类的字节码*/
		try {
			Class c1 = Class.forName("java.lang.String"); // 此时c1代表String.class文件，或者说c1代表String类型
			Class c2 = Class.forName("java.util.Date"); // 此时c2代表Date类型
			Class c3 = Class.forName("java.lang.Integer"); // 此时c3代表Integer类型
			Class c4 = Class.forName("java.lang.Double"); // 此时c4代表Double类型
			Class c5 = Class.forName("java.lang.System"); // 此时c5代表System类型
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		Class c1 = null;
		Class c2 = null;
		try {
			c1 = Class.forName("java.lang.String");
			c2 = Class.forName("java.util.Date");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/**第二种方式获取类的字节码*/
		String s = "abc";
		Class x = s.getClass();
		System.out.println(c1 == x); // == 比较的是内存地址，c1和x对象都指向方法区的字节码文件(String.class)
		
		Date d = new Date();
		Class y = d.getClass();
		System.out.println(c2 == y); // == 比较的是内存地址，c2和y对象都指向方法区的字节码文件(Date.class)
		
		
		
		/**Java语言中，任何一种类型，包括基本数据类型，都有class属性*/
		Class intClass = int.class; // intClass代表int类型
		Class stringClass = String.class; // stringClass代表String类型
		Class dateClass = Date.class; // dateClass代表Date类型
		Class intClass2 = int.class;
		
		System.out.println(intClass == intClass2);
		
	}
}
