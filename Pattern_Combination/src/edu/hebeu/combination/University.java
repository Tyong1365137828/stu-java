package edu.hebeu.combination;

import java.util.ArrayList;
import java.util.List;

// ������൱��Composite������ͨ��OrganizationComponent�����College��
public class University extends OrganizationComponent {
	
	/**
	 *  ����һ��OrganizationComponent���͵ļ��ϣ�����ͨ��OrganizationComponent�����College��
	 */
	private List<OrganizationComponent> colleges = new ArrayList<>();
	
	public University(String name, String desc) {
		super(name, desc); // ���ø���Ĺ�����
	}
	
	@Override
	protected void add(OrganizationComponent college) { // ��дadd����
		colleges.add(college);
	}
	
	@Override
	protected void remove(OrganizationComponent college) { // ��дremove����
		colleges.remove(college);
	}

	@Override
	protected void print() { // ʵ��print��ӡ����
		System.out.println("************************" + getName() + "****************************"); // �����ѧ(University���name����)������
		System.out.println("											" + getDesc());
		for (OrganizationComponent college : colleges) { // ��ӡ�������(������College)����Ϣ
			college.print(); // ���������College ��print()����
		}
	}
	
}
