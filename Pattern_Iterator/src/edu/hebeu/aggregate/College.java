package edu.hebeu.aggregate;

import java.util.Iterator;

/**
 * 学院的接口
 * @author 13651
 *
 */
public interface College {
	
	/**
	 * 获取学院的名字
	 * @return
	 */
	String getName();
	
	/**
	 * 获取学院的描述
	 * @return
	 */
	String getDesc();
	
	/**
	 * 给学院添加系别
	 * @param name
	 * @param desc
	 */
	void addDepartment(String name, String desc);
	
	/**
	 * 创建并返回该集合类的Iterator
	 * @return
	 */
	Iterator<Object> createIterator();
}
