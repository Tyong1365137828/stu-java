package edu.hebeu.command.command.tv;

import edu.hebeu.command.command.MyCommand;
import edu.hebeu.command.receiver.TVReceiver;

/**
 * 电视机打开命令
 * @author 13651
 *
 */
public class TVOnCommand implements MyCommand {
	
	private TVReceiver receiver;
	
	public TVOnCommand(TVReceiver receiver) {
		this.receiver = receiver;
	}

	/**
	 * 该命令对应的操作
	 */
	@Override
	public void execute() {
		receiver.on();
	}

	/**
	 * 该命令对应的撤销操作
	 */
	@Override
	public void undo() {
		receiver.off();
	}

}
