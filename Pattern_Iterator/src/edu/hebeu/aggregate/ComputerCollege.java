package edu.hebeu.aggregate;

import java.util.Iterator;

import edu.hebeu.element.Department;
import edu.hebeu.iterator.ComputerCollegeIterator;

/**
 * 计算机学院(ComputerCollege)类
 * @author 13651
 *
 */
public class ComputerCollege implements College {

	private Department[] departments; // 保存该类的系别对象
	private int num = 0;
	
	public ComputerCollege() {
		departments = new Department[10]; // 最大保存10个元素
		addDepartment("软件工程", "软件的开发");
		addDepartment("计算机科学技术", "偏向硬件方面的计算机学科");
		addDepartment("物联网", "万物互联");
		addDepartment("电气工程及其自动化", "电气、自动化、...");
	}

	@Override
	public String getName() {
		return "计算机学院";
	}

	@Override
	public String getDesc() {
		return "计算机相关的领域";
	}

	@Override
	public void addDepartment(String name, String desc) {
		departments[num] = new Department(name, desc);
		num += 1;
	}

	/**
	 * 创建该类的Iterator对象实例
	 */
	@Override
	public Iterator<Object> createIterator() {
		return new ComputerCollegeIterator(departments);
	}

}
