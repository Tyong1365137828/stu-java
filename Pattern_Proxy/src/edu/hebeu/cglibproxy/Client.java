package edu.hebeu.cglibproxy;

public class Client {
	public static void main(String[] args) {
		ProxyFactory proxy = new ProxyFactory(new StudentDao());
		StudentDao studentDao = (StudentDao) proxy.getProxyInstance();
		String s = studentDao.study();
		System.out.println("s = " + s);
	}
}
