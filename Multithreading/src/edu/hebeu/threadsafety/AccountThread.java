package edu.hebeu.threadsafety;

public class AccountThread extends Thread{

	private Account account;
	
	public AccountThread(Account account) {
		super();
		this.account = account; // ͨ�����췽����֤ͬһ���˻�����ʹ�ô��߳�
	}

	@Override
	public void run() {
		double money = 5000;
//		account.withdrawMoney(money); // ����ȡ���������ʹ���߳�ͬ�����ƣ�ȡ��5000
//		account.withdrawMoney(money, true); // ����ȡ�������ʹ���߳�ͬ�����ƣ�ȡ��5000
		account.withdrawMoneySynchronized(money); // ʹ��synchronized���ε�ʵ������������߳�ͬ����ȡ��5000
//		synchronized(account) { // ����Ҳ����ʵ���Ŷӣ�����������ͬ����Χ������Ч�ʱ�ͣ�
//			account.withdrawMoney(money); // ����ȡ�������ȡ��5000
//		}
		System.out.println(Thread.currentThread().getName() + "�̣߳�" + account.getUsername() + 
				"�˻�ȡ��" + money + "��ʣ���" + account.getMoney() + "");
	}
	
}
