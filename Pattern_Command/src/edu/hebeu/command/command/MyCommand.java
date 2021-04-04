package edu.hebeu.command.command;

public interface MyCommand {
	
	void execute(); // 执行操作的命令
	
	void undo(); // 撤销操作的命令
}
