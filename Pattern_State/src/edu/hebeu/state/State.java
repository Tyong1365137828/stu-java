package edu.hebeu.state;

/**
 * 抽象的状态基类
 * @author 13651
 *
 */
public abstract class State {
	
	/**
	 * 扣除积分50
	 */
	public abstract void deductIntegral();
	
	/**
	 * 判断是否抽中奖品
	 * @return
	 */
	public abstract boolean raffle();
	
	/**
	 * 发放奖品
	 */
	public abstract void dispensePrize();
	
}
