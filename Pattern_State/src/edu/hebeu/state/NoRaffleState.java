package edu.hebeu.state;

import edu.hebeu.RaffleActivity;

/**
 * 该类是不能抽奖的状态
 * @author 13651
 *
 */
public class NoRaffleState extends State{
	
	/**
	 * 初始化该程序时因为默认的是不可抽奖的状态(NoRaffleState)，当扣除积分后会变成可抽奖的状态，所以要使用该类型调用改变
	 */
	private RaffleActivity activity;
	
	public NoRaffleState(RaffleActivity activity) {
		this.activity = activity;
	}

	/**
	 * 不能抽奖的状态下，是可以扣除积分的，之后才能变成可抽奖的状态
	 */
	@Override
	public void deductIntegral() {
		System.out.println("已扣除积分50，您可以抽奖了");
		activity.setState(activity.getCanRaffleState()); // 此时将状态变成可抽奖的状态
	}

	/**
	 * 不能抽奖的状态下，是不能抽奖来决定是否中奖的
	 */
	@Override
	public boolean raffle() {
		System.out.println("未扣除积分，不能抽奖！");
		return false;
	}

	/**
	 * 不能抽奖的状态下，是不能发放奖品的
	 */
	@Override
	public void dispensePrize() {
		System.out.println("未扣除积分，不能发放奖品！");
	}
	
}
