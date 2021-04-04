package edu.hebeu.test;

import edu.hebeu.sources.CustomException;
import edu.hebeu.sources.MyStack;

public class MyStackTest {
	public static void main(String[] args) {
		MyStack myStack = new MyStack();
		
		try {
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
		} catch (CustomException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		Object obj = new Object();
		try {
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
			obj = myStack.pop();System.out.println(obj);
		} catch (CustomException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
