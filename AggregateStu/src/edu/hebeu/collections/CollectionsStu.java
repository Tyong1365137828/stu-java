package edu.hebeu.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 本例学习集合工具类 Collections的常用方法
 * 	synchronizedList(List l); // 将List类型的集合变成线程安全的
 * 	sort(List l); // 将List类型的集合排序
 * 
 * @author 13651
 *
 */
public class CollectionsStu {
	public static void main(String[] aergs) {
		List<String> l1 = new ArrayList<>(); // ArrayList集合不是线程安全的
		// 添加元素至集合
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
		
		/**将ArrayList集合变成线程安全的*/
		Collections.synchronizedList(l1);
		
		/**将集合排序*/
		Collections.sort(l1);
		// 遍历打印集合
		for(String s : l1) {
			System.out.print(s + ", ");
		}
		System.out.println();System.out.println();System.out.println();
		
		List<User> l2 = new ArrayList<>();
		User u1 = new User(5000);
		User u2 = new User(200);
		User u3 = new User(22);
		User u4 = new User(300);
		// 添加自定义类至数组
		l2.add(u1);
		l2.add(u2);
		l2.add(u3);
		l2.add(u4);
		/**对于实现Comparable接口且重写了CompareTo()方法之后的自定义类，同样可以调用Collections集合工具类的sort()排序方法*/
		Collections.sort(l2);
		// 遍历打印集合
		for(User u : l2) {
			System.out.print(u + ", ");
		}
		System.out.println();System.out.println();System.out.println();
		
		
		/**将Set类型的集合排序：可以先把Set类型的集合通过构造方法变成List类型的*/
		Set<Integer> set = new HashSet<>(); // 创建一个Set集合对象
		set.add(500);
		set.add(1);
		set.add(60);
		set.add(6);
		set.add(800);
		set.add(400);
		// 通过List集合的构造方法将Set集合变成List集合
		List<Integer> l3 = new ArrayList<>(set);
		Collections.sort(l3); // 将Set集合转换成的List集合进行排序
		// 遍历集合
		for(Integer i : l3) {
			System.out.print(i + ", ");
		}
		System.out.println();System.out.println();System.out.println();
		
		/**将没有实现Comparable接口的自定义类和比较器构造使用*/
		List<Student> l5 = new ArrayList<>();
		Student s1 = new Student("test");
		Student s2 = new Student("asds");
		Student s3 = new Student("cvcg");
		Student s4 = new Student("bnmg");
		Student s5 = new Student("dsd");
		Student s6 = new Student("kh");
		// 添加元素至集合
		l5.add(s1);
		l5.add(s2);
		l5.add(s3);
		l5.add(s4);
		l5.add(s5);
		l5.add(s6);
		// 进行排序,通过为实现Comparable接口集合的自定义类 + 比较器实现排序
		Collections.sort(l5, new studentComparator());
		// 遍历集合
		for(Student s : l5) {
			System.out.print(s + ", ");
		}
		System.out.println();System.out.println();System.out.println();
		
		
	}
}

/**
 * 实现Comparable接口且重写了compareTo()的自定义类
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
		return this.age - u.age; // 升序排序
	}	
}

/**
 * 不实现Comparable接口，而是与比较器配合使用的自定义类
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
		return s1.num.compareTo(s2.num); // 升序排序
	}
	
}
