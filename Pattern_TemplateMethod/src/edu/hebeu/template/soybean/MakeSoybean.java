package edu.hebeu.template.soybean;

/**
 * 模板类
 * @author 13651
 *
 */
public abstract class MakeSoybean {
	
	/**
	 * 这个方法用来做模板方法(添加关键字final，防止子类重写该方法)，用来制作豆浆
	 */
	public final void make() {
		select();
		if(isAdd()) {
			add();
		}
		soak();
		beat();
	}
	
	/**
	 * 选择黄豆
	 */
	private void select() {
		System.out.println("选取适量的黄豆");
	}
	
	/**
	 * 添加配料的方法，交由子类(不同口味的豆浆具体实现)
	 */
	protected abstract void add();
	
	private void soak() {
		System.out.println("将材料浸泡");
	}
	
	private void beat() {
		System.out.println("将材料研磨，制出豆浆");
	}
	
	/**
	 * 这个方法默认实现，具体返回值交由子类决定，充当"钩子"，即这个方法是"钩子方法"
	 * 
	 * 决定是否添加配料(即是否执行add()方法)
	 * @return
	 */
	protected boolean isAdd() {
		return true;
	}
	
}
