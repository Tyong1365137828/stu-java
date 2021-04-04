package edu.hebeu.state;

import edu.hebeu.RaffleActivity;

/**
 * �����ǲ��ܳ齱��״̬
 * @author 13651
 *
 */
public class NoRaffleState extends State{
	
	/**
	 * ��ʼ���ó���ʱ��ΪĬ�ϵ��ǲ��ɳ齱��״̬(NoRaffleState)�����۳����ֺ���ɿɳ齱��״̬������Ҫʹ�ø����͵��øı�
	 */
	private RaffleActivity activity;
	
	public NoRaffleState(RaffleActivity activity) {
		this.activity = activity;
	}

	/**
	 * ���ܳ齱��״̬�£��ǿ��Կ۳����ֵģ�֮����ܱ�ɿɳ齱��״̬
	 */
	@Override
	public void deductIntegral() {
		System.out.println("�ѿ۳�����50�������Գ齱��");
		activity.setState(activity.getCanRaffleState()); // ��ʱ��״̬��ɿɳ齱��״̬
	}

	/**
	 * ���ܳ齱��״̬�£��ǲ��ܳ齱�������Ƿ��н���
	 */
	@Override
	public boolean raffle() {
		System.out.println("δ�۳����֣����ܳ齱��");
		return false;
	}

	/**
	 * ���ܳ齱��״̬�£��ǲ��ܷ��Ž�Ʒ��
	 */
	@Override
	public void dispensePrize() {
		System.out.println("δ�۳����֣����ܷ��Ž�Ʒ��");
	}
	
}
