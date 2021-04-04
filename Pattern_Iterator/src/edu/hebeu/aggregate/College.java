package edu.hebeu.aggregate;

import java.util.Iterator;

/**
 * ѧԺ�Ľӿ�
 * @author 13651
 *
 */
public interface College {
	
	/**
	 * ��ȡѧԺ������
	 * @return
	 */
	String getName();
	
	/**
	 * ��ȡѧԺ������
	 * @return
	 */
	String getDesc();
	
	/**
	 * ��ѧԺ���ϵ��
	 * @param name
	 * @param desc
	 */
	void addDepartment(String name, String desc);
	
	/**
	 * ���������ظü������Iterator
	 * @return
	 */
	Iterator<Object> createIterator();
}
