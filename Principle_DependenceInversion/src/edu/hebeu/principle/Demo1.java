package edu.hebeu.principle;

public class Demo1 {

	/**
	 * 可以发现，在添加新的接收类时，客户端不用进行改变，直接传入接收类的实例即可！
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
		return "电子邮件：来消息了";
	}
}

class WeChat implements IReceiver {

	@Override
	public String getInfo() {
		return "微信：来消息了";
	}
}
