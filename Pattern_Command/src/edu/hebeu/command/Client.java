package edu.hebeu.command;

import edu.hebeu.command.command.light.LightOffCommand;
import edu.hebeu.command.command.light.LightOnCommand;
import edu.hebeu.command.command.tv.TVOffCommand;
import edu.hebeu.command.command.tv.TVOnCommand;
import edu.hebeu.command.invoker.RemoteControllerInvoker;
import edu.hebeu.command.receiver.LightReceiver;
import edu.hebeu.command.receiver.TVReceiver;

public class Client {
	public static void main(String[] args) {
		RemoteControllerInvoker remoteControllerInvoker = new RemoteControllerInvoker();
		// 给0号索引的按钮位置设置电灯的开关
		remoteControllerInvoker.setCommand(0, 
				new LightOnCommand(new LightReceiver()), 
				new LightOffCommand(new LightReceiver()));
		// 给1号索引的按钮位置设置电视机的开关
		remoteControllerInvoker.setCommand(1, 
				new TVOnCommand(new TVReceiver()), 
				new TVOffCommand(new TVReceiver()));
		
		System.out.println("--------------------打开电灯命令---------------------");
		remoteControllerInvoker.onButtonPush(0);
		System.out.println("--------------------撤回命令---------------------");
		remoteControllerInvoker.undoButtonPush();
		System.out.println("--------------------打开电灯命令---------------------");
		remoteControllerInvoker.onButtonPush(0);
		System.out.println("--------------------关闭电灯命令---------------------");
		remoteControllerInvoker.offButtonPush(0);
		System.out.println("--------------------打开电视命令---------------------");
		remoteControllerInvoker.onButtonPush(1);
	}
}
