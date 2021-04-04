package edu.hebeu.command.invoker;

import edu.hebeu.command.command.MyCommand;
import edu.hebeu.command.command.nullcommand.NullCommand;

/**
 * 这个类相当于 命令调用者
 * @author 13651
 *
 */
public class RemoteControllerInvoker {
	
	/**
	 * 存放各个电器的开命令，即每个电器个对应一个开按钮
	 */
	private MyCommand[] onButtons;
	
	/**
	 * 存放各个电器的关命令，即每个电器个对应一个关按钮
	 */
	private MyCommand[] offButtons;
	
	/**
	 * 用来存放最近一次执行的命令，以实现执行撤销的命令
	 */
	private MyCommand undoButton;
	
	/**
	 * 用来完成对按钮的初始化
	 */
	public RemoteControllerInvoker() {
		
		// 将开按钮的电器设置为5个
		onButtons = new MyCommand[5];
		// 将关按钮的电器设置为5个
		offButtons = new MyCommand[5];
		
		// 初始化所有的按钮为NullCommand类型，即默认不执行任何操作
		for(int i = 0; i < 5; i++) {
			onButtons[i] = new NullCommand();
			offButtons[i] = new NullCommand();
		}
		
	}
	
	/**
	 * 该方法用来设置命令
	 * @param index 哪个位置
	 * @param onCommand 开的命令
	 * @param offCommand 关的命令
	 */
	public void setCommand(int index, MyCommand onCommand, MyCommand offCommand) {
		onButtons[index] = onCommand;
		offButtons[index] = offCommand;
	}
	
	/**
	 * 如果点击的是on类型的按钮
	 * @param index 哪个位置的按钮
	 */
	public void onButtonPush(int index) {
		onButtons[index].execute();
		undoButton = onButtons[index]; // 记住这次的操作
	}
	
	/**
	 * 如果点击的是off类型的按钮
	 * @param index 哪个位置的按钮
	 */
	public void offButtonPush(int index) {
		offButtons[index].execute();
		undoButton = offButtons[index]; // 记住这次的操作
	}
	
	/**
	 * 如果点击撤销按钮
	 */
	public void undoButtonPush() {
		undoButton.undo();
	}
	
}
