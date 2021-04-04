package edu.hebeu.original;

public class Demo {
	
	public static void main(String[] args) {
		Person person = new Person();
		person.receive(new Email());
	}
}

/**这个类用来进行信息的接收
 * 分析：
 * 	1、这种方式比较简单，易于实现；
 * 	2、但是，这样只能接收Email类的实例了，如果程序需要扩展使能够接收新的类的实例，那么就需要在新增类的同时
 * 再重新定义新的方法
 * 
 * 解决方法：
 * 	可以引入一个抽象的接口IReceiver，表示接受者，让Person类与IReceiver接口发送依赖，因为Email等其他的需要
 * 接收的类属于接收的范围，它们各自实现IReceiver接口就可以了，此时就符合了依赖倒置原则！
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
		return "电子邮件：来消息了";
	}
}
