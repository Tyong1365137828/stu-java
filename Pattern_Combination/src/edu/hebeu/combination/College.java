package edu.hebeu.combination;

import java.util.ArrayList;
import java.util.List;

public class College extends OrganizationComponent {
	
	/**
	 *  创建一个OrganizationComponent泛型的集合，用来通过OrganizationComponent类管
	 *  理Department类
	 */
	private List<OrganizationComponent> departments = new ArrayList<>();

	public College(String name, String desc) {
		super(name, desc); // 调用父类的构造器
	}
	
	@Override
	protected void add(OrganizationComponent department) {  // 重写add方法
		departments.add(department);
	}
	
	@Override
	protected void remove(OrganizationComponent department) { // 重写remove方法
		departments.remove(department);
	}

	@Override
	protected void print() { // 重写print方法
		System.out.println("------------------" + getName() + "------------------");
		System.out.println("				" + getDesc());
		for (OrganizationComponent department : departments) { // 打印管理的类(即子类Department)的信息
			department.print(); // 调用子类的Department 的print()方法
		}
	}

}
