package edu.hebeu.objectstream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

/**
 * 反序列化多个对象：
 * 	实现：
 * @author 13651
 *
 */
public class DeSerrializableMoreObj {
	public static void main(String[] args) {
		ObjectInputStream ois = null;
		
		try {
			ois = new ObjectInputStream(new FileInputStream("data\\serializable\\students"));
			
			// 反序列化多个对象
//			Object obj = ois.readObject();
//			System.out.print("反序列化后的返回值是否为集合："); System.out.println(obj instanceof List);
			System.out.println("反序列化多个对象的结果：");
			List<ObjStudent> studentList = (List<ObjStudent>)ois.readObject(); // 将返回值为Object的类向下转型为List集合
			for(ObjStudent student : studentList) {
				System.out.println(student);
			}
			
			
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
