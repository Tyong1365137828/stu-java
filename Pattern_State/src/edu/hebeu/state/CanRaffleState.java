package edu.hebeu.state;

import java.util.Random;

import edu.hebeu.RaffleActivity;

/**
 * �������ܹ��齱��״̬
 * @author 13651
 *
 */
public class CanRaffleState extends State{
	
	private RaffleActivity activity;
	
	public CanRaffleState(RaffleActivity activity) {
		this.activity = activity;
	}

	/**
	 * �ܹ��齱��״̬�£��ǲ����ظ��۳����ֵ�
	 */
	@Override
	public void deductIntegral() {
		System.out.println("�����ظ���ȡ���֣����ȳ齱��");
	}

	/**
	 * �ܹ��齱��״̬�£��ǿ��Խ��г齱�Ծ����ܷ��н�
	 */
	@Override
	public boolean raffle() {
		System.out.println("���ڳ齱...");
		Random r = new Random();
		int a = r.nextInt(10); // ��ȡһ����[0, 10)��Χ�ڵ��������
		if(a == 0) { // ����������0(ʮ��֮һ�ĸ���)����ʾ�н���
			System.out.println("��ϲ���ѱ���Ʒ���У�����");
			activity.setState(activity.getDispenseState());
			return true;
		}
		System.out.println("���ź�û�г���~~~");
		activity.setState(activity.getNoRafflleState());
		return false;
	}

	/**
	 * �ܹ��齱��״̬�£��ǲ��ܷ��Ž�Ʒ��
	 */
	@Override
	public void dispensePrize() {
		System.out.println("����δ�齱��û�н�Ʒ���Է���");
	}
	
}
