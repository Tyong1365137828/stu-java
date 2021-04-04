package edu.hebeu.principle;

public class Principle {
	public static void main(String[] args) {
		GraphicEditor graphicEditor = new GraphicEditor();
		
		graphicEditor.drawShape(new Rectangle());
		graphicEditor.drawShape(new Circle());
		graphicEditor.drawShape(new Triangle());
	}
}

/**
 * ��Demo����޸����ƣ�������Ϊʹ�÷���һ�α��������ӡ��޸Ĺ��������޸�������еĴ��룬���´�ʱ�����˿�
 * ��ԭ��
 */
class GraphicEditor { // ������൱��ʹ���ߣ�һ��д�ô���󣬺�����ӹ��������޸�������Ĵ���
	public void drawShape(Shape shape) {
		shape.draw();
	}
}

abstract class Shape {
	public abstract void draw();
}

class Rectangle extends Shape {

	@Override
	public void draw() {
		System.out.println("���ƾ���");
	}
}

class Circle extends Shape {

	@Override
	public void draw() {
		System.out.println("����Բ��");
	}
}

// ���һ���µ�ͼ��
class Triangle extends Shape {

	@Override
	public void draw() {
		System.out.println("����������");
	}
}
