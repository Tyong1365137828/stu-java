package edu.hebeu.command.command.nullcommand;

import edu.hebeu.command.command.MyCommand;

/**
 * ���������һ��������䲻����ִ�����������execute()���������ǳ������������undo()��������Ĭ
 * ��ʵ�֣�����ִ���κ���صĲ��������������ʼ������Դ���ʡ�����жϣ�
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
