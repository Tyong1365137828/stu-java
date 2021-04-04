package edu.hebeu.threadsafety;

/**
 * �˻���
 * @author 13651
 *
 */
public class Account {
	private String username;
	private double money;
	Object obj = new Object(); // ����һ��ʵ��������һ������ֻ����һ�����ݣ���Ϊ�����Ƕ�����obj�ǹ���������Կ�����synchronized(){}��()�ڵ��̹߳������
	
	public Account(String username, double money) {
		super();
		this.username = username;
		this.money = money;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public double getMoney() {
		return money;
	}
	
	public void setMoney(double money) {
		this.money = money;
	}

	@Override
	public String toString() {
		return "Account [username=" + username + ", money=" + money + "]";
	}
	
	/**
	 * �û�ȡ���(û��ʹ���߳�ͬ������)
	 * @param money ȡ����
	 */
	public void withdrawMoney(double money) {
		// ��ȡ��ʼ�����
		double startMoney = this.getMoney();
		// ��ȡȡ��֮������
		double endMoney = startMoney - money;
		
		// ����ģ��һ�������ӳ٣�����ȡ��֮��ʣ��������û�м�ʱ����
		try {
			Thread.sleep(1000); // ˯��1��(�����ӳ�1��)
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// �����˻����
		this.setMoney(endMoney);
		
		/**
		 * ����֮��ᷢ���Ѿ������̰߳�ȫ������
		 */
	}
	
	/**
	 * �û�ȡ���(ʹ���߳�ͬ������)
	 * @param money ȡ����
	 * @param synchronization �Ƿ��߳�ͬ����true:�߳�ͬ��(�Ŷ�ִ��)��false:�̲߳�ͬ��
	 */
	public void withdrawMoney(double money, boolean synchronization) {
		Object obj2 = new Object(); // ���Ǿֲ�������ÿ��ִ����������ͻ�new��һ������������һ����������������ܱ�ֻ֤��һ������obj2���ǹ���������������������synchronized(){}��()�ڵ��̹߳������
		
		if(synchronization) { // ���ѡ���߳�ͬ��
			/*
			 * ��synchronized(){}�ڵĴ�����߳��Ŷ�ִ��(��һ���̰߳�������Ĵ���ȫ��ִ�н���֮����һ���̲߳��ܽ���)�����ܲ�����
			 * �߳�ͬ�����Ƶ��﷨��
			 * 	synchronized() {
			 * 		// �߳�ͬ�������
			 * 	}
			 * 
			 * 	synchronized�ؼ��ֺ����С�����д�������"����"���൱�ؼ��ģ�������ݱ����Ƕ��̹߳�������ݣ���������ʵ�ֶ��߳��Ŷ�ִ�У�
			 * 
			 * 	synchronized��ʾ������������	
			 * 
			 * 	()��дʲô����ôд��
			 * 		��Ҫ��������Щ�߳�ͬ������t1��t2��t3��t4��t5����̣߳���ֻϣ��t1��t2��t3��3���߳��Ŷӣ�t4��t5��2���̲߳��Ŷӣ���ô��Ҫ��
			 * 	synchronized(){}��()��д��t1��t2��t3��3���̹߳���Ķ��󣬶�������������t4��t5��2���߳���˵�ǲ�����ģ�
			 * 
			 * 	�������У�����Ķ�����Account������ôAccount��������this
			 */
			synchronized(this) {
//			synchronized(obj) {
//			synchronized("12ab") { // ��Ϊ "12ab" ����ַ���û��ʹ��new����ķ�ʽ����������ֱ��д�룬����ڷ������ڵ��ַ����������У����һ��������Ψһ������ "12ab" �ַ����ǹ���������������������synchronized(){}��()�ڵ��̹߳�����󣻵������ַ�ʽ�����̶߳���ͬ��������
//			synchronized(null) { // ����ֿ�ָ���쳣
//			synchronized(obj2) { // �����������ܱ�֤��һ��������Ψһ�����Բ�����synchronized(){}��()�ڵ��̹߳������
				// ��ȡ��ʼ�����
				double startMoney = this.getMoney();
				// ��ȡȡ��֮������
				double endMoney = startMoney - money;
				
				// ����ģ��һ�������ӳ٣�����ȡ��֮��ʣ��������û�м�ʱ����
				try {
					Thread.sleep(1000); // ˯��1��(�����ӳ�1��)
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				// �����˻����
				this.setMoney(endMoney);
			}
		} else { // ���û��ѡ���߳�ͬ��
			this.withdrawMoney(money);
		}
	}
	
	
	/**
	 * synchronized������ʵ�������ϣ�Ҳ����ʵ���߳�ͬ������
	 * 	synchronized������ʵ�������ϣ�������һ������this����ֻ����this
	 * 
	 * ȱ��:	1��synchronized������ʵ��������ֻ����this�����ַ�������
	 * 		2��synchronized������ʵ�������ϣ���ʾ���������嶼��Ҫͬ�������ܻ��޹�����ͬ����Χ��
	 * 		���³����ִ��Ч�ʽ��ͣ����ַ�ʽ�����ã�
	 * 
	 * �ŵ㣺����ڼ��ˣ�
	 * 
	 * ����������Ķ������this��������Ҫͬ���Ĵ����������������壬����ʹ�����ַ�ʽ
	 * @param money
	 */
	public synchronized void withdrawMoneySynchronized(double money) {
		// ��ȡ��ʼ�����
		double startMoney = this.getMoney();
		// ��ȡȡ��֮������
		double endMoney = startMoney - money;
		
		// ����ģ��һ�������ӳ٣�����ȡ��֮��ʣ��������û�м�ʱ����
		try {
			Thread.sleep(1000); // ˯��1��(�����ӳ�1��)
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// �����˻����
		this.setMoney(endMoney);
		
		/**
		 * ����֮��ᷢ���Ѿ������̰߳�ȫ������
		 */
	}
	
}
