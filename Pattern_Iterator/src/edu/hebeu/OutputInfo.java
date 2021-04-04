package edu.hebeu;

import java.util.Iterator;
import java.util.List;

import edu.hebeu.aggregate.College;
import edu.hebeu.element.Department;

public class OutputInfo {
	
	/**
	 * ѧԺ�ļ���
	 */
	private List<College> colleges;
	
	public OutputInfo(List<College> colleges) {
		this.colleges = colleges;
	}
	
	/**
	 * ���ȫ����ѧԺ�����µ�ȫ��ϵ��
	 */
	public void print() {
		Iterator<College> collegesIterator = colleges.iterator();
		while(collegesIterator.hasNext()) {
			College college = collegesIterator.next(); // ��ȡ��ѧԺ����
			System.out.println("-------------------ѧԺ��" + college.getName() + "-------------------");
			System.out.println("					������" + college.getDesc());
			
			// ���ø�ѧԺ��printDepartment()����
			printDepartment(college.createIterator());
		}
	}
	
	/**
	 * ���ϵ��
	 * @param iterator
	 */
	private void printDepartment(Iterator<Object> iterator) {
		while(iterator.hasNext()) {
			
			Department department = (Department) iterator.next();
			System.out.println("---------------" + department.getName() + "-----------------" + department.getDesc());
		}
	}
	
}
