package edu.hebeu.collection.set;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * 演示TreeSet集合的特点
 * 
 * TreeSet集合的特点：
 * 	1、无序不可重复，但是存储到集合内的元素可以按照大小顺序排列；又被称为可排序集合；
 * 		无序：这里的无序指的是存进去和取出的序号不同，并且没有下标
 * 
 * 	2、TreeSet集合底层是一个TreeMap；
 * 
 * 	3、放到TreeSet集合的元素等同于放到TreeMap集合的key部分；
 * 
 * 	4、对自定义类无法使用TreeSet集合，因为没有指定自定义对象之间的比较规则(谁大谁小没有说明)，添加元素至集合会出现类型转换异常：
 * 		Exception in thread "main" java.lang.ClassCastException: edu.hebeu.collection.set.User cannot be cast to java.lang.Comparable
 * 		出现上述异常的原因是自定义类吗？是因为没有实现java.lang.Comparable接口导致TreeSet底层将自定义类型转换成java.lang.Comparable类型失败;
 * 	
 * 	5、TreeSet/TreeMap集合的构造方法可以不传入任何参数(此时没有比较器，会将比较器置为null，添加元素时底层会使用添加的元素的compareTo()方法实现边排序边添加，
 * 此时就要求该元素必须实现Comparable接口，重写compareTo()方法；)；
 * 		TreeSet/TreeMap集合的构造方法也可以传入一个比较器为参数(此时有比较器对象，底层会使用这个比较器对象内的compare()方法内的比较规则实现排序添加元素)，
 * 注意比较器是一个类，并且比较器要实现Comparator接口，且重写compare()方法
 * 	6、通过5的总结，得出结论：
 * 		放在TreeSet/TreeMap集合key部分的元素想要正常的排序存储，有两种方式：
 * 			1、放在集合的元素实现java.lang.Conmparable接口，重写内部的compareTo()方法，在该方法内部编写排序规则；
 * 			2、通过构造方法创建这两种集合对象时，通过构造方法传入一个比较器对象给集合对象，构造器是一个类，其继承Comparator接口，重写compare()方法，该方法内有排序规则；
 * Comparable方式和Comparator方式如何选择？
 * 	当比较规则不会发生改变或者比较规则只有一个，建议使用实现Comparable接口(编写存储入TreeSet/TreeMap集合的元素的compareTo()方法)；
 * 	当比较规则有多个，并且需要多个比较规则之间频繁切换，建议使用实现Comparator接口的方式(比较器)；
 * 
 * 	结论：放在TreeSet/TreeMap集合内的元素要实现java.lang.Comparable接口，并且要实现CompareTo()方法，equals()方法可以不写(因为TreeSet/TreeMap集合底层没有调用这个方法)
 * 
 * @author 13651
 *
 */
public class TreeSetStu {
	public static void main(String[] args) {
		
		/**String类型元素的测试*/
		TreeSet<String> treeSet = new TreeSet<>(); // 创建TreeSet集合对象
		// 添加元素至集合
		treeSet.add("B");
		treeSet.add("D");
		treeSet.add("H");
		treeSet.add("A");
		treeSet.add("K");
		treeSet.add("O");
		treeSet.add("G");
		treeSet.add("L");
		treeSet.add("M");
		treeSet.add("测试TreeSet集合的自动排序");
		treeSet.add("lisi");
		treeSet.add("zhangsan");
		treeSet.add("zhaoliu");
		treeSet.add("wangwu");
		
		System.out.println("String泛型的TreeSte集合的排序(升序)：");
		for(String s: treeSet) {
			System.out.println(s);
		}
		System.out.println();System.out.println();
		/**
		 * 遍历集合发现元素以及按照从小到大的顺序(按照字典排序：升序)排列好了
		 */
		
		
		
		/**Integer类型元素的测试*/
		TreeSet<Integer> treeSet2 = new TreeSet<>(); // 创建TreeSet集合对象
		// 添加元素至集合
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
		System.out.println("Integer泛型的TreeSet集合的排序(升序)：");
		for(Integer i: treeSet2) {
			System.out.println(i);
		}
		System.out.println();System.out.println();
		
		
		
		/**测试自定义类实现Comparable接口，重写compareTo()能否使用TreeSet/TreeMap集合排序*/
		TreeSet<User> treeSet3 = new TreeSet<>();
		User u1 = new User("zhangsan", 20);
		User u2 = new User("zhangsi", 50);
		User u3 = new User("wangwu", 46);
		User u4 = new User("test", 18);
		User u5 = new User("zhangwu", 46);
		User u6 = new User("测试", 20);
		User u7 = new User("zhaoliu", 43);
		User u8 = new User("wangwu", 32);
		User u9 = new User("wangwu", 33);
		User u10 = new User("abc", 18);
		User u11 = new User("wangliu", 32);
		User u12 = new User("tdg", 32);
		// 添加自定义类至TreeSet集合
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
		System.out.println("自定义类泛型的TreeSet集合的排序：");
		for(User user: treeSet3) {
			System.out.println(user);
		}
		System.out.println();System.out.println();
		
		
		
		/**测试TreeSet/TreeMap集合使用比较器排序添加自定义类为集合的元素*/
//		TreeSet<Student> treeSet4 = new TreeSet<>(new studentComparator()); // 使用自定义的比较器创建TreeSet/TreeMap集合对象排序添加自定义类为元素
		TreeSet<Student> treeSet4 = new TreeSet<>(new Comparator<Student>() { // 或者使用匿名内部类的方式直接new Comparator接口 + {}，内含接口的实现方法，创建比较器

			@Override
			public int compare(Student s1, Student s2) {
				// 先按照年龄升序，如果年龄相同再按照姓名升序
				if(s1.age == s2.age) { // 如果年龄相等
					return s1.name.compareTo(s2.name); // 按照姓名排序(因为name是String类型,String类型已经继承了Comparable接口,String内部已经实现了String的比较方法compareTo()方法))
				} else return s1.age - s2.age; // 如果年龄不相等,就返回差值(按照年龄升序)
			}
			
		});
		Student s1 = new Student("zhangsan", 16);
		Student s2 = new Student("zhangsi", 17);
		Student s3 = new Student("李四", 21);
		Student s4 = new Student("test", 18);
		Student s5 = new Student("zhangwu", 22);
		Student s6 = new Student("测试", 20);
		Student s7 = new Student("测试", 17);
		Student	s8 = new Student("wangwu", 19);
		Student s9 = new Student("wangwu", 19);
		Student s10 = new Student("abc", 18);
		Student s11 = new Student("wangliu", 20);
		Student s12 = new Student("tdg", 17);
		// 添加自定义类至TreeSet集合
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
		System.out.println("自定义类泛型的TreeSet集合的排序：");
		for(Student student: treeSet4) {
			System.out.println(student);
		}
		System.out.println();System.out.println();
		
	}
}

/**
 * 自定义类，用来测试TreeSet集合能否对自定义类排序
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

	/**	需要在这个方法中编写比较的逻辑/规则(按照什么进行比较)，
	 * 
	 * 比较规则由程序员决定：
	 * 		如按照年龄升序、按照年龄降序；
	 * 
	 * 因为TreeSet底层会调用这个方法，拿着参数k与集合内的每个k进行比较，返回值可能大于0、小于0、等于0
	 * 返回0,表示相同,value会覆盖;(l - r = 0),左右相等,进行覆盖
	 * 返回值大于0,会在右子树上找;(l - r > 0),左大于右,所以在右子树上找
	 * 返回值小于0,会在左子树上找;(l - r < 0),右大于左,所以在左子树上找
	 * 
	 * 本排序规则：先按照年龄升序，如果年龄相同再按照姓名升序；
	 */
	@Override
	public int compareTo(User u) {
		/*	// 此方式是按照年龄升序
		if(this.age == u.age) return 0; // 如果相等返回0
		if(this.age > u.age) return 1; // 如果当前age大于参数的age，返回1(大于0的数)
		else return -1; // 如果当前age小于参数age，返回-1(小于0的数)
		*/
//		return this.age - u.age; // 以上代码可以简写成此(按照年龄升序)
//		return u.age - this.age; // 此方式是按照年龄降序
		
		// 先按照年龄升序，如果年龄相同再按照姓名升序
		if(this.age == u.age) { // 如果年龄相等
			return this.name.compareTo(u.name); // 按照姓名排序(因为name是String类型,String类型已经继承了Comparable接口,String内部已经实现了String的比较方法compareTo()方法))
		} else return this.age - u.age; // 如果年龄不相等,就返回差值(按照年龄升序)
	}
}


/**
 * 这个自定义类没有实现Comparable接口，没有重写conmpareTo()方法
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
	自定义一个比较器，比较器要实现Comparator接口，同时重写compare()方法，此方法内指定比较规则，类似于自定义类实现Comparable接口重写compareTo()方法
*/
class studentComparator implements Comparator<Student> {

	@Override
	public int compare(Student s1, Student s2) {
		// 先按照年龄升序，如果年龄相同再按照姓名升序
		if(s1.age == s2.age) { // 如果年龄相等
			return s1.name.compareTo(s2.name); // 按照姓名排序(因为name是String类型,String类型已经继承了Comparable接口,String内部已经实现了String的比较方法compareTo()方法))
		} else return s1.age - s2.age; // 如果年龄不相等,就返回差值(按照年龄升序)
	}
	
}
