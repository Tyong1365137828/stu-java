package edu.hebeu.command.command.light;

import edu.hebeu.command.command.MyCommand;
import edu.hebeu.command.receiver.LightReceiver;

/**
 * ��ƴ򿪵�����
 * @author 13651
 *
 */
public class LightOnCommand implements MyCommand{
	
	private LightReceiver receiver;
	
	public LightOnCommand(LightReceiver receiver) {
		this.receiver = receiver;
	}

	/**
	 * �������Ӧ�Ĳ���
	 */
	@Override
	public void execute() {
		receiver.on();
	}

	/**
	 * �������Ӧ�ĳ�������
	 */
	@Override
	public void undo() {
		receiver.off();
	}
	
	
}
