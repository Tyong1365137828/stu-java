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
 * 这种方式的特点：
 * 	1、比较容易理解，简单易操作；
 * 	2、缺点是违反了设计原则的开闭原则(OCP，即对扩展开放(提供方)，对修改关闭(使用方))，我们如果需要添加新
 * 的功能，如让这个程序可以绘制三角形等图形，就需要大量的修改代码；而OCP原则决定我们在给类增加新功能时，尽
 * 量不修改代码，或尽可能少修改代码；
 * 
 * 解决思路：
 * 	将Shape类修改为抽象类，并提供一个抽象的draw方法，GraphicEditor类的drawShape方法直接调用Shape的draw方
 * 法，让所有的图形类去继承实现这个方法即可，此时我们有新的图形加入时，只需要让这个新图形继承Shape并实现
 * draw方法即可；
 * 
 */
class GraphicEditor { // 这个类是用来绘制图形的类(相当于使用者)
	public void drawShape(Shape shape) { // 通过Shape抽象类的子类的m_type决定怎么画
		if(shape.m_type == 1) {
			drawRectangle();
		} else if(shape.m_type == 2) {
			drawCircle();
		} else if(shape.m_type == 3) { // 添加逻辑，修改代码
			drawTriangle();
		}
	}
	
	private void drawRectangle() {
		System.out.println("绘制了矩形");
	}
	
	private void drawCircle() {
		System.out.println("绘制了圆形");
	}
	
	private void drawTriangle() { // 添加代码
		System.out.println("绘制了三角形");
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

// 增加一个三角形类
class Triangle extends Shape {
	public Triangle() {
		super.m_type = 3;
	}
}

