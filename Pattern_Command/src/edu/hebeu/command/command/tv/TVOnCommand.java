package edu.hebeu.command.command.tv;

import edu.hebeu.command.command.MyCommand;
import edu.hebeu.command.receiver.TVReceiver;

/**
 * ���ӻ�������
 * @author 13651
 *
 */
public class TVOnCommand implements MyCommand {
	
	private TVReceiver receiver;
	
	public TVOnCommand(TVReceiver receiver) {
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
