package edu.hebeu.original;

public class Demo {
	
	public static void main(String[] args) {
		Person person = new Person();
		person.receive(new Email());
	}
}

/**���������������Ϣ�Ľ���
 * ������
 * 	1�����ַ�ʽ�Ƚϼ򵥣�����ʵ�֣�
 * 	2�����ǣ�����ֻ�ܽ���Email���ʵ���ˣ����������Ҫ��չʹ�ܹ������µ����ʵ������ô����Ҫ���������ͬʱ
 * �����¶����µķ���
 * 
 * ���������
 * 	��������һ������Ľӿ�IReceiver����ʾ�����ߣ���Person����IReceiver�ӿڷ�����������ΪEmail����������Ҫ
 * ���յ������ڽ��յķ�Χ�����Ǹ���ʵ��IReceiver�ӿھͿ����ˣ���ʱ�ͷ�������������ԭ��
 * @author 13651
 *
 */
class Person {

	public void receive(Email email) {
		System.out.println(email.getInfo());
	}
}

class Email {
	
	public String getInfo() {
		return "�����ʼ�������Ϣ��";
	}
}
