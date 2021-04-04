package edu.hebeu.iterator;

import java.util.Iterator;

import edu.hebeu.element.Department;

/**
 * �����ѧԺ(ComputerCollege)�� Iterator��
 * @author 13651
 *
 */
public class ComputerCollegeIterator implements Iterator<Object>{
	
	/**
	 * ָ��Ҫ������Ԫ����ʲô��ʽ���
	 */
	private Department[] departments;
	private int position;
	
	public ComputerCollegeIterator(Department[] departments) {
		this.departments = departments;
	}

	/**
	 * �ж��Ƿ�����һ��Ԫ��
	 */
	@Override
	public boolean hasNext() {
		if(position >= departments.length || departments[position] == null) {
			return false;
		}
		return true;
	}

	/**
	 * ȡ����ǰ�±�λ�õ�Ԫ��
	 */
	@Override
	public Object next() {
		Department department = departments[position];
		position += 1;
		return department;
	}
	
	/**
	 * ɾ��Ԫ�أ���ʵ��
	 */
	@Override
	public void remove() {
	}

}
