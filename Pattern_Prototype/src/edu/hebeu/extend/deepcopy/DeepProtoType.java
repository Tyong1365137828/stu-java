package edu.hebeu.extend.deepcopy;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class DeepProtoType implements Serializable, Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String name; //String 属 性
	public DeepCloneableTarget deepCloneableTarget;// 引用类型
	
	public DeepProtoType() {
		super();
	}

	// 深拷贝实现的第一种方式
	@Override
	protected Object clone() throws CloneNotSupportedException {
		Object objClone = null;
		// 这里会先将 DeepProtoType实例的 基本数据类型和String类型进行克隆
		objClone = super.clone();
		
		// 这里将引用类型进行克隆
		DeepProtoType deepProtoTypeClone = (DeepProtoType) objClone;
		deepProtoTypeClone.deepCloneableTarget = (DeepCloneableTarget) deepCloneableTarget.clone();
		
		return deepProtoTypeClone;
	}
	
	// 深拷贝的实现，通过第二种方式(推荐使用这种方式)，对象的序列化和反序列化实现深克隆
	public Object deepClone() {
		
		// 声明克隆的对象
		DeepProtoType deepProtoType = null;
		
		// 声明要使用的流对象
		ByteArrayOutputStream baos = null;
		ByteArrayInputStream bais = null;
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		
		
		try {
			
			// 序列化
			baos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(baos);
			oos.writeObject(this);// 将对象序列化
			
			// 反序列化
			bais = new ByteArrayInputStream(baos.toByteArray());
			ois = new ObjectInputStream(bais);
			deepProtoType = (DeepProtoType) ois.readObject(); // 将序列化的对象反序列化，并接收这个对象
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(baos != null) {
				try {
					baos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(bais != null) {
				try {
					bais.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(ois != null) {
				try {
					ois.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return deepProtoType;
	}
	
	
}
