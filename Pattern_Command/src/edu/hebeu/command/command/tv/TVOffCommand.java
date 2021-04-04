package edu.hebeu.command.command.tv;

import edu.hebeu.command.command.MyCommand;
import edu.hebeu.command.receiver.TVReceiver;

/**
 * ���ӻ��ر�����
 * @author 13651
 *
 */
public class TVOffCommand implements MyCommand {
	
	private TVReceiver receiver;
	
	public TVOffCommand(TVReceiver receiver) {
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
