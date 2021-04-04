package edu.hebeu.objectstream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * 序列化：使用ObjectOutputStream流实现，
 * 
 * 	参与序列化和反序列化的类必须实现Serializable接口，否则会出现异常：java.io.NotSerializableException;(即不能序列化)
 * 
 * 	注意：通过源代码发现，Serializable接口只是一个标志接口，内部什么代码也没有，起到标识符作用，Java虚拟机可能会对这个类特殊待遇；
 * Serializable这个接口是给Java虚拟机参考的，Java虚拟机看到这个接口之后，会为该类自动生成一个序列化版本号；
 * 
 * 序列化版本号的作用：
 * 	
 * 
 * @author 13651
 *
 */
public class ObjectOutputStreamStu {
	public static void main(String[] args) {
		ObjStudent os = new ObjStudent("1365", "test", 20);
		ObjectOutputStream oos = null; // 声明ObjectOutputStream对象
		
		try {
			oos = new ObjectOutputStream(new FileOutputStream("data\\serializable\\student"));// 创建ObjectOutputStream对象
			
			oos.writeObject(os); // 序列化对象(序列化一个)
			
			oos.flush(); // 使用完输出流之后要刷新，清空管道
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
