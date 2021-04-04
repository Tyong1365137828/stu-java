package edu.hebeu.objectstream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * 反序列化：ObjectInputStream流实现
 * 
 * 序列化版本号的作用：
 * 	java.io.InvalidClassException: edu.hebeu.objectstream.ObjStudent; local class incompatible: 
 * 	stream classdesc serialVersionUID = -2623336853608940719, // 这是改动之后
 * 	local class serialVersionUID = -1160564518340679496 // 这是改动之前
 *	当序列化完成后，又改动代码，在进行反序列化会出现上面的异常
 *
 * 引出：Java靠什么区分类？
 * 	第一：首先通过类名比较，如果类名不一样，肯定不是同一个类；
 * 	第二：如果类名一样，会通过序列化版本号比较这两个类是不是一个类；
 * 
 *	序列化版本号建议手动的写出来；(可以放心的写，只要保证同类名的类的序列化版本号不一样就可以)；因为这样做会在一个类的
 *对象序列化之后，改动代码，再进行反序列化不会出现上面的异常；
 *
 *	如果是通过JVM虚拟机自动生成的，在序列化完成之后改动代码，class运行之后JVM在就会重新生成序列化版本号，因为版本号的不
 *同JVM就不会识别之前序列化之后的对象；就会出现以上的异常信息；
 *
 *	如：A程序员编写了类 edu.hebeu.test.Test
 *		B程序员编写了类 edu.hebeu.test.Test
 *		不同的人编写了同一个名字的类(这两个类确实是不一样的)，此时同名的类要让JVM区分，序列化版本号就派上用场了。
 *	  对于Java虚拟机JVM来说，它是可以区分这两个类的，因为这两个类都实现了Serializable接口，都有默认的序列化版本
 *	  号，它们的序列化版本号不同，就区分开了(不可否认这是自动生成序列化版本号的好处)
 * 	  但是自动生成序列化版本号这种方式是不建议的，其缺陷：
 * 		1、一旦代码生成之后(序列化之后)，不能进行后续的更改，因为只要更改，必然会重新编译，此时JVM会生成全新的序列化版本号，
 * 	  此时Java虚拟机就会将其认为是一个全新的类(这样子不好)，如果不重新序列化，JVM会认为修改后的类是全新的，不能进行反序列化操作了；
 * 
 * 结论：
 * 	凡是一个类实现了Serializable接口，建议给这个类手动提供一个不变的序列化版本号，而不是通过JVM自动生成的序列化版本号；
 * 	这样，这个类在序列化之后，即使更改代码，但是版本号不变，JVM还会认为其是同一个类，保证反序列化能够成功；

 * 
 * @author 13651
 *
 */
public class ObjectInputStreamStu {

	public static void main(String[] args) {
		ObjectInputStream ois = null;
		
		try {
			ois = new ObjectInputStream(new FileInputStream("data\\serializable\\student"));
			Object obj = ois.readObject(); // 进行反序列化
			System.out.println("反序列化之后的结果：" + obj);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(ois != null) {
				try {
					ois.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
