package edu.hebeu.command.command.light;

import edu.hebeu.command.command.MyCommand;
import edu.hebeu.command.receiver.LightReceiver;

/**
 * 电灯关闭的命令
 * @author 13651
 *
 */
public class LightOffCommand implements MyCommand {
	
	private LightReceiver receiver;
	
	public LightOffCommand(LightReceiver receiver) {
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
