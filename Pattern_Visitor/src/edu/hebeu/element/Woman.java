package edu.hebeu.element;

import edu.hebeu.visitor.Action;

/**
 * ����ʹ����˫���ɣ��������ڿͻ��˳����У�������״̬��Ϊ��������Woman��(��һ�η���)��
 * Ȼ����Woman���������Ϊ������ �����巽���� ��getWomanResult()������ͬʱ���Լ�(this)��Ϊ����
 * ����(�ڶ��η���)
 * 
 * @author 13651
 *
 */
public class Woman extends Person{

	@Override
	public void accept(Action action) {
		action.getWomanResult(this);
	}

}
