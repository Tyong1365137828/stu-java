package edu.hebeu.aggregate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import edu.hebeu.element.Department;
import edu.hebeu.iterator.MaterialCollegeIterator;

/**
 * 材料学院(MaterialCollege)类
 * @author 13651
 *
 */
public class MaterialCollege implements College {
	
	private List<Department> departments;
	
	public MaterialCollege() {
		departments = new ArrayList<>();
		addDepartment("冶金工程", "金属冶炼");
		addDepartment("化工工程", "化工");
		addDepartment("应化", "应用化学");
		addDepartment("复材工程", "复合材料");
	}

	@Override
	public String getName() {
		return "材料学院";
	}

	@Override
	public String getDesc() {
		// TODO Auto-generated method stub
		return "材料类的学院";
	}

	@Override
	public void addDepartment(String name, String desc) {
		departments.add(new Department(name, desc));
	}

	@Override
	public Iterator<Object> createIterator() {
		return new MaterialCollegeIterator(departments);
	}

}
