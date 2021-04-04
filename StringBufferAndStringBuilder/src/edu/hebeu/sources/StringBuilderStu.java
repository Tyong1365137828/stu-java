package edu.hebeu.sources;

/**
 * 学习StringBuilder
 * @author 13651
 *
 */
public class StringBuilderStu {
	
	/**
	 * 与StringBuffer相似，
	 * 区别参考笔记
	 */
	
	public static void main(String[] args) {
		StringBuilder stringBuilder = new StringBuilder(); // 同StringBuffer，初始化容量为16
		
		/**StringBuilder的append()方法时可以传递任何类型的参数进行拼接的，并且在byte[]数组满时会自动进行扩充*/
		stringBuilder.append(false);
		stringBuilder.append("aghgh");
		stringBuilder.append('a');
		stringBuilder.append(20);
		stringBuilder.append(3.1415926);
		stringBuilder.append(1112L);
		
		System.out.println(stringBuilder);
	}
	
}
