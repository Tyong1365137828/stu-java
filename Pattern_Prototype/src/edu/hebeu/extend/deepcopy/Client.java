package edu.hebeu.extend.deepcopy;

/**
 * ����ʹ�����¡
 * @author 13651
 *
 */
public class Client {
	public static void main(String[] args) throws CloneNotSupportedException {
		DeepProtoType deepProtoType = new DeepProtoType();
		deepProtoType.name = "С��";
		deepProtoType.deepCloneableTarget = new DeepCloneableTarget("����", "����");
		
		
		// ���Է�ʽ1ʵ�ֵ����
		DeepProtoType deepProtoTypeClone1 = null;
		try {
			deepProtoTypeClone1 = (DeepProtoType) deepProtoType.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("deepProtoType.name = " + deepProtoType.name + "; deepProtoType.deepCloneableTarget��hashCode = " + deepProtoType.deepCloneableTarget.hashCode());
		System.out.println("deepProtoTypeClone1.name = " + deepProtoTypeClone1.name + "; deepProtoTypeClone1.deepCloneableTarget��hashCode = " + deepProtoTypeClone1.deepCloneableTarget.hashCode());
		
		
		// ���Է�ʽ2ʵ�ֵ����
		DeepProtoType deepProtoTypeClone2 = null;
		deepProtoTypeClone2 = (DeepProtoType) deepProtoType.deepClone();
		System.out.println("deepProtoType.name = " + deepProtoType.name + "; deepProtoType.deepCloneableTarget��hashCode = " + deepProtoType.deepCloneableTarget.hashCode());
		System.out.println("deepProtoTypeClone2.name = " + deepProtoTypeClone2.name + "; deepProtoTypeClone2.deepCloneableTarget��hashCode = " + deepProtoTypeClone2.deepCloneableTarget.hashCode());
		
		
		
		/*
		 * ��ʱ����ͨ��deepProtoTypeʵ����¡��ʵ��deepProtoTypeClone1ʵ�������ߵ���������deepCloneableTarget��hashCodeֵ��һ����
		 * ���Կ��Կ϶���deepProtoType�ڵ���������Ҳ����¡��(deepProtoTypeʵ�������¡);
		 */
	}
}
