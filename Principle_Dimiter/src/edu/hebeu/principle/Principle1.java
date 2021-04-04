package edu.hebeu.principle;

import java.util.ArrayList;
import java.util.List;

public class Principle1 {
	public static void main(String[] args) {
		System.out.println("�����ط���Ľ�---");
		SchoolEmployee schoolEmployee = new SchoolEmployee();
		schoolEmployee.printEAll(new CollegeManager());
	}
}

/**
 * ��Demo��ĸĽ�
 *
 */
class SchoolEmployee { // ѧУ������
	
	public List<Employee> getAll() { // ����ѧУ������Ա��
		List<Employee> employees = new ArrayList<Employee>();
		for(int i = 0; i < 10; i++) {
			Employee e = new Employee();
			e.setId("eidcode" + i);
			employees.add(e);
		}
		return employees;
	}
	
	public void printEAll(CollegeManager collegeManager) {
		System.out.println("------------�ֹ�˾Ա��--------------");
		collegeManager.printAll();
		System.out.println("------------ѧУ�ܲ�Ա��--------------");
		List<Employee> employees = this.getAll();
		for(int i = 0; i < 10; i++) {
			System.out.println(employees.get(i).getId());
		}
	}
	
}

class CollegeManager { // ѧԺԱ���Ĺ�����
	
	public List<CollegeEmployee> getAll() { // ����ѧԺ������Ա��
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

class CollegeEmployee { // ѧԺ��Ա����
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}

class Employee { // ѧϰ�ܲ�Ա����
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
