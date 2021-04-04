package edu.hebeu.volatile_stu;

/**
 * 这个例子模拟CAS算法的执行流程，以学习CAS算法
 * @author 13651
 *
 */
public class CASDemo {
	public static void main(String[] args) {
		
		final CompareAndSwap compareAndSwap = new CompareAndSwap();
		
		for(int i = 0; i < 16; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					int expectedValue = compareAndSwap.get(); // 通过内存值赋给当前的预估值
					boolean isTrue = compareAndSwap.compareAndSet(expectedValue, (int) (Math.random() * 100));
					System.out.println(isTrue);
				}
			}).start();
		}
	}
}

class CompareAndSwap {
	
	private int value;
	
	/**
	 * 获取内存值
	 * @return
	 */
	public synchronized int get() {
		return value;
	}
	
	/**
	 * 比较旧值与预估值
	 * @param expectedValue
	 * @param newValue
	 * @return
	 */
	public synchronized int compareAndSwap(int expectedValue, int newValue) {
		int oldValue = value;
		// 如果旧值等于预估值
		if(oldValue == expectedValue) {
			this.value = newValue;
		}
		return oldValue;
	}
	
	/**
	 * 比较并设置
	 * @param expectedValue
	 * @param newValue
	 * @return
	 */
	public synchronized boolean compareAndSet(int expectedValue, int newValue) {
		return expectedValue == compareAndSwap(expectedValue, newValue);
	}
	
}
