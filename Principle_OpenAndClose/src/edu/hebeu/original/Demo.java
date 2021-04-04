package edu.hebeu.original;

public class Demo {
	public static void main(String[] args) {
		GraphicEditor dEditor = new GraphicEditor();
		
		dEditor.drawShape(new Rectangle());
		dEditor.drawShape(new Circle());
		dEditor.drawShape(new Triangle());
	}
}

/**
 * ���ַ�ʽ���ص㣺
 * 	1���Ƚ�������⣬���ײ�����
 * 	2��ȱ����Υ�������ԭ��Ŀ���ԭ��(OCP��������չ����(�ṩ��)�����޸Ĺر�(ʹ�÷�))�����������Ҫ�����
 * �Ĺ��ܣ��������������Ի��������ε�ͼ�Σ�����Ҫ�������޸Ĵ��룻��OCPԭ����������ڸ��������¹���ʱ����
 * �����޸Ĵ��룬�򾡿������޸Ĵ��룻
 * 
 * ���˼·��
 * 	��Shape���޸�Ϊ�����࣬���ṩһ�������draw������GraphicEditor���drawShape����ֱ�ӵ���Shape��draw��
 * ���������е�ͼ����ȥ�̳�ʵ������������ɣ���ʱ�������µ�ͼ�μ���ʱ��ֻ��Ҫ�������ͼ�μ̳�Shape��ʵ��
 * draw�������ɣ�
 * 
 */
class GraphicEditor { // ���������������ͼ�ε���(�൱��ʹ����)
	public void drawShape(Shape shape) { // ͨ��Shape������������m_type������ô��
		if(shape.m_type == 1) {
			drawRectangle();
		} else if(shape.m_type == 2) {
			drawCircle();
		} else if(shape.m_type == 3) { // ����߼����޸Ĵ���
			drawTriangle();
		}
	}
	
	private void drawRectangle() {
		System.out.println("�����˾���");
	}
	
	private void drawCircle() {
		System.out.println("������Բ��");
	}
	
	private void drawTriangle() { // ��Ӵ���
		System.out.println("������������");
	}
}

class Shape {
	int m_type = 0;
}

class Rectangle extends Shape {
	public Rectangle() {
		super.m_type = 1;
	}
}

class Circle extends Shape {
	public Circle() {
		super.m_type = 2;
	}
}

// ����һ����������
class Triangle extends Shape {
	public Triangle() {
		super.m_type = 3;
	}
}

