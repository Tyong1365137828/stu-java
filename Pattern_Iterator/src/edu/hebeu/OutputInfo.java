package edu.hebeu;

import java.util.Iterator;
import java.util.List;

import edu.hebeu.aggregate.College;
import edu.hebeu.element.Department;

public class OutputInfo {
	
	/**
	 * 学院的集合
	 */
	private List<College> colleges;
	
	public OutputInfo(List<College> colleges) {
		this.colleges = colleges;
	}
	
	/**
	 * 输出全部的学院和其下的全部系别
	 */
	public void print() {
		Iterator<College> collegesIterator = colleges.iterator();
		while(collegesIterator.hasNext()) {
			College college = collegesIterator.next(); // 获取该学院对象
			System.out.println("-------------------学院：" + college.getName() + "-------------------");
			System.out.println("					描述：" + college.getDesc());
			
			// 调用该学院的printDepartment()方法
			printDepartment(college.createIterator());
		}
	}
	
	/**
	 * 输出系别
	 * @param iterator
	 */
	private void printDepartment(Iterator<Object> iterator) {
		while(iterator.hasNext()) {
			
			Department department = (Department) iterator.next();
			System.out.println("---------------" + department.getName() + "-----------------" + department.getDesc());
		}
	}
	
}
