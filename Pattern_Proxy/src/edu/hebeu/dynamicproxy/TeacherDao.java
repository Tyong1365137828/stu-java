package edu.hebeu.dynamicproxy;

public class TeacherDao implements ITeacherDao {

	@Override
	public String teach() {
		System.out.println("��ʦ��ʼ�ڿ�...");
		return "������̿γ�";
	}

}
