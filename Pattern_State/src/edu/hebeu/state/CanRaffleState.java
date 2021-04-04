package edu.hebeu.state;

import java.util.Random;

import edu.hebeu.RaffleActivity;

/**
 * 该类是能够抽奖的状态
 * @author 13651
 *
 */
public class CanRaffleState extends State{
	
	private RaffleActivity activity;
	
	public CanRaffleState(RaffleActivity activity) {
		this.activity = activity;
	}

	/**
	 * 能够抽奖的状态下，是不能重复扣除积分的
	 */
	@Override
	public void deductIntegral() {
		System.out.println("不能重复扣取积分，请先抽奖！");
	}

	/**
	 * 能够抽奖的状态下，是可以进行抽奖以决定能否中奖
	 */
	@Override
	public boolean raffle() {
		System.out.println("正在抽奖...");
		Random r = new Random();
		int a = r.nextInt(10); // 抽取一个从[0, 10)范围内的随机整数
		if(a == 0) { // 如果随机数是0(十分之一的概率)，表示中奖！
			System.out.println("恭喜您已被奖品砸中！！！");
			activity.setState(activity.getDispenseState());
			return true;
		}
		System.out.println("很遗憾没有抽中~~~");
		activity.setState(activity.getNoRafflleState());
		return false;
	}

	/**
	 * 能够抽奖的状态下，是不能发放奖品的
	 */
	@Override
	public void dispensePrize() {
		System.out.println("您还未抽奖，没有奖品可以发放");
	}
	
}
