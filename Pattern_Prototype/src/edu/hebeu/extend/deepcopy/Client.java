package edu.hebeu.extend.deepcopy;

/**
 * 这里使用深克隆
 * @author 13651
 *
 */
public class Client {
	public static void main(String[] args) throws CloneNotSupportedException {
		DeepProtoType deepProtoType = new DeepProtoType();
		deepProtoType.name = "小大";
		deepProtoType.deepCloneableTarget = new DeepCloneableTarget("大马", "马类");
		
		
		// 测试方式1实现的深拷贝
		DeepProtoType deepProtoTypeClone1 = null;
		try {
			deepProtoTypeClone1 = (DeepProtoType) deepProtoType.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("deepProtoType.name = " + deepProtoType.name + "; deepProtoType.deepCloneableTarget的hashCode = " + deepProtoType.deepCloneableTarget.hashCode());
		System.out.println("deepProtoTypeClone1.name = " + deepProtoTypeClone1.name + "; deepProtoTypeClone1.deepCloneableTarget的hashCode = " + deepProtoTypeClone1.deepCloneableTarget.hashCode());
		
		
		// 测试方式2实现的深拷贝
		DeepProtoType deepProtoTypeClone2 = null;
		deepProtoTypeClone2 = (DeepProtoType) deepProtoType.deepClone();
		System.out.println("deepProtoType.name = " + deepProtoType.name + "; deepProtoType.deepCloneableTarget的hashCode = " + deepProtoType.deepCloneableTarget.hashCode());
		System.out.println("deepProtoTypeClone2.name = " + deepProtoTypeClone2.name + "; deepProtoTypeClone2.deepCloneableTarget的hashCode = " + deepProtoTypeClone2.deepCloneableTarget.hashCode());
		
		
		
		/*
		 * 此时发现通过deepProtoType实例克隆的实例deepProtoTypeClone1实例，两者的引用属性deepCloneableTarget的hashCode值不一样，
		 * 所以可以肯定，deepProtoType内的引用类型也被克隆了(deepProtoType实现了深克隆);
		 */
	}
}
