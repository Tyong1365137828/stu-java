package edu.hebeu.dynamicproxy;

public class Client {
	
	public static void main(String[] args) {
		
		// 代理TeacherDao
		ProxyFactory proxy = new ProxyFactory(new TeacherDao());
		ITeacherDao teacherDao = (ITeacherDao) proxy.getProxyInstance(); // 此处只能强制转型为对应的接口
		String s = teacherDao.teach();
		System.out.println("s = " + s);
		
		// 代理其他
		
	}
}
