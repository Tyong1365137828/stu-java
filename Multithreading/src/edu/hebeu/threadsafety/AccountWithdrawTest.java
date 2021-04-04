package edu.hebeu.threadsafety;

/**
 * 账户取款模拟
 * @author 13651
 *
 */
public class AccountWithdrawTest {
	public static void main(String[] aregs) {
		Account account = new Account("001", 12000); // 创建账户对象
		AccountThread t1 = new AccountThread(account); // 创建上述账户对象的线程对象t1
		AccountThread t2 = new AccountThread(account); // 创建上述账户对象的线程对象t2
		t1.setName("t1");
		t2.setName("t2");
		
		Account account2 = new Account("002", 10000); // 创建账户对象
		AccountThread t3 = new AccountThread(account2); // 创建上述账户对象的线程对象t3
		t3.setName("t3");
		
		Account account3 = new Account("003", 20000); // 创建账户对象
		AccountThread t4 = new AccountThread(account3); // 创建上述账户对象的线程对象t4
		AccountThread t5 = new AccountThread(account3); // 创建上述账户对象的线程对象t5
		AccountThread t6 = new AccountThread(account3); // 创建上述账户对象的线程对象t6
		t4.setName("t4");
		t5.setName("t5");
		t6.setName("t6");
		
		t1.start(); // 启动t1线程，进行取款
		t2.start(); // 启动t2线程，进行取款
		
		t3.start(); // 启动t3线程，进行取款
		
		t4.start(); // 启动t4线程，进行取款
		t5.start(); // 启动t5线程，进行取款
		t6.start(); // 启动t6线程，进行取款
		
	}
	
}
