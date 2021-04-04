package edu.hebeu.sources;

/**
 * String���ڲ��ĳ��÷���
 * @author 13651
 *
 */
public class StringMethods {
	
	/**
	 * charAt()�������ԣ��᷵��ָ��������һ��char��������
	 * @param s �ַ���
	 * @param index �ַ�����Ӧ����������0��ʼ
	 */
	public void charAtTest(String s, int index) {
		System.out.println(s.charAt(index));
	}
	
	/**
	 * �����ֵ��<˳��(��������)>�Ƚ������ַ����Ĵ�С�����ֲ���Ⱦ�returnֵ����Ⱦͼ����Ƚϣ�ֱ���Ƚ����
	 * ��ͬ��ͬ(ǰ.compareTo(��))��0
	 * ǰС���(ǰ.compareTo(��))������(-1)
	 * ǰ���С(ǰ.compareTo(��))������(1)
	 * @param s1
	 * @param s2
	 */
	public void compareToTest(String s1, String s2) {
		System.out.println(s1.compareTo(s2));
	}
	
	/**
	 * �жϵ�ǰ���ַ����Ƿ������������ַ���������Ϊtrue����֮Ϊfalse
	 * @param s �ַ���
	 * @param sChild ���ַ���
	 */
	public void containsTest(String s, String sChild) {
		System.out.println(s.contains(sChild));
	}
	
	/**
	 * �жϵ�ǰ�ַ����Ƿ���ĳһ�ַ���β
	 * @param s �ַ���
	 * @param endS ��β�ַ���
	 */
	public void endsWithTest(String s, String endS) {
		System.out.println(s.endsWith(endS));
	}
	
	/**
	 * �ж������ַ����Ƿ����
	 * @param s1
	 * @param s2
	 */
	public void equalsTest(String s1, String s2) {
		System.out.println(s1.equals(s2));
	}
	
	/**
	 * �ж������ַ����Ƿ����(���Դ�Сд)
	 * @param s1
	 * @param s2
	 */
	public void equalsIgnoreCaseTest(String s1, String s2) {
		System.out.println(s1.equalsIgnoreCase(s2));
	}
	
	/**
	 * ����һ��byte[]���飬�������ǽ��ַ�������ת��Ϊ�ֽڵ�����
	 * @param s
	 */
	public void getBytesTest(String s) {
		byte[] sBytes = s.getBytes();
		System.out.print(s + "���ֽ�����Ϊ:[");
		for(int i = 0; i < sBytes.length; i++) {
			System.out.print(sBytes[i]);
			if(i < sBytes.length - 1) {
				System.out.print(", ");
			} else {
				System.out.println("]");
			}
		}
	}
	
	/**
	 * �ж�ĳ�����ַ����ڵ�ǰ�ַ����״γ��ֵĵ�һ���ַ�������<�����������±�>��û�оͷ��� -1
	 * @param s �ַ���
	 * @param sChild ���ַ���
	 */
	public void indexOfTest(String s, String sChild) {
		System.out.println(s.indexOf(sChild));
	}
	
	/**
	 * �ж��ַ����Ƿ�Ϊ�գ���Ϊtrue���ǿ�Ϊfalse
	 * ע��sΪnullʱ����ֿ�ָ���쳣
	 * @param s
	 */
	public void isEmptyTest(String s) {
		System.out.println(s.isEmpty());
	}
	
	/**
	 * ��ȡ�ַ����ĳ���
	 * ע���ȡ���鳤�ȵ�length�����ԣ���ȡ�ַ������ȵ�length()�Ƿ����������ǲ�һ����
	 * @param s
	 */
	public void lengthTest(String s) {
		System.out.println(s.length());
	}
	
	/**
	 * �ж�ĳ�����ַ����ڵ�ǰ�ַ��������ֵĵ�һ���ַ�������<�����������±�>��û�оͷ��� -1
	 * @param s
	 * @param sChild
	 */
	public void lastIndexOfTest(String s, String sChild) {
		System.out.println(s.lastIndexOf(sChild));
	}
	
	/**
	 * ����һ�����ַ�����ͨ��һ��newChar�滻һ��oldChar�õ�<newChar�滻���ַ����г��ֵ�����oldChar>
	 * @param s
	 */
	public void replaceArgsIsCharTest(String s, char oldChar, char newChar) {
		System.out.println(s.replace(oldChar, newChar));
	}
	
	/**
	 * ����һ���µ��ַ�����ͨ��oldString�滻newString�õ�<newString�滻�ַ����г��ֵ�oldString>
	 * CharSequence��String��ĸ��ӿ�
	 * @param s
	 * @param oldString
	 * @param newString
	 */
	public void replaceArgsIsCharSequenceTest(String s, CharSequence oldString, CharSequence newString) {
		System.out.println(s.replace(oldString, newString));
	}
	
	/**
	 * ����һ��String[] ���飬����ͨ��split����Ĳ���Ϊ�ָ��߽��зָ�
	 * @param s ���и���ַ���
	 * @param regex ������������ʽ��Ҳ��������ͨ�ַ���
	 */
	public void splitTest(String s, String regex) {
		String[] array = s.split(regex);
		System.out.print(s + "�ַ������и�Ϊ�ַ�������:[");
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i]);
			if(i < array.length - 1) {
				System.out.print(", ");
			} else {
				System.out.println("]");
			}
		}
	}
	
	/**
	 * �жϵ�ǰ�ַ����Ƿ���ĳ�����ַ�����ʼ
	 * @param s �ַ���
	 * @param sChild ���ַ���
	 */
	public void startsWith(String s, String sChild) {
		System.out.println(s.startsWith(sChild));
	}
	
	/**
	 * ����һ���ַ�����ͨ����ʼ�±꿪ʼ��ȡ�����ַ���
	 * @param s �ַ���
	 * @param startSubScript ��ʼ��ȡ���±� <��ȡʱ����>
	 */
	public void subStringTest(String s, int startSubScript) {
		System.out.println(s.substring(startSubScript));
	}
	
	/**
	 * ����һ���ַ�����ͨ����ʼ�±�ͽ����±��ȡ�����ַ���
	 * @param s �ַ���
	 * @param startSubScript ��ʼ��ȡ���±� <��ȡʱ����>
	 * @param endSubScript ��ֹ��ȡ���±�ĺ�һλ*********************** <��ȡʱ������>
	 */
	public void subStringTest(String s, int startSubScript, int endSubScript) {
		System.out.println(s.substring(startSubScript, endSubScript));
	}
	
	/**
	 * ��һ���ַ���ת��Ϊchar[] ����
	 * @param s
	 */
	public void toCharArrayTest(String s) {
		char[] array = s.toCharArray();
		System.out.print(s + "�ַ�����ת��Ϊ�ַ�����:[");
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i]);
			if(i < array.length - 1) {
				System.out.print(", ");
			} else {
				System.out.println("]");
			}
		}
	}
	
	/**
	 * ��һ���ַ���ת��ת��ΪСд
	 * @param s
	 */
	public void toLowerCaseTest(String s) {
		System.out.println(s.toLowerCase());
	}
	
	/**
	 * ��һ���ַ���ת��ת��Ϊ��д
	 * @param s
	 */
	public void toUpperCaseTest(String s) {
		System.out.println(s.toUpperCase());
	}
	
	/**
	 * ȥ���ַ���ǰ��հ�
	 * @param s
	 */
	public void trimTest(String s) {
		System.out.println(s.trim());
	}
	
	/**
	 * valueOf()������String���еľ�̬����
	 * ��boolean���͵�����ת��Ϊ�ַ���
	 * @param flag
	 */
	public void valueOfTest(boolean flag) {
		System.out.println(String.valueOf(flag));
	}
	/**��int[]����ת��Ϊ�ַ���*/
	public void valueOfTest(int[] array) {
		System.out.println(String.valueOf(array));
	}
	/**��int���͵�����ת��Ϊ�ַ���*/
	public void valueOfTest(int value) {
		System.out.println(String.valueOf(value));
	}
	/**����Ƕ����Ĭ�ϵ��ö����toString()����*/
	public void valueOfTest(User user) {
		System.out.println(String.valueOf(user));
	}
	
	/**
	 * System.out.println()����������������κ�����ʱ�������String.valueOf()��̬������������������κ��������ݱ��String���͵����ݣ�
	 * ��˿���̨��������κ����ݶ���ת��ΪString���ͺ�ģ�����
	 */
	
}
