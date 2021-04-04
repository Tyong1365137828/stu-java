package edu.hebeu.iterator;

import java.util.Iterator;
import java.util.List;

import edu.hebeu.element.Department;

/**
 * ����ѧԺ��(MaterialCollege)�� Iterator��
 * @author 13651
 *
 */
public class MaterialCollegeIterator implements Iterator<Object>{
	
	/**
	 * ָ��Ҫ������Ԫ����ʲô��ʽ���
	 */
	private List<Department> departments;
	private int index = -1;
	
	public MaterialCollegeIterator(List<Department> departments) {
		this.departments = departments;
	}

	/**
	 * �жϻ���û����һ��Ԫ��
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
	 * ����ָ��λ�õ�Ԫ��
	 */
	@Override
	public Object next() {
		return departments.get(index);
	}
	
	/**
	 * ɾ��Ԫ�أ���ʵ��
	 */
	@Override
	public void remove() {
	}
	
}
