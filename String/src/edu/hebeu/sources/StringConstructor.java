package edu.hebeu.sources;

/**
 * String��Ĺ��췽������
 * @author 13651
 *
 */
public class StringConstructor {
	
	/**
	 * ��String��Ĺ��췽���������byte���͵�����ʱ
	 * @param array byte���͵�����
	 */
	public void argsIsIsByteArray(byte[] array) {
		String s = new String(array);
		System.out.println(s);
	}
	
	/**
	 * ��String��Ĺ��췽���������byte���͵����顢ƫ����������ʱ��
	 * @param array byte���͵�����
	 * @param offset ƫ����(��СΪ0�����Ϊ���鳤�� - 1�����������Ϊ�����±�)
	 * @param length ���ȣ���Ԫ�صĸ���
	 */
	public void argsIsIsByteArrayAndOffsetAndLength(byte[] array, int offset, int length) {
		String s = new String(array, offset, length);
		System.out.println(s);
	}
	
	/*�������͵�����(��char��String��...)Ҳ������ͬ���ķ���*/
	
	
	/**
	 * ͨ��������Եó����ۣ�String���ڵ�toString()�����Ѿ���д�ˣ�
	 * ��ΪtoString()������Object��Ĭ��������ڴ��ַ�ģ����ﱾӦ���byte[]������ڴ��ַ(����Ԫ�ص��ڴ��ַ)��
	 * ���Ƿ���ʵ��������ǽ�byte[]����Ԫ��ƴ�ӳ��ַ�����ֵ
	 */
}
