package edu.hebeu;

import edu.hebeu.element.Man;
import edu.hebeu.element.Woman;
import edu.hebeu.struct.ObjectStruct;
import edu.hebeu.visitor.Fail;
import edu.hebeu.visitor.Success;
import edu.hebeu.visitor.Waiver;

public abstract class Client {
	public static void main(String[] args) {
		// 创建该系统的数据结构类型的对象实例
		ObjectStruct objectStruct = new ObjectStruct();
		
		// 添加男性的观众
		objectStruct.addPerson(new Man());
		// 添加女性的观众
		objectStruct.addPerson(new Woman());
		
		// 获取所有的SUCCESS类型的评论
		objectStruct.displyAppraise(new Success());
		
		System.out.println("------------------------------");
		
		// 获取所有的FAIL类型的评论
		objectStruct.displyAppraise(new Fail());
		
		System.out.println("------------------------------");
		
		// 获取所有的Waiver类型的评论
		objectStruct.displyAppraise(new Waiver());
		
	}
}
