package edu.hebeu.staticproxy;

public class TeacherDao implements ITeacherDao {

	@Override
	public String teacher() {
		System.out.println("�ڿ���...");
		return "���ݽṹ";
	}

}
