package edu.hebeu.fork_join_pool;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

/**
 * 须知：Fork/Join框架：就是在必要的情况下，将一个大任务，进行拆分(fork)成
 * 若干个小任务(拆到不可再拆时)，再将一个个的小任务运算的结果进行汇总(join)；
 * 
 * 工作窃取模式：当执行新的任务时它们将其拆分成更小的任务执行，并将小任务加到
 * 线程队列中，然后再从一个随即线程的队列中偷取一个并把它放到自己的队列中；
 * 
 * 自定义的Fork/Join框架，可以采用以下两种方式：
 * 	1、继承RecursiveTask类(有返回值)
 * 	2、继承RecursiveAction类(没有返回值)
 * 
 * @author 13651
 *
 */
public class ForkJoinPoolStu {
	public static void main(String[] args) {
		
		long startComputer = 0L;
		long endComputer = 600000000000L; // 600亿
		
		traditionTest(startComputer, endComputer); // 传统的计算——————————42169ms
		System.out.println("-----------------------------------------------------");
		myForkJoinTest(startComputer, endComputer); // 自定义的ForkJoin框架计算——————————9516ms
		System.out.println("-----------------------------------------------------");
		jdk8Test(startComputer, endComputer); // JDK8提供的ForkJoin框架计算——————————5724ms
	}
	
	private static void jdk8Test(long startComputer, long endComputer) {
		Instant startTime = Instant.now();
		
		long sum = LongStream.rangeClosed(startComputer, endComputer)
					.parallel()
					.reduce(startComputer, Long :: sum);
		System.out.println(sum);
		
		Instant endTime = Instant.now();
		System.out.println("JDK8提供的ForkJoin框架计算总耗时：" + Duration.between(startTime, endTime).toMillis());
	}
	
	/**
	 * 自定义的ForkJoin框架测试
	 */
	private static void myForkJoinTest(long startComputer, long endComputer) {
		Instant startTime = Instant.now();
		// 创建ForkJoinPool线程池
		ForkJoinPool pool = new ForkJoinPool();
		
		ForkJoinTask<Long> task = new MyForkJoin(startComputer, endComputer); // 从0计算到100亿
		// 分配任务
		Long sum = pool.invoke(task);
		System.out.println(sum);
		
		Instant endTime = Instant.now();
		System.out.println("自定义ForkJoin框架计算总耗时：" + Duration.between(startTime, endTime).toMillis());

	}
	
	/**
	 * 传统的计算测试
	 */
	private static void traditionTest(long startComputer, long endComputer) {
		Instant startTime = Instant.now();
		
		long sum = 0L;
		for(long i = startComputer; i <= endComputer; i++) {
			sum += i;
		}
		System.out.println(sum);
		
		Instant endTime = Instant.now();
		System.out.println("传统计算总耗时：" + Duration.between(startTime, endTime).toMillis());
		
	}
}

class MyForkJoin extends RecursiveTask<Long> {

	/**
	 * 序列化版本号
	 */
	private static final long serialVersionUID = 4631816604961724382L;

	private long startComputer; // 起始计算值
	private long endComputer; // 结束计算结束
	
	private static final long THURSHOLD = 100000L; // 临界值为10万
	
	public MyForkJoin(long startComputer, long endComputer) {
		this.startComputer = startComputer;
		this.endComputer = endComputer;
	}

	@Override
	protected Long compute() {
		long length = endComputer - startComputer;
		
		if(length <= THURSHOLD) { // 如果计算的值的长度小于等于临界值，就不进行拆分，直接计算
			long sum = 0L;
			for(long i = startComputer; i <= endComputer; i++) {
				sum += i;
			}
			return sum;
		} else {
			long middleValue = (startComputer + endComputer) / 2; // 计算中间值
			 
			/*
			  * 拆至左边
			  */
			MyForkJoin leftValue = new MyForkJoin(startComputer, middleValue);
			leftValue.fork(); // 进行拆分，同时压入线程队列
			
			/*
			 * 拆至右边
			 */
			MyForkJoin rightValue = new MyForkJoin(middleValue + 1, endComputer);
			rightValue.fork(); // 进行拆分，同时压入线程队列
			
			return leftValue.join() + rightValue.join(); // 进行合并计算
		}
	}
}
