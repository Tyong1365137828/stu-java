package edu.hebeu.threadsafety;

/**
 * �˻�ȡ��ģ��
 * @author 13651
 *
 */
public class AccountWithdrawTest {
	public static void main(String[] aregs) {
		Account account = new Account("001", 12000); // �����˻�����
		AccountThread t1 = new AccountThread(account); // ���������˻�������̶߳���t1
		AccountThread t2 = new AccountThread(account); // ���������˻�������̶߳���t2
		t1.setName("t1");
		t2.setName("t2");
		
		Account account2 = new Account("002", 10000); // �����˻�����
		AccountThread t3 = new AccountThread(account2); // ���������˻�������̶߳���t3
		t3.setName("t3");
		
		Account account3 = new Account("003", 20000); // �����˻�����
		AccountThread t4 = new AccountThread(account3); // ���������˻�������̶߳���t4
		AccountThread t5 = new AccountThread(account3); // ���������˻�������̶߳���t5
		AccountThread t6 = new AccountThread(account3); // ���������˻�������̶߳���t6
		t4.setName("t4");
		t5.setName("t5");
		t6.setName("t6");
		
		t1.start(); // ����t1�̣߳�����ȡ��
		t2.start(); // ����t2�̣߳�����ȡ��
		
		t3.start(); // ����t3�̣߳�����ȡ��
		
		t4.start(); // ����t4�̣߳�����ȡ��
		t5.start(); // ����t5�̣߳�����ȡ��
		t6.start(); // ����t6�̣߳�����ȡ��
		
	}
	
}
