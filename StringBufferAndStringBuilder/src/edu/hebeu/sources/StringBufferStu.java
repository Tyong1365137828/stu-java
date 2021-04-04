package edu.hebeu.sources;

/**
 * 学习StringBuffer类
 * @author 13651
 *
 */
public class StringBufferStu {
	/**
	 * 在进行字符串的拼接时，常常会使用 + 操作，但是，这种方式在追加大量的字符串时会导致方法区内的字符串常量池中创建
	 * 大量的Strng对象，导致空间的浪费。
	 * 如代码：String s = "abc";
	 * 		   s += "vb";
	 * 这两行代码就会在方法区内的字符常量池中创建3个对象，分别是："abc"、"vb"、"abcvb"；
	 * 
	 * 因此，最好使用StringBuffer类的append()方法实现字符串的追加操作。
	 * StringBuffer类：StringBuffer底层实际上是一个byte[]数组，默认为16位，超出会自动扩容，往StringBuffer中放字符串，实际上是放到byte[]数组中了。
	 * 注意：因为底层是数组，在Java中，数组一旦创建，长度是不可变的，因此，扩容实际上是通过创建一个更大的数组，并把原数组一个一个的拷贝到那个更大的数组
	 * 中实现的，因此在创建StringBuffer对象时，最好能保证预估好byte[]数组的使用长度以得到容量，再通过构造方法进行创建，保证程序的执行效率；
	 * 
	 * 	StringBuffer()构造方法：
	 * 		使用方法：StringBuffer stringBuffer = new StringBuffer();
	 * 		作用：构造一个不带字符的字符串缓冲区，初始化容量为16位的byte[]数组，如果超出容量会自动扩充；
	 * 	StringBuffer(int capacity)构造方法：
	 * 		使用方法：StringBuffer stringBuffer = new StringBuffer(100);
	 * 		作用：构造一个不带字符的字符串缓冲区，容量位100的byte[]数组，如果超出，会自动扩充；
	 * 
	 * StringBuffer使用的优化方法：
	 * 		StringBuffer在byte[]数组满时会自动扩容，因为是数组，在Java中数组一旦创建长度就不可再变了，所以扩容的本质是通过创建一个更大的数组，
	 * 	  再把原先的数组元素一个一个的拷贝至那个更大的数组，以此实现扩容；因此在StringBuffer对象时应预估计一下，尽可能给定一个合适初始化容量，
	 * 	  减少扩容(减少byte[]数组的创建拷贝)。
	 */
	
	public static void main(String[] args) {
		StringBuffer stringBuffer = new StringBuffer(); // 创建StringBuffer对象，初始化容量为16(byte[]数组为16位)
//		StringBuffer stringBuffer2 = new StringBuffer(100); // 创建StringBuffer对象，初始化容量为100(byte[]数组为100位)
		
		/**StringBuffer的append()方法时可以传递任何类型的参数进行拼接的，并且在byte[]数组满时会自动进行扩充*/
		stringBuffer.append(false);
		stringBuffer.append("aghgh");
		stringBuffer.append('a');
		stringBuffer.append(20);
		stringBuffer.append(3.1415926);
		stringBuffer.append(1112L);
		
//		System.out.println(stringBuffer.toString());
		System.out.println(stringBuffer); // 引用数据类型，即输出时会默认调用对象的toString()方法
	}
}
