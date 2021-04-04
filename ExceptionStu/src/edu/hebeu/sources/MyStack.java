package edu.hebeu.sources;

/**
 * 用数组模拟一个栈，能通过push()方法实现压栈、pop()方法实现弹栈
 * 栈的默认长度为10
 * 
 * 使用自定义异常处理
 * @author 13651
 *
 */
public class MyStack {
	private Object[] stack; // 栈
	private int stackFrame; // 栈帧
	
	
	/**
	 * 构造方法，默认栈长度为10，栈帧为-1
	 */
	public MyStack() {
		this.stack = new Object[10];
		this.stackFrame = -1;
	}

	/**
	 * push方法，进行压栈
	 * @param stackElement
	 * @throws CustomException 
	 */
	public void push(Object stackElement) throws CustomException {
		if(this.stackFrame >= this.stack.length - 1) { // 如果当前栈帧大于当前栈的数组长度减一，即栈满，不可进行压栈操作
//			CustomException ce = new CustomException("压栈失败，栈已满！"); // new异常对象
//			throw ce; // 抛出异常
			
			// 合并
			throw new CustomException("压栈失败，栈已满！"); // 手动抛出异常
		}
		/**程序执行到此，表示可以压栈*/
		this.stackFrame++; // 当前栈帧++
		this.stack[this.stackFrame] = stackElement; // 压栈
		System.out.println("压栈成功，压入" + stackElement + "元素，当前栈帧为" + this.stackFrame);
	}
	
	/**
	 * pop方法，进行弹栈
	 * @return
	 * @throws CustomException 
	 */
	public Object pop() throws CustomException {
		if(this.stackFrame < 0) {
//			CustomException ce = new CustomException("弹栈失败，栈已空！"); // 创建异常对象
//			throw ce; // 抛出异常
			
			// 合并
			throw new CustomException("弹栈失败，栈已空！"); // 手动抛出异常
		}
		/**程序执行到此，表示可以弹栈*/
		System.out.print("弹出栈帧为" + this.stackFrame + "的" + this.stack[this.stackFrame] + "栈元素");
		this.stackFrame--;
		System.out.println("弹出成功，当前栈为" + this.stackFrame);
		return this.stack[this.stackFrame + 1]; // 返回出弹出的栈元素
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
