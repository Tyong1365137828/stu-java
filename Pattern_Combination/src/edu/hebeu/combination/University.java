package edu.hebeu.combination;

import java.util.ArrayList;
import java.util.List;

// 这个类相当于Composite，用来通过OrganizationComponent类管理College类
public class University extends OrganizationComponent {
	
	/**
	 *  创建一个OrganizationComponent泛型的集合，用来通过OrganizationComponent类管理College类
	 */
	private List<OrganizationComponent> colleges = new ArrayList<>();
	
	public University(String name, String desc) {
		super(name, desc); // 调用父类的构造器
	}
	
	@Override
	protected void add(OrganizationComponent college) { // 重写add方法
		colleges.add(college);
	}
	
	@Override
	protected void remove(OrganizationComponent college) { // 重写remove方法
		colleges.remove(college);
	}

	@Override
	protected void print() { // 实现print打印方法
		System.out.println("************************" + getName() + "****************************"); // 输出大学(University类的name属性)的名字
		System.out.println("											" + getDesc());
		for (OrganizationComponent college : colleges) { // 打印管理的类(即子类College)的信息
			college.print(); // 调用子类的College 的print()方法
		}
	}
	
}
