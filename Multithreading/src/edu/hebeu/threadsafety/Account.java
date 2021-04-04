package edu.hebeu.threadsafety;

/**
 * 账户类
 * @author 13651
 *
 */
public class Account {
	private String username;
	private double money;
	Object obj = new Object(); // 创建一个实例变量，一个对象只有这一个数据，因为类型是对象，则obj是共享对象，所以可以做synchronized(){}的()内的线程共享对象
	
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
	 * 用户取款方法(没有使用线程同步机制)
	 * @param money 取款金额
	 */
	public void withdrawMoney(double money) {
		// 获取初始的余额
		double startMoney = this.getMoney();
		// 获取取款之后的余额
		double endMoney = startMoney - money;
		
		// 这里模拟一下网络延迟，导致取款之后，剩余金额数据没有及时更新
		try {
			Thread.sleep(1000); // 睡眠1秒(网络延迟1秒)
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// 更新账户余额
		this.setMoney(endMoney);
		
		/**
		 * 测试之后会发现已经出现线程安全问题了
		 */
	}
	
	/**
	 * 用户取款方法(使用线程同步机制)
	 * @param money 取款金额
	 * @param synchronization 是否线程同步，true:线程同步(排队执行)；false:线程不同步
	 */
	public void withdrawMoney(double money, boolean synchronization) {
		Object obj2 = new Object(); // 这是局部变量，每次执行这个方法就会new出一个这个对象，因此一个对象内这个对象不能保证只有一个，则obj2不是共享对象，所以这个对象不能做synchronized(){}的()内的线程共享对象；
		
		if(synchronization) { // 如果选择线程同步
			/*
			 * 在synchronized(){}内的代码会线程排队执行(即一个线程把这里面的代码全部执行结束之后，另一个线程才能进来)，不能并发；
			 * 线程同步机制的语法：
			 * 	synchronized() {
			 * 		// 线程同步代码块
			 * 	}
			 * 
			 * 	synchronized关键字后面的小括号中传入的这个"数据"是相当关键的，这个数据必须是多线程共享的数据，这样才能实现多线程排队执行；
			 * 
			 * 	synchronized表示“排他锁”；	
			 * 
			 * 	()中写什么？怎么写？
			 * 		主要看想让那些线程同步，如t1、t2、t3、t4、t5五个线程，若只希望t1、t2、t3这3个线程排队，t4、t5这2个线程不排队，那么就要在
			 * 	synchronized(){}的()内写入t1、t2、t3这3个线程共享的对象，而且这个对象对于t4、t5这2个线程来说是不共享的；
			 * 
			 * 	本例子中，共享的对象是Account对象，那么Account对象共享即是this
			 */
			synchronized(this) {
//			synchronized(obj) {
//			synchronized("12ab") { // 因为 "12ab" 这个字符串没有使用new对象的方式创建，而是直接写入，其会在方法区内的字符串常量池中，因此一个对象内唯一，所以 "12ab" 字符串是共享对象，所以这个对象能做synchronized(){}的()内的线程共享对象；但是这种方式所有线程都会同步！！！
//			synchronized(null) { // 会出现空指针异常
//			synchronized(obj2) { // 这个共享对象不能保证在一个对象内唯一，所以不能做synchronized(){}的()内的线程共享对象；
				// 获取初始的余额
				double startMoney = this.getMoney();
				// 获取取款之后的余额
				double endMoney = startMoney - money;
				
				// 这里模拟一下网络延迟，导致取款之后，剩余金额数据没有及时更新
				try {
					Thread.sleep(1000); // 睡眠1秒(网络延迟1秒)
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				// 更新账户余额
				this.setMoney(endMoney);
			}
		} else { // 如果没有选择线程同步
			this.withdrawMoney(money);
		}
	}
	
	
	/**
	 * synchronized出现在实例方法上，也可以实现线程同步化；
	 * 	synchronized出现在实例方法上，对象锁一定是在this，且只能是this
	 * 
	 * 缺点:	1、synchronized出现在实例方法上只能锁this，这种方法不灵活；
	 * 		2、synchronized出现在实例方法上，表示整个方法体都需要同步，可能会无故扩大同步范围，
	 * 		导致程序的执行效率降低，这种方式不常用；
	 * 
	 * 优点：代码节俭了；
	 * 
	 * 因此如果共享的对象就是this，并且需要同步的代码块就是整个方法体，建议使用这种方式
	 * @param money
	 */
	public synchronized void withdrawMoneySynchronized(double money) {
		// 获取初始的余额
		double startMoney = this.getMoney();
		// 获取取款之后的余额
		double endMoney = startMoney - money;
		
		// 这里模拟一下网络延迟，导致取款之后，剩余金额数据没有及时更新
		try {
			Thread.sleep(1000); // 睡眠1秒(网络延迟1秒)
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// 更新账户余额
		this.setMoney(endMoney);
		
		/**
		 * 测试之后会发现已经出现线程安全问题了
		 */
	}
	
}
