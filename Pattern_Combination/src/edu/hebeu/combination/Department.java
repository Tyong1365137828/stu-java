package edu.hebeu.combination;

public class Department extends OrganizationComponent {

	public Department(String name, String desc) {
		super(name, desc); // ���ø���Ĺ�����
	}

	@Override
	protected void print() { // ��дprint��ӡ����
		System.out.println(getName() + "---" + getDesc());
	}

}
