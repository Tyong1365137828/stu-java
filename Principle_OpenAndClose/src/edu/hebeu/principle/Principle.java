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
 * 对Demo类的修改完善，该类作为使用方，一次编码后续添加、修改功能无需修改这个类中的代码，如下此时满足了开
 * 闭原则！
 */
class GraphicEditor { // 这个类相当于使用者，一次写好代码后，后续添加功能无需修改这里面的代码
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
		System.out.println("绘制矩形");
	}
}

class Circle extends Shape {

	@Override
	public void draw() {
		System.out.println("绘制圆形");
	}
}

// 添加一个新的图形
class Triangle extends Shape {

	@Override
	public void draw() {
		System.out.println("绘制三角形");
	}
}
