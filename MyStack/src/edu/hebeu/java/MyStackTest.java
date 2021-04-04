package edu.hebeu.java;

public class MyStackTest {
	public static void main(String[] args) {
		MyStack myStack = new MyStack();
		
		myStack.push(new Object());
		myStack.push(new Object());
		myStack.push(new Object());
		myStack.push(new Object());
		myStack.push(new Object());
		myStack.push(new Object());
		myStack.push(new Object());
		myStack.push(new Object());
		myStack.push(new Object());
		myStack.push(new Object());
		myStack.push(new Object());
		
		Object obj = new Object();
		obj = myStack.pop();System.out.println(obj);
		obj = myStack.pop();System.out.println(obj);
		obj = myStack.pop();System.out.println(obj);
		obj = myStack.pop();System.out.println(obj);
		obj = myStack.pop();System.out.println(obj);
		obj = myStack.pop();System.out.println(obj);
		obj = myStack.pop();System.out.println(obj);
		obj = myStack.pop();System.out.println(obj);
		obj = myStack.pop();System.out.println(obj);
		obj = myStack.pop();System.out.println(obj);
	}
}
