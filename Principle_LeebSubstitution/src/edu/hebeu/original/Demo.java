package edu.hebeu.original;

public class Demo {
	
	/**
	 * ������µ����⣬ͨ�õ������ǣ�ԭ�ȵĸ�������඼�̳�һ����ͨ�׵Ļ��࣬ԭ�ȵļ̳й�ϵȥ��������������
	 * �ۺϡ���ϵȹ�ϵ���棻
	 * @param args
	 */
	public static void main(String[] args) {
		A a = new A();
		System.out.println("11 - 3 =" + a.fun1(11, 3));
		System.out.println("1 - 8 = " + a.fun1(1, 8));
		
		System.out.println("----------------------------------------");
		
		B b = new B();
		System.out.println("11 - 3 = " + b.fun1(11, 3)); // �������Ա�ı��������11 - 3 �Ľ�������Ǹ÷����Ѿ�����д�ˣ�
		System.out.println("1 - 8 =" + b.fun1(1, 8)); // �������Ա�ı��������11 - 3 �Ľ�������Ǹ÷����Ѿ�����д�ˣ�
		System.out.println("11 + 3 + 9 = " + b.fun1(11, 3));
		
	}
}

class A {
	public int fun1(int x, int y) {
		return x - y;
	}
}

class B extends A {
	public int fun1(int x, int y) { // ������������ʶ����д��A��fun1()����
		return x + y;
	}
	
	public int fun2(int x, int y) {
		return fun1(x, y) + 9;
	}
}
