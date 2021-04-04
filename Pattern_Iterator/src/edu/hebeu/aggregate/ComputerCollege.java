package edu.hebeu.aggregate;

import java.util.Iterator;

import edu.hebeu.element.Department;
import edu.hebeu.iterator.ComputerCollegeIterator;

/**
 * �����ѧԺ(ComputerCollege)��
 * @author 13651
 *
 */
public class ComputerCollege implements College {

	private Department[] departments; // ��������ϵ�����
	private int num = 0;
	
	public ComputerCollege() {
		departments = new Department[10]; // ��󱣴�10��Ԫ��
		addDepartment("�������", "����Ŀ���");
		addDepartment("�������ѧ����", "ƫ��Ӳ������ļ����ѧ��");
		addDepartment("������", "���ﻥ��");
		addDepartment("�������̼����Զ���", "�������Զ�����...");
	}

	@Override
	public String getName() {
		return "�����ѧԺ";
	}

	@Override
	public String getDesc() {
		return "�������ص�����";
	}

	@Override
	public void addDepartment(String name, String desc) {
		departments[num] = new Department(name, desc);
		num += 1;
	}

	/**
	 * ���������Iterator����ʵ��
	 */
	@Override
	public Iterator<Object> createIterator() {
		return new ComputerCollegeIterator(departments);
	}

}
