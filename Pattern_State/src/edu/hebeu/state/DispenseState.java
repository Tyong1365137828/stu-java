package edu.hebeu.state;

import edu.hebeu.RaffleActivity;

/**
 * 该类是发放奖品的状态
 * @author 13651
 *
 */
public class DispenseState extends State{
	
	private RaffleActivity activity;
	
	public DispenseState(RaffleActivity activity) {
		this.activity = activity;
	}

	/**
	 * 发放奖品状态下，是不能扣除积分的
	 */
	@Override
	public void deductIntegral() {
		System.out.println("发放奖品中，不能扣除积分");
	}

	/**
	 * 发放奖品状态下，是不能抽奖的
	 */
	@Override
	public boolean raffle() {
		System.out.println("发放奖品中，不能进行抽奖");
		return false;
	}

	/**
	 * 发放奖品状态下，可以进行发放奖品
	 */
	@Override
	public void dispensePrize() {
		if(activity.getPrizeCount() <= 1) { // 如果还有1个或1个以下奖品
			System.out.println("奖品已下发");
			activity.setState(activity.getDispenseOutState()); // 将状态改成奖品发送完的状态，不能继续抽奖
			return;
		}
		// 程序执行到此，说明奖品还剩不止一个(2个或2个以上)
		System.out.println("奖品已下发");
		activity.setState(activity.getNoRafflleState()); // 将状态修改为最开始状态(不能抽奖状态)
	}
	
}
