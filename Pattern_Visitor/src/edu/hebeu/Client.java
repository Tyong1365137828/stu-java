package edu.hebeu;

import edu.hebeu.element.Man;
import edu.hebeu.element.Woman;
import edu.hebeu.struct.ObjectStruct;
import edu.hebeu.visitor.Fail;
import edu.hebeu.visitor.Success;
import edu.hebeu.visitor.Waiver;

public abstract class Client {
	public static void main(String[] args) {
		// ������ϵͳ�����ݽṹ���͵Ķ���ʵ��
		ObjectStruct objectStruct = new ObjectStruct();
		
		// ������ԵĹ���
		objectStruct.addPerson(new Man());
		// ���Ů�ԵĹ���
		objectStruct.addPerson(new Woman());
		
		// ��ȡ���е�SUCCESS���͵�����
		objectStruct.displyAppraise(new Success());
		
		System.out.println("------------------------------");
		
		// ��ȡ���е�FAIL���͵�����
		objectStruct.displyAppraise(new Fail());
		
		System.out.println("------------------------------");
		
		// ��ȡ���е�Waiver���͵�����
		objectStruct.displyAppraise(new Waiver());
		
	}
}
