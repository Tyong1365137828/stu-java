package edu.hebeu.collection;

import java.util.ArrayList;
import java.util.Collection;

/**
 * remove()方法解析
 * 	通过测试和源码分析：remove()方法底层调用了equals()方法
 * @author 13651
 *
 */
public class CollectionOfRemoveAnalysis {

	public static void main(String[] args) {
		Collection c = new ArrayList();
		
		String s1 = new String("abc");
		c.add(s1);
		System.out.println("集合中的元素个数：" + c.size());
		
		String s2 = new String("abc");
		c.remove(s2);
		System.out.println("集合中的元素个数：" + c.size());
		/**
		 * 同过上述的例子可以发现，remove已经将s2当作s1了，但是这两个本质上就不是一个对象，因此通过源码和分析可知：
		 * 	此处remove()方法删除调用了equals()方法根据内容来判断了删除那个元素
		 */
		
		
		// 验证上面的分析
		c.clear();
		Test t1 = new Test("tyong");
		c.add(t1);
		System.out.println("集合中的元素个数：" + c.size());
		
		Test t2 = new Test("tyong");
		c.remove(t2);
		System.out.println("集合中的元素个数：" + c.size());
		/**
		 * 可以发现：如果Test类重写覆盖equals()方法，调用remove()方法删除时就会将t1和t2看成一样的，因此可以通过u2将
		 * u1删除；但是如果不重写equals()方法，在remove()方法的底层调用Test类的equals()方法既是调用Object类的equals()方法，
		 * Object类的equals()方法默认使用 == 进行比较，比较的是t1和t2两个对象的内存地址，自然u1和u2就不能程序认为是一样的了，
		 * 就无法实现使用u2删除u1；
		 */
		
	}

}

class Test {
	private String username;
	public Test() {}
	public Test(String s) {
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
		Test other = (Test) obj;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}*/	
		
}
