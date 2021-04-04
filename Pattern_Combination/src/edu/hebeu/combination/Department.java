package edu.hebeu.combination;

public class Department extends OrganizationComponent {

	public Department(String name, String desc) {
		super(name, desc); // 调用父类的构造器
	}

	@Override
	protected void print() { // 重写print打印方法
		System.out.println(getName() + "---" + getDesc());
	}

}
