package edu.hebeu.state;

import edu.hebeu.RaffleActivity;

/**
 * �����ǽ�Ʒ�������״̬�������������ʱ������п۳����ֵ�һϵ�л
 * @author 13651
 *
 */
public class DispenseOutState extends State{

	 RaffleActivity activity;
	
	public DispenseOutState(RaffleActivity activity) {
		this.activity = activity;
	}

	/**
	 * ��Ʒ�����꣬�ǲ��ܿ۳����ֵ�
	 */
	@Override
	public void deductIntegral() {
		System.out.println("û�н�Ʒ�ˣ���ӭ�´βμ�");
	}

	@Override
	public boolean raffle() {
		System.out.println("û�н�Ʒ�ˣ���ӭ�´βμ�");
		return false;
	}

	@Override
	public void dispensePrize() {
		System.out.println("û�н�Ʒ�ˣ���ӭ�´βμ�");
	}

}
