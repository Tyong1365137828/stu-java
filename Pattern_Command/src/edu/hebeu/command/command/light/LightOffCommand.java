package edu.hebeu.command.command.light;

import edu.hebeu.command.command.MyCommand;
import edu.hebeu.command.receiver.LightReceiver;

/**
 * ��ƹرյ�����
 * @author 13651
 *
 */
public class LightOffCommand implements MyCommand {
	
	private LightReceiver receiver;
	
	public LightOffCommand(LightReceiver receiver) {
		this.receiver = receiver;
	}

	/**
	 * �������Ӧ�Ĳ���
	 */
	@Override
	public void execute() {
		receiver.off();
	}

	/**
	 * �������Ӧ�ĳ�������
	 */
	@Override
	public void undo() {
		receiver.on();
	}

}
