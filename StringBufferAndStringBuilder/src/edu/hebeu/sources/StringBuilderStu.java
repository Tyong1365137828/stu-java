package edu.hebeu.sources;

/**
 * ѧϰStringBuilder
 * @author 13651
 *
 */
public class StringBuilderStu {
	
	/**
	 * ��StringBuffer���ƣ�
	 * ����ο��ʼ�
	 */
	
	public static void main(String[] args) {
		StringBuilder stringBuilder = new StringBuilder(); // ͬStringBuffer����ʼ������Ϊ16
		
		/**StringBuilder��append()����ʱ���Դ����κ����͵Ĳ�������ƴ�ӵģ�������byte[]������ʱ���Զ���������*/
		stringBuilder.append(false);
		stringBuilder.append("aghgh");
		stringBuilder.append('a');
		stringBuilder.append(20);
		stringBuilder.append(3.1415926);
		stringBuilder.append(1112L);
		
		System.out.println(stringBuilder);
	}
	
}
