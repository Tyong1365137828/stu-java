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
 * ������SchoolEmployee������ֱ�������ࣺEmployee��CollegeManager����Ϊ��Щ�඼���ڷ����Ĳ���������
 * ֵ��(�����ڳ�Ա������������������������ֵ�е����Ϊֱ�ӵ�����)��İ���ࣺCollegeEmployee����Ϊ����������
 * printEAll�����У��Ǿֲ�����(�����ھֲ������е��಻��ֱ������(İ������))����ʱΥ���˵����ط���
 * 
 * �����������printEAll�����ڹ���İ����CollegeEmployee�Ĵ���Ƭ�γ�ȡ��CollegeEmployee���л�CollegeEmployee��
 * ��ֱ����������
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
		List<CollegeEmployee> collegeEmployees = collegeManager.getAll();
		for(int i = 0; i < 10; i++) {
			System.out.println(collegeEmployees.get(i).getId());
		}
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
