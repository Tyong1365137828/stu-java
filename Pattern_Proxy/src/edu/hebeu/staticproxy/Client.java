package edu.hebeu.staticproxy;

public class Client {
	
	public static void main(String[] args) {
		TeacherProxy proxy = new TeacherProxy(new TeacherDao());
		String s = proxy.teacher();
		System.out.println("s = " + s);
	}
}
