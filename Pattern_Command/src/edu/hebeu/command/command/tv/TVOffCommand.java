package edu.hebeu.command.command.tv;

import edu.hebeu.command.command.MyCommand;
import edu.hebeu.command.receiver.TVReceiver;

/**
 * 电视机关闭命令
 * @author 13651
 *
 */
public class TVOffCommand implements MyCommand {
	
	private TVReceiver receiver;
	
	public TVOffCommand(TVReceiver receiver) {
		this.receiver = receiver;
	}

	/**
	 * 该命令对应的操作
	 */
	@Override
	public void execute() {
		receiver.off();
	}

	/**
	 * 该命令对应的撤销操作
	 */
	@Override
	public void undo() {
		receiver.on();
	}
}
