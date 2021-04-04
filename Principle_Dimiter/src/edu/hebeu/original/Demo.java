package edu.hebeu.original;

import java.util.ArrayList;
import java.util.List;

public class Demo {
	public static void main(String[] args) {
		SchoolEmployee schoolEmployee = new SchoolEmployee();
		schoolEmployee.printEAll(new CollegeManager());
	}
}

/*
 * 分析：SchoolEmployee这个类的直接朋友类：Employee、CollegeManager，因为这些类都是在方法的参数、返回
 * 值上(出现在成员变量、方法参数、方法返回值中的类称为直接的朋友)；陌生类：CollegeEmployee，因为这个类出现在
 * printEAll方法中，是局部变量(出现在局部变量中的类不是直接朋友(陌生的类))，此时违反了迪米特法则；
 * 
 * 解决方案：将printEAll方法内关于陌生类CollegeEmployee的代码片段抽取到CollegeEmployee类中或CollegeEmployee类
 * 的直接朋友类中
*/
class SchoolEmployee { // 学校管理类
	
	public List<Employee> getAll() { // 返回学校的所有员工
		List<Employee> employees = new ArrayList<Employee>();
		for(int i = 0; i < 10; i++) {
			Employee e = new Employee();
			e.setId("eidcode" + i);
			employees.add(e);
		}
		return employees;
	}
	
	public void printEAll(CollegeManager collegeManager) {
		System.out.println("------------分公司员工--------------");
		List<CollegeEmployee> collegeEmployees = collegeManager.getAll();
		for(int i = 0; i < 10; i++) {
			System.out.println(collegeEmployees.get(i).getId());
		}
		System.out.println("------------学校总部员工--------------");
		List<Employee> employees = this.getAll();
		for(int i = 0; i < 10; i++) {
			System.out.println(employees.get(i).getId());
		}
	}
	
}

class CollegeManager { // 学院员工的管理类
	
	public List<CollegeEmployee> getAll() { // 返回学院的所有员工
		List<CollegeEmployee> collegeEmployees = new ArrayList<>();
		for(int i = 0; i < 10; i++) {
			CollegeEmployee ce = new CollegeEmployee();
			ce.setId("ceidcode" + i);
			collegeEmployees.add(ce);
		}
		return collegeEmployees;
	}
}

class CollegeEmployee { // 学院的员工类
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}

class Employee { // 学习总部员工类
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
