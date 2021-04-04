package edu.hebeu.dynamicproxy;

public class TeacherDao implements ITeacherDao {

	@Override
	public String teach() {
		System.out.println("教师开始授课...");
		return "软件工程课程";
	}

}
