package edu.hebeu.dynamicproxy;

public class Client {
	
	public static void main(String[] args) {
		
		// ����TeacherDao
		ProxyFactory proxy = new ProxyFactory(new TeacherDao());
		ITeacherDao teacherDao = (ITeacherDao) proxy.getProxyInstance(); // �˴�ֻ��ǿ��ת��Ϊ��Ӧ�Ľӿ�
		String s = teacherDao.teach();
		System.out.println("s = " + s);
		
		// ��������
		
	}
}
