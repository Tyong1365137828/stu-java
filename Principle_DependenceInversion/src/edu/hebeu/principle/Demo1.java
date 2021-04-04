package edu.hebeu.principle;

public class Demo1 {

	/**
	 * ���Է��֣�������µĽ�����ʱ���ͻ��˲��ý��иı䣬ֱ�Ӵ���������ʵ�����ɣ�
	 * @param args
	 */
	public static void main(String[] args) {
		Person person = new Person();
		person.receive(new Email());
		person.receive(new WeChat());
	}
}

class Person {

	public void receive(IReceiver receiver) {
		System.out.println(receiver.getInfo());
	}
}

interface IReceiver {
	String getInfo();
}

class Email implements IReceiver {
	
	@Override
	public String getInfo() {
		return "�����ʼ�������Ϣ��";
	}
}

class WeChat implements IReceiver {

	@Override
	public String getInfo() {
		return "΢�ţ�����Ϣ��";
	}
}
