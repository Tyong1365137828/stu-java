package edu.hebeu.iterator;

import java.util.Iterator;
import java.util.List;

import edu.hebeu.element.Department;

/**
 * 材料学院类(MaterialCollege)的 Iterator类
 * @author 13651
 *
 */
public class MaterialCollegeIterator implements Iterator<Object>{
	
	/**
	 * 指定要遍历的元素以什么形式存放
	 */
	private List<Department> departments;
	private int index = -1;
	
	public MaterialCollegeIterator(List<Department> departments) {
		this.departments = departments;
	}

	/**
	 * 判断还有没有下一个元素
	 */
	@Override
	public boolean hasNext() {
		if(index >= departments.size() - 1) {
			return false;
		} else {
			index += 1;
			return true;
		}
	}

	/**
	 * 返回指定位置的元素
	 */
	@Override
	public Object next() {
		return departments.get(index);
	}
	
	/**
	 * 删除元素，空实现
	 */
	@Override
	public void remove() {
	}
	
}
