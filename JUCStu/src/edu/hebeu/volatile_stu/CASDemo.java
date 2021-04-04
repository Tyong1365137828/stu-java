package edu.hebeu.volatile_stu;

/**
 * �������ģ��CAS�㷨��ִ�����̣���ѧϰCAS�㷨
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
					int expectedValue = compareAndSwap.get(); // ͨ���ڴ�ֵ������ǰ��Ԥ��ֵ
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
	 * ��ȡ�ڴ�ֵ
	 * @return
	 */
	public synchronized int get() {
		return value;
	}
	
	/**
	 * �ȽϾ�ֵ��Ԥ��ֵ
	 * @param expectedValue
	 * @param newValue
	 * @return
	 */
	public synchronized int compareAndSwap(int expectedValue, int newValue) {
		int oldValue = value;
		// �����ֵ����Ԥ��ֵ
		if(oldValue == expectedValue) {
			this.value = newValue;
		}
		return oldValue;
	}
	
	/**
	 * �Ƚϲ�����
	 * @param expectedValue
	 * @param newValue
	 * @return
	 */
	public synchronized boolean compareAndSet(int expectedValue, int newValue) {
		return expectedValue == compareAndSwap(expectedValue, newValue);
	}
	
}
