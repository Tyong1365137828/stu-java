package edu.hebeu.template.soybean;

public class PureSoybean extends MakeSoybean { // ����������

	@Override
	protected void add() { // ��Ϊ����������Ҫ����κ����ϣ����Խ�add()������ʵ��
//		new UnsupportedOperationException(); // �׳�һ����֧�ֲ������쳣
	}

	@Override
	protected boolean isAdd() {
		return false;
	}
	
}
