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
		// ��0�������İ�ťλ�����õ�ƵĿ���
		remoteControllerInvoker.setCommand(0, 
				new LightOnCommand(new LightReceiver()), 
				new LightOffCommand(new LightReceiver()));
		// ��1�������İ�ťλ�����õ��ӻ��Ŀ���
		remoteControllerInvoker.setCommand(1, 
				new TVOnCommand(new TVReceiver()), 
				new TVOffCommand(new TVReceiver()));
		
		System.out.println("--------------------�򿪵������---------------------");
		remoteControllerInvoker.onButtonPush(0);
		System.out.println("--------------------��������---------------------");
		remoteControllerInvoker.undoButtonPush();
		System.out.println("--------------------�򿪵������---------------------");
		remoteControllerInvoker.onButtonPush(0);
		System.out.println("--------------------�رյ������---------------------");
		remoteControllerInvoker.offButtonPush(0);
		System.out.println("--------------------�򿪵�������---------------------");
		remoteControllerInvoker.onButtonPush(1);
	}
}
