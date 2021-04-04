package edu.hebeu.principle;

public class Demo1 {
	public static void main(String[] args) {
		A a = new A();
		// ���µ�ÿ�д��붼�� ��A ͨ���ӿڵ�1��2��3����ȥ����(ʹ��)��B
		a.depend1(new B());
		a.depend2(new B());
		a.depend3(new B());
		
		C c = new C();
		// ���µ�ÿ�д��붼�� ��C ͨ���ӿڵ�1��4��5����ȥ����(ʹ��)��D
		c.depend1(new D());
		c.depend4(new D());
		c.depend5(new D());
	}
}

interface Interface1 {
	void operation1();
}

interface Interface2 {
	void operation2();
	void operation3();
}

interface Interface3 {
	void operation4();
	void operation5();
}

class B implements Interface1, Interface2 {

	@Override
	public void operation2() {
		System.out.println("��B ʵ����operation2()����");
	}

	@Override
	public void operation3() {
		System.out.println("��B ʵ����operation3()����");
	}

	@Override
	public void operation1() {
		System.out.println("��B ʵ����operation1()����");
	}
}

class D implements Interface1, Interface3 {

	@Override
	public void operation4() {
		System.out.println("��D ʵ����operation4()����");
	}

	@Override
	public void operation5() {
		System.out.println("��D ʵ����operation5()����");
	}

	@Override
	public void operation1() {
		System.out.println("��D ʵ����operation1()����");
	}
}

//��Aʹ�� �ӿ�Interface1��1���� �� �ӿ�Interface2��2��3���� ������B
class A {
	public void depend1(Interface1 interface1) {
		interface1.operation1();
	}
	
	public void depend2(Interface2 interface2) {
		interface2.operation2();
	}
	
	public void depend3(Interface2 interface2) {
		interface2.operation3();
	}
}

//��Cʹ�ýӿ�Interface1��1���� �� �ӿ�Interface3��4��5���� ������D
class C {
	public void depend1(Interface1 interface1) {
		interface1.operation1();
	}
	
	public void depend4(Interface3 interface3) {
		interface3.operation4();
	}
	
	public void depend5(Interface3 interface3) {
		interface3.operation5();
	}
}

