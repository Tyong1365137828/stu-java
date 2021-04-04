package edu.hebeu.objectstream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 序列化多个对象：
 * 	实现：将对象放到集合中，序列化集合即可
 * 	参与序列化的集合、类都需要实现Serializable接口！！！
 * 	
 * 	序列化对象时，存储多个对象，存储第二个会报错！！！
 * 
 * 	注意：集合类已经实现了Serializable接口！！！
 * 
 * @author 13651
 *
 */
public class SerrializableMoreObj {
	public static void main(String[] args) {
		List<ObjStudent> studentList = new ArrayList<>(); // 创建ObjStudent泛型的集合
		
		// 创建对象
		ObjStudent os1 = new ObjStudent("4155", "test01", 21);
		ObjStudent os2 = new ObjStudent("4556", "test02", 20);
		ObjStudent os3 = new ObjStudent("4542", "test03", 20);
		ObjStudent os4 = new ObjStudent("2323", "test04", 22);
		ObjStudent os5 = new ObjStudent("4155", "test05", 21);
		ObjStudent os6 = new ObjStudent("1242", "test06", 24);
		ObjStudent os7 = new ObjStudent("1215", "test07", 19);
		ObjStudent os8 = new ObjStudent("5674", "test08", 20);
		
		// 添加至集合
		studentList.add(os1);
		studentList.add(os2);
		studentList.add(os3);
		studentList.add(os4);
		studentList.add(os5);
		studentList.add(os6);
		studentList.add(os7);
		studentList.add(os8);
				
		ObjectOutputStream oos = null; // 声明ObjectOutputStream类对象
		try {
			oos = new ObjectOutputStream(new FileOutputStream("data\\serializable\\students")); // 创建ObjectOutputStream类对象
			
			// 序列化集合(序列化多个对象)
			oos.writeObject(studentList);
			
			oos.flush(); // 输出流用完之后要刷新，清空管道
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
}
