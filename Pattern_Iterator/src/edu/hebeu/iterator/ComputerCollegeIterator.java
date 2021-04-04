package edu.hebeu.iterator;

import java.util.Iterator;

import edu.hebeu.element.Department;

/**
 * 计算机学院(ComputerCollege)的 Iterator类
 * @author 13651
 *
 */
public class ComputerCollegeIterator implements Iterator<Object>{
	
	/**
	 * 指定要遍历的元素以什么形式存放
	 */
	private Department[] departments;
	private int position;
	
	public ComputerCollegeIterator(Department[] departments) {
		this.departments = departments;
	}

	/**
	 * 判断是否还有下一个元素
	 */
	@Override
	public boolean hasNext() {
		if(position >= departments.length || departments[position] == null) {
			return false;
		}
		return true;
	}

	/**
	 * 取出当前下标位置的元素
	 */
	@Override
	public Object next() {
		Department department = departments[position];
		position += 1;
		return department;
	}
	
	/**
	 * 删除元素，空实现
	 */
	@Override
	public void remove() {
	}

}
