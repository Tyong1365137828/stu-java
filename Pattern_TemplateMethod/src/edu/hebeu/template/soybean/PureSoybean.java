package edu.hebeu.template.soybean;

public class PureSoybean extends MakeSoybean { // 制作纯豆浆

	@Override
	protected void add() { // 因为纯豆浆不需要添加任何配料，所以将add()方法空实现
//		new UnsupportedOperationException(); // 抛出一个不支持操作的异常
	}

	@Override
	protected boolean isAdd() {
		return false;
	}
	
}
