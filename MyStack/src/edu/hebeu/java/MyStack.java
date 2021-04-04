package edu.hebeu.java;

/**
 * ������ģ��һ��ջ����ͨ��push()����ʵ��ѹջ��pop()����ʵ�ֵ�ջ
 * ջ��Ĭ�ϳ���Ϊ10
 * @author 13651
 *
 */
public class MyStack {
	private Object[] stack; // ջ
	private int stackFrame; // ջ֡
	
	
	/**
	 * ���췽����Ĭ��ջ����Ϊ10��ջ֡Ϊ-1
	 */
	public MyStack() {
		this.stack = new Object[10];
		this.stackFrame = -1;
	}

	/**
	 * push����������ѹջ
	 * @param stackElement
	 */
	public void push(Object stackElement) {
		if(this.stackFrame >= this.stack.length - 1) { // �����ǰջ֡���ڵ�ǰջ�����鳤�ȼ�һ����ջ�������ɽ���ѹջ����
			System.out.println("ѹջʧ�ܣ���ǰջ����");
			return;
		}
		/**����ִ�е��ˣ���ʾ����ѹջ*/
		this.stackFrame++; // ��ǰջ֡++
		this.stack[this.stackFrame] = stackElement; // ѹջ
		System.out.println("ѹջ�ɹ���ѹ��" + stackElement + "Ԫ�أ���ǰջ֡Ϊ" + this.stackFrame);
	}
	
	/**
	 * pop���������е�ջ
	 * @return
	 */
	public Object pop() {
		if(this.stackFrame < 0) {
			System.out.println("��ջʧ�ܣ���ǰջ��");
			return null;
		}
		/**����ִ�е��ˣ���ʾ���Ե�ջ*/
		System.out.print("����ջ֡Ϊ" + this.stackFrame + "��" + this.stack[this.stackFrame] + "ջԪ��");
		this.stackFrame--;
		System.out.println("�����ɹ�����ǰջΪ" + this.stackFrame);
		return this.stack[this.stackFrame + 1]; // ���س�������ջԪ��
	}
	
	public Object[] getStack() {
		return stack;
	}
	public void setStack(Object[] stack) {
		this.stack = stack;
	}
	public int getStackFrame() {
		return stackFrame;
	}
	public void setStackFrame(int stackFrame) {
		this.stackFrame = stackFrame;
	}
	
	
}
