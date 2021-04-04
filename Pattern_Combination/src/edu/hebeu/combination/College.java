package edu.hebeu.combination;

import java.util.ArrayList;
import java.util.List;

public class College extends OrganizationComponent {
	
	/**
	 *  ����һ��OrganizationComponent���͵ļ��ϣ�����ͨ��OrganizationComponent���
	 *  ��Department��
	 */
	private List<OrganizationComponent> departments = new ArrayList<>();

	public College(String name, String desc) {
		super(name, desc); // ���ø���Ĺ�����
	}
	
	@Override
	protected void add(OrganizationComponent department) {  // ��дadd����
		departments.add(department);
	}
	
	@Override
	protected void remove(OrganizationComponent department) { // ��дremove����
		departments.remove(department);
	}

	@Override
	protected void print() { // ��дprint����
		System.out.println("------------------" + getName() + "------------------");
		System.out.println("				" + getDesc());
		for (OrganizationComponent department : departments) { // ��ӡ�������(������Department)����Ϣ
			department.print(); // ���������Department ��print()����
		}
	}

}
