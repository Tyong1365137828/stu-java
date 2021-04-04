package edu.hebeu.principle;

import java.util.ArrayList;
import java.util.List;

public class Principle1 {
	public static void main(String[] args) {
		System.out.println("迪米特法则改进---");
		SchoolEmployee schoolEmployee = new SchoolEmployee();
		schoolEmployee.printEAll(new CollegeManager());
	}
}

/**
 * 对Demo类的改进
 *
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
		collegeManager.printAll();
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
	
	public void printAll() {
		List<CollegeEmployee> collegeEmployees = this.getAll();
		for(int i = 0; i < 10; i++) {
			System.out.println(collegeEmployees.get(i).getId());
		}
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
