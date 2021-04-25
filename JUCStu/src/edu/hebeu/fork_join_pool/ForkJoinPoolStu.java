package edu.hebeu.fork_join_pool;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

/**
 * ��֪��Fork/Join��ܣ������ڱ�Ҫ������£���һ�������񣬽��в��(fork)��
 * ���ɸ�С����(�𵽲����ٲ�ʱ)���ٽ�һ������С��������Ľ�����л���(join)��
 * 
 * ������ȡģʽ����ִ���µ�����ʱ���ǽ����ֳɸ�С������ִ�У�����С����ӵ�
 * �̶߳����У�Ȼ���ٴ�һ���漴�̵߳Ķ�����͵ȡһ���������ŵ��Լ��Ķ����У�
 * 
 * �Զ����Fork/Join��ܣ����Բ����������ַ�ʽ��
 * 	1���̳�RecursiveTask��(�з���ֵ)
 * 	2���̳�RecursiveAction��(û�з���ֵ)
 * 
 * @author 13651
 *
 */
public class ForkJoinPoolStu {
	public static void main(String[] args) {
		
		long startComputer = 0L;
		long endComputer = 600000000000L; // 600��
		
		traditionTest(startComputer, endComputer); // ��ͳ�ļ��㡪������������������42169ms
		System.out.println("-----------------------------------------------------");
		myForkJoinTest(startComputer, endComputer); // �Զ����ForkJoin��ܼ��㡪������������������9516ms
		System.out.println("-----------------------------------------------------");
		jdk8Test(startComputer, endComputer); // JDK8�ṩ��ForkJoin��ܼ��㡪������������������5724ms
	}
	
	private static void jdk8Test(long startComputer, long endComputer) {
		Instant startTime = Instant.now();
		
		long sum = LongStream.rangeClosed(startComputer, endComputer)
					.parallel()
					.reduce(startComputer, Long :: sum);
		System.out.println(sum);
		
		Instant endTime = Instant.now();
		System.out.println("JDK8�ṩ��ForkJoin��ܼ����ܺ�ʱ��" + Duration.between(startTime, endTime).toMillis());
	}
	
	/**
	 * �Զ����ForkJoin��ܲ���
	 */
	private static void myForkJoinTest(long startComputer, long endComputer) {
		Instant startTime = Instant.now();
		// ����ForkJoinPool�̳߳�
		ForkJoinPool pool = new ForkJoinPool();
		
		ForkJoinTask<Long> task = new MyForkJoin(startComputer, endComputer); // ��0���㵽100��
		// ��������
		Long sum = pool.invoke(task);
		System.out.println(sum);
		
		Instant endTime = Instant.now();
		System.out.println("�Զ���ForkJoin��ܼ����ܺ�ʱ��" + Duration.between(startTime, endTime).toMillis());

	}
	
	/**
	 * ��ͳ�ļ������
	 */
	private static void traditionTest(long startComputer, long endComputer) {
		Instant startTime = Instant.now();
		
		long sum = 0L;
		for(long i = startComputer; i <= endComputer; i++) {
			sum += i;
		}
		System.out.println(sum);
		
		Instant endTime = Instant.now();
		System.out.println("��ͳ�����ܺ�ʱ��" + Duration.between(startTime, endTime).toMillis());
		
	}
}

class MyForkJoin extends RecursiveTask<Long> {

	/**
	 * ���л��汾��
	 */
	private static final long serialVersionUID = 4631816604961724382L;

	private long startComputer; // ��ʼ����ֵ
	private long endComputer; // �����������
	
	private static final long THURSHOLD = 100000L; // �ٽ�ֵΪ10��
	
	public MyForkJoin(long startComputer, long endComputer) {
		this.startComputer = startComputer;
		this.endComputer = endComputer;
	}

	@Override
	protected Long compute() {
		long length = endComputer - startComputer;
		
		if(length <= THURSHOLD) { // ��������ֵ�ĳ���С�ڵ����ٽ�ֵ���Ͳ����в�֣�ֱ�Ӽ���
			long sum = 0L;
			for(long i = startComputer; i <= endComputer; i++) {
				sum += i;
			}
			return sum;
		} else {
			long middleValue = (startComputer + endComputer) / 2; // �����м�ֵ
			 
			/*
			  * �������
			  */
			MyForkJoin leftValue = new MyForkJoin(startComputer, middleValue);
			leftValue.fork(); // ���в�֣�ͬʱѹ���̶߳���
			
			/*
			 * �����ұ�
			 */
			MyForkJoin rightValue = new MyForkJoin(middleValue + 1, endComputer);
			rightValue.fork(); // ���в�֣�ͬʱѹ���̶߳���
			
			return leftValue.join() + rightValue.join(); // ���кϲ�����
		}
	}
}
