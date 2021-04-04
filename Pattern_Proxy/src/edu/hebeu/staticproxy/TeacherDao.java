package edu.hebeu.staticproxy;

public class TeacherDao implements ITeacherDao {

	@Override
	public String teacher() {
		System.out.println("授课中...");
		return "数据结构";
	}

}
