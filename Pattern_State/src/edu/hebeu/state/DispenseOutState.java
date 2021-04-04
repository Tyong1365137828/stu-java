package edu.hebeu.state;

import edu.hebeu.RaffleActivity;

/**
 * 该类是奖品发送完的状态，即活动结束，此时不会进行扣除积分等一系列活动
 * @author 13651
 *
 */
public class DispenseOutState extends State{

	 RaffleActivity activity;
	
	public DispenseOutState(RaffleActivity activity) {
		this.activity = activity;
	}

	/**
	 * 奖品发送完，是不能扣除积分的
	 */
	@Override
	public void deductIntegral() {
		System.out.println("没有奖品了，欢迎下次参加");
	}

	@Override
	public boolean raffle() {
		System.out.println("没有奖品了，欢迎下次参加");
		return false;
	}

	@Override
	public void dispensePrize() {
		System.out.println("没有奖品了，欢迎下次参加");
	}

}
