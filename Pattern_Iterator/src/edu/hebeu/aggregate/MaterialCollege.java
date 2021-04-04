package edu.hebeu.aggregate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import edu.hebeu.element.Department;
import edu.hebeu.iterator.MaterialCollegeIterator;

/**
 * ����ѧԺ(MaterialCollege)��
 * @author 13651
 *
 */
public class MaterialCollege implements College {
	
	private List<Department> departments;
	
	public MaterialCollege() {
		departments = new ArrayList<>();
		addDepartment("ұ�𹤳�", "����ұ��");
		addDepartment("��������", "����");
		addDepartment("Ӧ��", "Ӧ�û�ѧ");
		addDepartment("���Ĺ���", "���ϲ���");
	}

	@Override
	public String getName() {
		return "����ѧԺ";
	}

	@Override
	public String getDesc() {
		// TODO Auto-generated method stub
		return "�������ѧԺ";
	}

	@Override
	public void addDepartment(String name, String desc) {
		departments.add(new Department(name, desc));
	}

	@Override
	public Iterator<Object> createIterator() {
		return new MaterialCollegeIterator(departments);
	}

}
