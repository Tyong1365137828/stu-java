package edu.hebeu.command.command.nullcommand;

import edu.hebeu.command.command.MyCommand;

/**
 * 这个命令是一个空命令，其不论是执行命令操作的execute()方法，还是撤销命令操作的undo()方法都是默
 * 认实现，不会执行任何相关的操作，因此用来初始化命令，以此来省掉空判断；
 * @author 13651
 *
 */
public class NullCommand implements MyCommand{

	@Override
	public void execute() {
	}

	@Override
	public void undo() {
	}

}
