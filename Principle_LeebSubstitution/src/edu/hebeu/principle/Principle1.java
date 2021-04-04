package edu.hebeu.principle;

/**
 * ��������������Demo�����г��ֵ�����
 * @author 13651
 *
 */
public class Principle1 {
	public static void main(String[] args) {
		A a = new A();
		System.out.println("11 - 3 =" + a.fun1(11, 3));
		System.out.println("1 - 8 = " + a.fun1(1, 8));
		
		System.out.println("----------------------------------------");
		
		B b = new B();
		System.out.println("11 + 3 = " + b.fun1(11, 3)); // ����B��û�м̳�A�࣬���Գ���ԱҲ�Ͳ����뵽ȥ��B���fun1�������м�����
		System.out.println("1 + 8 =" + b.fun1(1, 8)); // ����B��û�м̳�A�࣬���Գ���ԱҲ�Ͳ����뵽ȥ��B���fun1�������м�����
		System.out.println("11 + 3 + 9 = " + b.fun1(11, 3));
		// B��A֮��Ĺ�ϵ����ϣ�������Ȼ����ͨ��Bȥ���ʵ���A�еķ��������£�ͨ��B��fun3ȥ����A�е�fun1���м�������
		System.out.println("11 - 3 = " + b.fun3(11, 3));
		
	}
}

class Base { // ����һ���������Ļ���
	// �Ѹ������ķ����ͳ�Աд��Base��
}

class A extends Base {
	public int fun1(int x, int y) {
		return x- y;
	}
}

class B extends Base {
	// ����BҪʹ��A�еķ�����ʹ����Ϲ�ϵ�����Է���B����Ȼ�ܹ�ʹ��A�еķ�������A��B֮�����Ϲ�ϵҲ����ô����
	private A a = new A();
	
	public int fun1(int x, int y) {
		return x + y;
	}
	
	public int fun2(int x, int y) {
		return fun1(x, y) + 9;
	}
	
	// ʹ��A����ط���
	public int fun3(int x, int y) {
		return this.a.fun1(x, y);
	}
}
