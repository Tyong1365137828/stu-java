package edu.hebeu.command.invoker;

import edu.hebeu.command.command.MyCommand;
import edu.hebeu.command.command.nullcommand.NullCommand;

/**
 * ������൱�� ���������
 * @author 13651
 *
 */
public class RemoteControllerInvoker {
	
	/**
	 * ��Ÿ��������Ŀ������ÿ����������Ӧһ������ť
	 */
	private MyCommand[] onButtons;
	
	/**
	 * ��Ÿ��������Ĺ������ÿ����������Ӧһ���ذ�ť
	 */
	private MyCommand[] offButtons;
	
	/**
	 * ����������һ��ִ�е������ʵ��ִ�г���������
	 */
	private MyCommand undoButton;
	
	/**
	 * ������ɶ԰�ť�ĳ�ʼ��
	 */
	public RemoteControllerInvoker() {
		
		// ������ť�ĵ�������Ϊ5��
		onButtons = new MyCommand[5];
		// ���ذ�ť�ĵ�������Ϊ5��
		offButtons = new MyCommand[5];
		
		// ��ʼ�����еİ�ťΪNullCommand���ͣ���Ĭ�ϲ�ִ���κβ���
		for(int i = 0; i < 5; i++) {
			onButtons[i] = new NullCommand();
			offButtons[i] = new NullCommand();
		}
		
	}
	
	/**
	 * �÷���������������
	 * @param index �ĸ�λ��
	 * @param onCommand ��������
	 * @param offCommand �ص�����
	 */
	public void setCommand(int index, MyCommand onCommand, MyCommand offCommand) {
		onButtons[index] = onCommand;
		offButtons[index] = offCommand;
	}
	
	/**
	 * ����������on���͵İ�ť
	 * @param index �ĸ�λ�õİ�ť
	 */
	public void onButtonPush(int index) {
		onButtons[index].execute();
		undoButton = onButtons[index]; // ��ס��εĲ���
	}
	
	/**
	 * ����������off���͵İ�ť
	 * @param index �ĸ�λ�õİ�ť
	 */
	public void offButtonPush(int index) {
		offButtons[index].execute();
		undoButton = offButtons[index]; // ��ס��εĲ���
	}
	
	/**
	 * ������������ť
	 */
	public void undoButtonPush() {
		undoButton.undo();
	}
	
}
