package edu.hebeu.combination;

public class Client {
	public static void main(String[] args) {
		
		// 通过OrganizationComponent定义一个大学
		OrganizationComponent university = new University("河北工程大学", "位于河北邯郸的一所大学");
		
		// 通过OrganizationComponent定义一个院系
		OrganizationComponent softWareCollege = new College("信电学院", "信息科学与电气工程学院");
		OrganizationComponent materialCollege = new College("材料学院", "材料");
		
		// 将院系添加至学院
		university.add(softWareCollege);
		university.add(materialCollege);
		
		// 给院系添加专业
		softWareCollege.add(new Department("软件工程", "软件的开发定义"));
		softWareCollege.add(new Department("计算机科学与技术", "计算机专业"));
		
		materialCollege.add(new Department("冶金工程", "金属的冶炼"));
		materialCollege.add(new Department("过控", "过程控制管理"));
		
//		softWareCollege.print(); // 打印专业的信息
		university.print(); // 打印学校的信息
		
		
		
	}
}
