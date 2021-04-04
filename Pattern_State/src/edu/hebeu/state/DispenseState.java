package edu.hebeu.state;

import edu.hebeu.RaffleActivity;

/**
 * �����Ƿ��Ž�Ʒ��״̬
 * @author 13651
 *
 */
public class DispenseState extends State{
	
	private RaffleActivity activity;
	
	public DispenseState(RaffleActivity activity) {
		this.activity = activity;
	}

	/**
	 * ���Ž�Ʒ״̬�£��ǲ��ܿ۳����ֵ�
	 */
	@Override
	public void deductIntegral() {
		System.out.println("���Ž�Ʒ�У����ܿ۳�����");
	}

	/**
	 * ���Ž�Ʒ״̬�£��ǲ��ܳ齱��
	 */
	@Override
	public boolean raffle() {
		System.out.println("���Ž�Ʒ�У����ܽ��г齱");
		return false;
	}

	/**
	 * ���Ž�Ʒ״̬�£����Խ��з��Ž�Ʒ
	 */
	@Override
	public void dispensePrize() {
		if(activity.getPrizeCount() <= 1) { // �������1����1�����½�Ʒ
			System.out.println("��Ʒ���·�");
			activity.setState(activity.getDispenseOutState()); // ��״̬�ĳɽ�Ʒ�������״̬�����ܼ����齱
			return;
		}
		// ����ִ�е��ˣ�˵����Ʒ��ʣ��ֹһ��(2����2������)
		System.out.println("��Ʒ���·�");
		activity.setState(activity.getNoRafflleState()); // ��״̬�޸�Ϊ�ʼ״̬(���ܳ齱״̬)
	}
	
}
