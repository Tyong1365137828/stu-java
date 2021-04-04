package edu.hebeu.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * ����ѧϰ���Ϲ����� Collections�ĳ��÷���
 * 	synchronizedList(List l); // ��List���͵ļ��ϱ���̰߳�ȫ��
 * 	sort(List l); // ��List���͵ļ�������
 * 
 * @author 13651
 *
 */
public class CollectionsStu {
	public static void main(String[] aergs) {
		List<String> l1 = new ArrayList<>(); // ArrayList���ϲ����̰߳�ȫ��
		// ���Ԫ��������
		l1.add("dfji");
		l1.add("sdfb");
		l1.add("aed");
		l1.add("vjiji");
		l1.add("ansdf");
		l1.add("bxvjjdf");
		l1.add("ffhjhj");
		l1.add("sdsf");
		l1.add("fdjdhj");
		l1.add("dfd");
		l1.add("dfgdffgh");
		l1.add("fdfjjdjhkgfjhgjj");
		l1.add("ajdjghju");
		
		/**��ArrayList���ϱ���̰߳�ȫ��*/
		Collections.synchronizedList(l1);
		
		/**����������*/
		Collections.sort(l1);
		// ������ӡ����
		for(String s : l1) {
			System.out.print(s + ", ");
		}
		System.out.println();System.out.println();System.out.println();
		
		List<User> l2 = new ArrayList<>();
		User u1 = new User(5000);
		User u2 = new User(200);
		User u3 = new User(22);
		User u4 = new User(300);
		// ����Զ�����������
		l2.add(u1);
		l2.add(u2);
		l2.add(u3);
		l2.add(u4);
		/**����ʵ��Comparable�ӿ�����д��CompareTo()����֮����Զ����࣬ͬ�����Ե���Collections���Ϲ������sort()���򷽷�*/
		Collections.sort(l2);
		// ������ӡ����
		for(User u : l2) {
			System.out.print(u + ", ");
		}
		System.out.println();System.out.println();System.out.println();
		
		
		/**��Set���͵ļ������򣺿����Ȱ�Set���͵ļ���ͨ�����췽�����List���͵�*/
		Set<Integer> set = new HashSet<>(); // ����һ��Set���϶���
		set.add(500);
		set.add(1);
		set.add(60);
		set.add(6);
		set.add(800);
		set.add(400);
		// ͨ��List���ϵĹ��췽����Set���ϱ��List����
		List<Integer> l3 = new ArrayList<>(set);
		Collections.sort(l3); // ��Set����ת���ɵ�List���Ͻ�������
		// ��������
		for(Integer i : l3) {
			System.out.print(i + ", ");
		}
		System.out.println();System.out.println();System.out.println();
		
		/**��û��ʵ��Comparable�ӿڵ��Զ�����ͱȽ�������ʹ��*/
		List<Student> l5 = new ArrayList<>();
		Student s1 = new Student("test");
		Student s2 = new Student("asds");
		Student s3 = new Student("cvcg");
		Student s4 = new Student("bnmg");
		Student s5 = new Student("dsd");
		Student s6 = new Student("kh");
		// ���Ԫ��������
		l5.add(s1);
		l5.add(s2);
		l5.add(s3);
		l5.add(s4);
		l5.add(s5);
		l5.add(s6);
		// ��������,ͨ��Ϊʵ��Comparable�ӿڼ��ϵ��Զ����� + �Ƚ���ʵ������
		Collections.sort(l5, new studentComparator());
		// ��������
		for(Student s : l5) {
			System.out.print(s + ", ");
		}
		System.out.println();System.out.println();System.out.println();
		
		
	}
}

/**
 * ʵ��Comparable�ӿ�����д��compareTo()���Զ�����
 * @author 13651
 *
 */
class User implements Comparable<User>{
	int age;

	public User(int age) {
		super();
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "User [age=" + age + "]";
	}

	@Override
	public int compareTo(User u) {
		// TODO Auto-generated method stub
		return this.age - u.age; // ��������
	}	
}

/**
 * ��ʵ��Comparable�ӿڣ�������Ƚ������ʹ�õ��Զ�����
 * @author 13651
 *
 */
class Student {
	String num;

	public Student(String num) {
		super();
		this.num = num;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	@Override
	public String toString() {
		return "Student [num=" + num + "]";
	}
}

class studentComparator implements Comparator<Student> {

	@Override
	public int compare(Student s1, Student s2) {
		return s1.num.compareTo(s2.num); // ��������
	}
	
}
