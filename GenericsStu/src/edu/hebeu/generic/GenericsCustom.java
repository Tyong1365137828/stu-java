package edu.hebeu.generic;

/**
 * �Զ��巺��
 * 	�Զ��巺��ʱ <> ����һ����ʶ�������д;
 * 	���� <> ���ʹ�õ�Ӣ����E��T��E��ʾElement��T��ʾType��
 * 
 * @author 13651
 *
 */
public class GenericsCustom<���д> {
	public void doSome(���д t) {
		System.out.println("doSome()������" + t);
	}
	
	public ���д returnSome(���д t) {
		return t;
	}
	
	
	public static void main(String[] args) {
		GenericsCustom<String> gc = new GenericsCustom<>();
//		gc.doSome(210); // ��ʱ�������ᱨ��
		gc.doSome("����ѧϰ");
		
//		Integer a = gc.returnSome(200); // ��ʱ�������ᱨ��
//		int b = gc.returnSome(58); // ��ʱ�������ᱨ��
//		String c = gc.returnSome(5.8); // ��ʱ�������ᱨ��
		String d = gc.returnSome("���ͣ����ͣ�����");
		System.out.println(d);
		
		
		/**������巺�ͣ�����û��ʹ�ã�Java�ὫĬ��ΪObject����*/
		GenericsCustom gc2 = new GenericsCustom();
		gc2.doSome("����");
//		String a = gc2.returnSome("���"); // ��ʱ�������ᱨ��
//		String b = gc2.returnSome(500); // ��ʱ�������ᱨ��
//		String c = gc2.returnSome(new Object()); // ��ʱ�������ᱨ��
		Object o = gc2.returnSome(new Object());
		System.out.println(o);
	}
}
