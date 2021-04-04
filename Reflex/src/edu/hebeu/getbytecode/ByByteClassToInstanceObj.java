package edu.hebeu.getbytecode;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import edu.hebeu.entity.User;

/**
 * 这个例子展示如何通过字节码(Class对象)创建对象
 * 
 * 关键方法：
 * 	Class的静态方法：
 * 		Class forName(classInfoOfName); // 这个方法会导致传入的这个类进行 类加载，并返回这个类的字节码
 * 			// 注意：类加载会导致静态代码块执行，并且静态代码块只执行一次；
 * 
 * 	Class类的实例方法：
 * 		E newInstance(); // 这个方法会调用字节码对应类的无参构造方法进行创建对象；E是Class指定的泛型，未指定为Object
 * 
 * 如下面的代码(通过读取配置文件的信息创建类对象)：这样做Java的代码写一遍，再之后不改变Java源代码的基础之上，
 * 直接修改属性配置文件内容，做到不同对象的实例化，非常灵活；符合OCP开闭原则(对扩展开放，对修改关闭)
 * @author 13651
 *
 */
public class ByByteClassToInstanceObj {
	public static void main(String[] args) {
		/**读取类信息 属性配置文件 classInfo.properties*/
		FileReader fr = null; // 声明Reader读取流
		Properties classProperties = null; // 声明存放流内容的Map集合 Properties
		try {
			fr = new FileReader("data\\classInfo.properties");
			
			/**将读取到的信息加载到Map集合 Properties*/
			classProperties = new Properties();
			try {
				classProperties.load(fr); // 将流加载如Map集合 Properties
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			if(null != fr) {
				try {
					fr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		/**获取Map集合内存放的信息*/
		String classInfoOfName = classProperties.getProperty("className");
		
		try {
//			Class cClass = Class.forName("edu.hebeu.entity.User"); // 获取edu.hebeu.entity.User类的字节码
//			Class.forName(classInfoOfName); // 执行这个方法会导致传入的这个类进行 类加载，类加载会导致静态代码块执行，并且静态代码块只执行一次
			Class cClass = Class.forName(classInfoOfName);
			Object userObj = cClass.newInstance();
			
//			Class<User> userClass = (Class<User>)Class.forName("edu.hebeu.entity.User");
//			User userObj = userClass.newInstance();
			
			System.out.println(userObj);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
