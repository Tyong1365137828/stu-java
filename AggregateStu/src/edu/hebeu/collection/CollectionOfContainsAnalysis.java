package edu.hebeu.collection;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 此例用来深入了解boolean contains()方法
 * boolean contains(Object o) // 判断集合中是否存在此元素，存在 ? true : false
 * 	
 * 通过下面的例子结合源代码得出结论：contains()方法用来比较的是元素的内容而非内存地址！！！
 * 	contains()方法内部调用了equals()方法，实现比较内容，而不是 == 比较内存地址
 * @author 13651
 *
 */
public class CollectionOfContainsAnalysis {

	public static void main(String[] args) {
		Collection c = new ArrayList();
		
		String s1 = new String("abc");
		c.add(s1);
		
		String s2 = new String("def");
		c.add(s2);
		
		String s3 = new String("abc");
		
		System.out.println("集合中是否存在 abc ? " + c.contains(s3)); // true
		c.clear();
		
		
		
		User u1 = new User("tyong");
		User u2 = new User("tyong");
		
		c.add(u1);
		System.out.println("集合中是否存在 u2 ? " + c.contains(u2)); 
		/**注意，当User类没有重新equals()方法时，此结果为false，因为contains()方法会调用User类的equals()方法，
		但是User类并未重新equals()方法，此时将会调用Object类的equals()方法，Object类中的equals()方法是用 == 进行
		比较的(比较的是内存地址)，u1和u2都是new出来的对象，此时相当于比较两个对象的内存地址，拿结果必然就是false；
		*/
		
		
		
	}

}

class User {
	private String username;
	public User() {	
	}
	public User(String s) {
		this.username = s;
	}
	
	
	/*@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}*/
	
	
}
