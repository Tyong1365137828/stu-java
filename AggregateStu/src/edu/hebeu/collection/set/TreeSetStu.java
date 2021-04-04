package edu.hebeu.collection.set;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * ��ʾTreeSet���ϵ��ص�
 * 
 * TreeSet���ϵ��ص㣺
 * 	1�����򲻿��ظ������Ǵ洢�������ڵ�Ԫ�ؿ��԰��մ�С˳�����У��ֱ���Ϊ�����򼯺ϣ�
 * 		�������������ָ���Ǵ��ȥ��ȡ������Ų�ͬ������û���±�
 * 
 * 	2��TreeSet���ϵײ���һ��TreeMap��
 * 
 * 	3���ŵ�TreeSet���ϵ�Ԫ�ص�ͬ�ڷŵ�TreeMap���ϵ�key���֣�
 * 
 * 	4�����Զ������޷�ʹ��TreeSet���ϣ���Ϊû��ָ���Զ������֮��ıȽϹ���(˭��˭Сû��˵��)�����Ԫ�������ϻ��������ת���쳣��
 * 		Exception in thread "main" java.lang.ClassCastException: edu.hebeu.collection.set.User cannot be cast to java.lang.Comparable
 * 		���������쳣��ԭ�����Զ�����������Ϊû��ʵ��java.lang.Comparable�ӿڵ���TreeSet�ײ㽫�Զ�������ת����java.lang.Comparable����ʧ��;
 * 	
 * 	5��TreeSet/TreeMap���ϵĹ��췽�����Բ������κβ���(��ʱû�бȽ������Ὣ�Ƚ�����Ϊnull�����Ԫ��ʱ�ײ��ʹ����ӵ�Ԫ�ص�compareTo()����ʵ�ֱ��������ӣ�
 * ��ʱ��Ҫ���Ԫ�ر���ʵ��Comparable�ӿڣ���дcompareTo()������)��
 * 		TreeSet/TreeMap���ϵĹ��췽��Ҳ���Դ���һ���Ƚ���Ϊ����(��ʱ�бȽ������󣬵ײ��ʹ������Ƚ��������ڵ�compare()�����ڵıȽϹ���ʵ���������Ԫ��)��
 * ע��Ƚ�����һ���࣬���ұȽ���Ҫʵ��Comparator�ӿڣ�����дcompare()����
 * 	6��ͨ��5���ܽᣬ�ó����ۣ�
 * 		����TreeSet/TreeMap����key���ֵ�Ԫ����Ҫ����������洢�������ַ�ʽ��
 * 			1�����ڼ��ϵ�Ԫ��ʵ��java.lang.Conmparable�ӿڣ���д�ڲ���compareTo()�������ڸ÷����ڲ���д�������
 * 			2��ͨ�����췽�����������ּ��϶���ʱ��ͨ�����췽������һ���Ƚ�����������϶��󣬹�������һ���࣬��̳�Comparator�ӿڣ���дcompare()�������÷��������������
 * Comparable��ʽ��Comparator��ʽ���ѡ��
 * 	���ȽϹ��򲻻ᷢ���ı���߱ȽϹ���ֻ��һ��������ʹ��ʵ��Comparable�ӿ�(��д�洢��TreeSet/TreeMap���ϵ�Ԫ�ص�compareTo()����)��
 * 	���ȽϹ����ж����������Ҫ����ȽϹ���֮��Ƶ���л�������ʹ��ʵ��Comparator�ӿڵķ�ʽ(�Ƚ���)��
 * 
 * 	���ۣ�����TreeSet/TreeMap�����ڵ�Ԫ��Ҫʵ��java.lang.Comparable�ӿڣ�����Ҫʵ��CompareTo()������equals()�������Բ�д(��ΪTreeSet/TreeMap���ϵײ�û�е����������)
 * 
 * @author 13651
 *
 */
public class TreeSetStu {
	public static void main(String[] args) {
		
		/**String����Ԫ�صĲ���*/
		TreeSet<String> treeSet = new TreeSet<>(); // ����TreeSet���϶���
		// ���Ԫ��������
		treeSet.add("B");
		treeSet.add("D");
		treeSet.add("H");
		treeSet.add("A");
		treeSet.add("K");
		treeSet.add("O");
		treeSet.add("G");
		treeSet.add("L");
		treeSet.add("M");
		treeSet.add("����TreeSet���ϵ��Զ�����");
		treeSet.add("lisi");
		treeSet.add("zhangsan");
		treeSet.add("zhaoliu");
		treeSet.add("wangwu");
		
		System.out.println("String���͵�TreeSte���ϵ�����(����)��");
		for(String s: treeSet) {
			System.out.println(s);
		}
		System.out.println();System.out.println();
		/**
		 * �������Ϸ���Ԫ���Լ����մ�С�����˳��(�����ֵ���������)���к���
		 */
		
		
		
		/**Integer����Ԫ�صĲ���*/
		TreeSet<Integer> treeSet2 = new TreeSet<>(); // ����TreeSet���϶���
		// ���Ԫ��������
		treeSet2.add(10);
		treeSet2.add(85);
		treeSet2.add(99);
		treeSet2.add(87);
		treeSet2.add(100);
		treeSet2.add(7);
		treeSet2.add(789);
		treeSet2.add(56);
		treeSet2.add(60);
		treeSet2.add(99);
		treeSet2.add(87);
		treeSet2.add(49);
		treeSet2.add(78);
		treeSet2.add(98);
		System.out.println("Integer���͵�TreeSet���ϵ�����(����)��");
		for(Integer i: treeSet2) {
			System.out.println(i);
		}
		System.out.println();System.out.println();
		
		
		
		/**�����Զ�����ʵ��Comparable�ӿڣ���дcompareTo()�ܷ�ʹ��TreeSet/TreeMap��������*/
		TreeSet<User> treeSet3 = new TreeSet<>();
		User u1 = new User("zhangsan", 20);
		User u2 = new User("zhangsi", 50);
		User u3 = new User("wangwu", 46);
		User u4 = new User("test", 18);
		User u5 = new User("zhangwu", 46);
		User u6 = new User("����", 20);
		User u7 = new User("zhaoliu", 43);
		User u8 = new User("wangwu", 32);
		User u9 = new User("wangwu", 33);
		User u10 = new User("abc", 18);
		User u11 = new User("wangliu", 32);
		User u12 = new User("tdg", 32);
		// ����Զ�������TreeSet����
		treeSet3.add(u1);
		treeSet3.add(u2);
		treeSet3.add(u3);
		treeSet3.add(u4);
		treeSet3.add(u5);
		treeSet3.add(u6);
		treeSet3.add(u7);
		treeSet3.add(u8);
		treeSet3.add(u9);
		treeSet3.add(u10);
		treeSet3.add(u11);
		treeSet3.add(u12);
		System.out.println("�Զ����෺�͵�TreeSet���ϵ�����");
		for(User user: treeSet3) {
			System.out.println(user);
		}
		System.out.println();System.out.println();
		
		
		
		/**����TreeSet/TreeMap����ʹ�ñȽ�����������Զ�����Ϊ���ϵ�Ԫ��*/
//		TreeSet<Student> treeSet4 = new TreeSet<>(new studentComparator()); // ʹ���Զ���ıȽ�������TreeSet/TreeMap���϶�����������Զ�����ΪԪ��
		TreeSet<Student> treeSet4 = new TreeSet<>(new Comparator<Student>() { // ����ʹ�������ڲ���ķ�ʽֱ��new Comparator�ӿ� + {}���ں��ӿڵ�ʵ�ַ����������Ƚ���

			@Override
			public int compare(Student s1, Student s2) {
				// �Ȱ��������������������ͬ�ٰ�����������
				if(s1.age == s2.age) { // ����������
					return s1.name.compareTo(s2.name); // ������������(��Ϊname��String����,String�����Ѿ��̳���Comparable�ӿ�,String�ڲ��Ѿ�ʵ����String�ıȽϷ���compareTo()����))
				} else return s1.age - s2.age; // ������䲻���,�ͷ��ز�ֵ(������������)
			}
			
		});
		Student s1 = new Student("zhangsan", 16);
		Student s2 = new Student("zhangsi", 17);
		Student s3 = new Student("����", 21);
		Student s4 = new Student("test", 18);
		Student s5 = new Student("zhangwu", 22);
		Student s6 = new Student("����", 20);
		Student s7 = new Student("����", 17);
		Student	s8 = new Student("wangwu", 19);
		Student s9 = new Student("wangwu", 19);
		Student s10 = new Student("abc", 18);
		Student s11 = new Student("wangliu", 20);
		Student s12 = new Student("tdg", 17);
		// ����Զ�������TreeSet����
		treeSet4.add(s1);
		treeSet4.add(s2);
		treeSet4.add(s3);
		treeSet4.add(s4);
		treeSet4.add(s5);
		treeSet4.add(s6);
		treeSet4.add(s7);
		treeSet4.add(s8);
		treeSet4.add(s9);
		treeSet4.add(s10);
		treeSet4.add(s11);
		treeSet4.add(s12);
		System.out.println("�Զ����෺�͵�TreeSet���ϵ�����");
		for(Student student: treeSet4) {
			System.out.println(student);
		}
		System.out.println();System.out.println();
		
	}
}

/**
 * �Զ����࣬��������TreeSet�����ܷ���Զ���������
 * @author 13651
 *
 */
class User implements Comparable<User> {
	private String name;
	private int age;

	public User(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + "]";
	}

	/**	��Ҫ����������б�д�Ƚϵ��߼�/����(����ʲô���бȽ�)��
	 * 
	 * �ȽϹ����ɳ���Ա������
	 * 		�簴���������򡢰������併��
	 * 
	 * ��ΪTreeSet�ײ�����������������Ų���k�뼯���ڵ�ÿ��k���бȽϣ�����ֵ���ܴ���0��С��0������0
	 * ����0,��ʾ��ͬ,value�Ḳ��;(l - r = 0),�������,���и���
	 * ����ֵ����0,��������������;(l - r > 0),�������,����������������
	 * ����ֵС��0,��������������;(l - r < 0),�Ҵ�����,����������������
	 * 
	 * ����������Ȱ��������������������ͬ�ٰ�����������
	 */
	@Override
	public int compareTo(User u) {
		/*	// �˷�ʽ�ǰ�����������
		if(this.age == u.age) return 0; // �����ȷ���0
		if(this.age > u.age) return 1; // �����ǰage���ڲ�����age������1(����0����)
		else return -1; // �����ǰageС�ڲ���age������-1(С��0����)
		*/
//		return this.age - u.age; // ���ϴ�����Լ�д�ɴ�(������������)
//		return u.age - this.age; // �˷�ʽ�ǰ������併��
		
		// �Ȱ��������������������ͬ�ٰ�����������
		if(this.age == u.age) { // ����������
			return this.name.compareTo(u.name); // ������������(��Ϊname��String����,String�����Ѿ��̳���Comparable�ӿ�,String�ڲ��Ѿ�ʵ����String�ıȽϷ���compareTo()����))
		} else return this.age - u.age; // ������䲻���,�ͷ��ز�ֵ(������������)
	}
}


/**
 * ����Զ�����û��ʵ��Comparable�ӿڣ�û����дconmpareTo()����
 * @author 13651
 *
 */
class Student {
	String name;
	int age;
	
	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}
	
}
/**
	�Զ���һ���Ƚ������Ƚ���Ҫʵ��Comparator�ӿڣ�ͬʱ��дcompare()�������˷�����ָ���ȽϹ����������Զ�����ʵ��Comparable�ӿ���дcompareTo()����
*/
class studentComparator implements Comparator<Student> {

	@Override
	public int compare(Student s1, Student s2) {
		// �Ȱ��������������������ͬ�ٰ�����������
		if(s1.age == s2.age) { // ����������
			return s1.name.compareTo(s2.name); // ������������(��Ϊname��String����,String�����Ѿ��̳���Comparable�ӿ�,String�ڲ��Ѿ�ʵ����String�ıȽϷ���compareTo()����))
		} else return s1.age - s2.age; // ������䲻���,�ͷ��ز�ֵ(������������)
	}
	
}
