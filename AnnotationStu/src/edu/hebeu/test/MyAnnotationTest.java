package edu.hebeu.test;

import java.util.Date;

import edu.hebeu.annotation.MyAnnotation;

public class MyAnnotationTest {
	
	@MyAnnotation
	private String num;
	
	@MyAnnotation
	public int age;
	
	@MyAnnotation
	protected Date birthday;
	
	@MyAnnotation
	double sorce;
	
	@MyAnnotation
	public boolean login(@MyAnnotation String username, @MyAnnotation String password) {
		if("1365137828".equals(username) && "07273160523".equals(password)) return true;
		return false;
	}
	
	@MyAnnotation
	public static void exit() {
		
		@MyAnnotation
		int i = 4;
		
		System.out.println("ÍË³ö³É¹¦£¡");
	}
	
}

@MyAnnotation
interface MyInterface {
	
}

@MyAnnotation
enum MyEnum {
	Spring, Summer
}

@MyAnnotation
@interface MyAnnotation10 {
	
}
