package edu.hebeu.timer;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 这个例子学习java.util.Timer类
 * 	构造方法：
 * 		Timer(); // 构造一个定时器
 * 		Timer(boolean isDaemon); // 创建一个定时器，其相关的线程是否作为守护线程运行，true表示后台线程(守护线程)，false表示用户线程
 * 		Timer(String name); // 创建一个定时器，其相关的线程具有指定的名称
 * 		Timer(String name, boolean isDaemon); // 创建一个定时器，其相关的线程具有指定的名称，并且其相关的线程是否作为守护线程运行，true表示后台线程(守护线程)，false表示用户线程
 * 
 * 	常用方法：
 * 		schedule(TimerTask task, Date firstTime, long millisecond); // 给定时器对象委派任务，参数2、第一次执行时间；参数3、固定延迟多久执行，单位毫秒；
 * 
 * @author 13651
 *
 */
public class TimerStu {
	public static void main(String[] args) {
		
		PrintStream ps = null;
		try {
			ps = new PrintStream(new FileOutputStream("信息\\定时器\\日志信息", true));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 将此输出流的方向改变至 信息\\定时器\\日志信息 文件，不在指向控制台
		System.setOut(ps); // 通过上面的对象修改输出方向，将此输出流的方向改变至 信息\\定时器\\日志信息 文件，不在指向控制台
		
		
//		Timer timer = new Timer(); // 创建定时器对象
//		Timer timer = new Timer("任务定时器"); // 创建名为 "任务定时器" 的定时器对象
//		Timer timer = new Timer(true); // 创建定时器对象(守护线程的方式)，此时为了保证这个守护线程不结束，要使用户线程不结束
		Timer timer = new Timer("任务定时器", true); // 创建名为 "任务定时器" 的定时器对象(守护线程的方式)，此时为了保证这个守护线程不结束，要使用户线程不结束
		
		/**任务第一次的执行时间*/
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
		Date firstTime = new Date(); // 声明任务第一次的执行时间
		try {
			firstTime = sdf.parse("2021-02-04 08:50:30 000");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// 给定时器委托任务
//		timer.schedule(new LogTask(), firstTime, 1000 * 10); // 委托任务为LogTask类的对象，首次从firstTime执行，每10秒执行一次委托事件
		timer.schedule(new TimerTask(){ // 使用匿名内部类的方式创建要委托的任务进行委托
			@Override
			public void run() {
				// 这里编写需要执行的任务
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
				String nowDate = sdf.format(new Date()); // 获取当前时间
				
				System.out.println("当前时间:" + nowDate + ";LogTask执行《" + Thread.currentThread().getName() + "》，数据备份中...");
			}
			
		}, firstTime, 1000 * 60 * 2); // 委托任务为LogTask类的对象，首次从firstTime执行，每2分钟执行一次委托事件
		
		
		for(int i = 0; i < 10000; i++) {
			System.out.println("main主栈<用户线程>，《" + Thread.currentThread().getName() + "》运行中，运行次数：" + (i+1) );
			try {
				Thread.sleep(1000); // 睡眠1秒
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}

/**
 * 定时器的任务类，TimerTask是抽象类，不能new，所有要创建一个定时器任务类继承它
 * @author 13651
 *
 */
class LogTask extends TimerTask {

	@Override
	public void run() {
		// 这里编写需要执行的任务
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
		String nowDate = sdf.format(new Date()); // 获取当前时间
		
		System.out.println("当前时间:" + nowDate + ";LogTask执行《" + Thread.currentThread().getName() + "》，数据备份中...");
	}
	
}
