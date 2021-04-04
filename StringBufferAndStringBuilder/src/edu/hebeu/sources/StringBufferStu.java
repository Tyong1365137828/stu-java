package edu.hebeu.sources;

/**
 * ѧϰStringBuffer��
 * @author 13651
 *
 */
public class StringBufferStu {
	/**
	 * �ڽ����ַ�����ƴ��ʱ��������ʹ�� + ���������ǣ����ַ�ʽ��׷�Ӵ������ַ���ʱ�ᵼ�·������ڵ��ַ����������д���
	 * ������Strng���󣬵��¿ռ���˷ѡ�
	 * ����룺String s = "abc";
	 * 		   s += "vb";
	 * �����д���ͻ��ڷ������ڵ��ַ��������д���3�����󣬷ֱ��ǣ�"abc"��"vb"��"abcvb"��
	 * 
	 * ��ˣ����ʹ��StringBuffer���append()����ʵ���ַ�����׷�Ӳ�����
	 * StringBuffer�ࣺStringBuffer�ײ�ʵ������һ��byte[]���飬Ĭ��Ϊ16λ���������Զ����ݣ���StringBuffer�з��ַ�����ʵ�����Ƿŵ�byte[]�������ˡ�
	 * ע�⣺��Ϊ�ײ������飬��Java�У�����һ�������������ǲ��ɱ�ģ���ˣ�����ʵ������ͨ������һ����������飬����ԭ����һ��һ���Ŀ������Ǹ����������
	 * ��ʵ�ֵģ�����ڴ���StringBuffer����ʱ������ܱ�֤Ԥ����byte[]�����ʹ�ó����Եõ���������ͨ�����췽�����д�������֤�����ִ��Ч�ʣ�
	 * 
	 * 	StringBuffer()���췽����
	 * 		ʹ�÷�����StringBuffer stringBuffer = new StringBuffer();
	 * 		���ã�����һ�������ַ����ַ�������������ʼ������Ϊ16λ��byte[]���飬��������������Զ����䣻
	 * 	StringBuffer(int capacity)���췽����
	 * 		ʹ�÷�����StringBuffer stringBuffer = new StringBuffer(100);
	 * 		���ã�����һ�������ַ����ַ���������������λ100��byte[]���飬������������Զ����䣻
	 * 
	 * StringBufferʹ�õ��Ż�������
	 * 		StringBuffer��byte[]������ʱ���Զ����ݣ���Ϊ�����飬��Java������һ���������ȾͲ����ٱ��ˣ��������ݵı�����ͨ������һ����������飬
	 * 	  �ٰ�ԭ�ȵ�����Ԫ��һ��һ���Ŀ������Ǹ���������飬�Դ�ʵ�����ݣ������StringBuffer����ʱӦԤ����һ�£������ܸ���һ�����ʳ�ʼ��������
	 * 	  ��������(����byte[]����Ĵ�������)��
	 */
	
	public static void main(String[] args) {
		StringBuffer stringBuffer = new StringBuffer(); // ����StringBuffer���󣬳�ʼ������Ϊ16(byte[]����Ϊ16λ)
//		StringBuffer stringBuffer2 = new StringBuffer(100); // ����StringBuffer���󣬳�ʼ������Ϊ100(byte[]����Ϊ100λ)
		
		/**StringBuffer��append()����ʱ���Դ����κ����͵Ĳ�������ƴ�ӵģ�������byte[]������ʱ���Զ���������*/
		stringBuffer.append(false);
		stringBuffer.append("aghgh");
		stringBuffer.append('a');
		stringBuffer.append(20);
		stringBuffer.append(3.1415926);
		stringBuffer.append(1112L);
		
//		System.out.println(stringBuffer.toString());
		System.out.println(stringBuffer); // �����������ͣ������ʱ��Ĭ�ϵ��ö����toString()����
	}
}
