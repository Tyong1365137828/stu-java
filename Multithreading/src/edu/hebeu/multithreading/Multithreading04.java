package edu.hebeu.multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask; // JDK���µģ�����Java�Ĳ��������ϰ��JDKû�����������������

/**
 * ʵ���̵߳ĵ����ַ�ʽ��FutureTask��ʽ��ʵ��Callable�ӿڡ�(JDK8������)��
 * 	���ַ�ʽʵ�ֵ��߳̿��Ի�ȡ�̵߳ķ���ֵ��֮ǰ�����ַ�ʽ(1���̳�Thread����дrun()������
 * 2��ʵ��Runnable����дrun()��������д�������࣬ͨ���������ഴ���̶߳��������ַ�����
 * ���ܹ���ȡ�̷߳���ֵ����Ϊrun()������void)
 * 
 * ��ϵͳί��һ���߳�ȥִ��һ�����񣬸��߳�ִ��������֮�󣬿��ܻ���һ��ִ�н��������Ҫ�õ���������
 * ���ʹ��ǰ���ַ�ʽ�������̱߳�Ȼ���޷�������ҵ��ģ���˿���ʹ�õ����ַ�ʽ�������̣߳�FutureTask��ʽ��ʵ��Callable�ӿڡ�(JDK8������)��
 * 
 * ȱ�㣺
 * 	ȡ����ǰ�߳��л�ȡ��һ���̵߳ķ���ֵ���ʱ����ǰ�̻߳��������������Ч�ʽϵ�
 * @author 13651
 *
 */
public class Multithreading04 {
	public static void main(String[] args) {
		// 1������δ�����������
		FutureTask<Object> task = new FutureTask<>(new MyCallable());
//		FutureTask<Object> task = new FutureTask<Object>(new Callable<Object>(){ // ʹ�������ڲ���ķ�ʽ
//
//			@Override
//			public Object call() throws Exception {
//				// TODO Auto-generated method stub
//				return null;
//			}
//			
//		});
		
		// �����̶߳���
		Thread t = new Thread(task);
		
		// �����߳�
		t.start();
		
		/**
		 * 
		 * ע�⣺������main()�����ڣ������������߳��У�ͨ��FutureTask�Ķ��� .get()�������Ի�ȡcall()�����ķ���ֵ;
		 * 
		 * ���get()������ִ�лᵼ�µ�ǰ�߳�(�����̣߳�main()����)������
		 * 	��Ϊcall()�����з���ֵ����get()�������ڵ�ǰ�߳�(���̣߳�main()����)�ڻ�ȡ��һ���̵߳ķ���ֵ�����Ե�ǰ�߳�(���̣߳�main()����)Ҫ�ȴ���һ���̵߳�call()����ִ�����(call()�����൱��run()���������ȴ���һ���߳�ִ����ϣ�����)
		 */
		Object obj = null;
		try {
			obj = task.get(); // ��ȡ�̵߳ķ���ֵ���
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("�õ����̷߳���ֵ�����");
		
	}
}

// 
class MyCallable implements Callable<Object> {

	@Override
	public Object call() throws Exception { // �൱��run()������ֻ����call()�����з���ֵ
		// ����д�߳�ִ�е�������룬ִ�����֮����ܻ��ȡһ�������Ϊ����ֵ
		System.out.println("call start");
		Thread.sleep(1000 * 3); // ˯��3�룬ģ��ִ��
		System.out.println("call end");
		int a = 100;
		int b = 200;
		return a + b; // �Զ�װ�����
	}
	
}
