package edu.hebeu.test;

import edu.hebeu.annotation.MyAnnotation2;
import edu.hebeu.annotation.MyAnnotation3;

public class MyAnnotation2Test {
	public static void main(String[] args) {
		
		
		
	}
}

class UseMyAnnotation2 {
	
	/**
	 * ע�����ʹ��ע��ʱ��
	 * ���ע���������Ҹ�����û��Ĭ��ֵ���ͱ���Ҫ�����Ը�ֵ��
	 * ���Ը�ֵ����ʽΪ�� ������ = ֵ(ע��ֵҪ������ָ����������ͬ);
	 * 
	 * ������Ϊ��������ʱ��
	 * 		���������Ը�ֵʱ����ʽΪ�������� = {ֵ1, ֵ2, ֵ3, ...};
	 * 		�������Ը�ֵֻ��1��ֵ��ʱ�򣬴����ſ���ʡ�ԣ��磺������ = ֵ1
	 * ������ʾ��
	 */
	@MyAnnotation2(name = "tyong", sex = '��')
	public void doSome() {
		System.out.println("doSome...");
	}
	
	/**
	 * ע�⣺���ע���е�������Ϊvalueʱ��ע��ֻ����һ������ʱ�����������Բ�д��ֱ�Ӹ�ֵ���� "123"���� ֵ��
	 * ������ʾ��
	 */
	@MyAnnotation3("value��ֵ")
	public void doOther() {
		System.out.println("doOther...");
	}
	
}
