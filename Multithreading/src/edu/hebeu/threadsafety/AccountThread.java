package edu.hebeu.threadsafety;

public class AccountThread extends Thread{

	private Account account;
	
	public AccountThread(Account account) {
		super();
		this.account = account; // 通过构造方法保证同一个账户对象使用此线程
	}

	@Override
	public void run() {
		double money = 5000;
//		account.withdrawMoney(money); // 进行取款操作，不使用线程同步机制，取款5000
//		account.withdrawMoney(money, true); // 进行取款操作，使用线程同步机制，取款5000
		account.withdrawMoneySynchronized(money); // 使用synchronized修饰的实例方法体进行线程同步，取款5000
//		synchronized(account) { // 这样也可以实现排队，但是扩大了同步范围，导致效率变低！
//			account.withdrawMoney(money); // 进行取款操作，取款5000
//		}
		System.out.println(Thread.currentThread().getName() + "线程，" + account.getUsername() + 
				"账户取款" + money + "，剩余金额：" + account.getMoney() + "");
	}
	
}
