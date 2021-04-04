package edu.hebeu.template.soybean;

/**
 * ģ����
 * @author 13651
 *
 */
public abstract class MakeSoybean {
	
	/**
	 * �������������ģ�巽��(��ӹؼ���final����ֹ������д�÷���)��������������
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
	 * ѡ��ƶ�
	 */
	private void select() {
		System.out.println("ѡȡ�����Ļƶ�");
	}
	
	/**
	 * ������ϵķ�������������(��ͬ��ζ�Ķ�������ʵ��)
	 */
	protected abstract void add();
	
	private void soak() {
		System.out.println("�����Ͻ���");
	}
	
	private void beat() {
		System.out.println("��������ĥ���Ƴ�����");
	}
	
	/**
	 * �������Ĭ��ʵ�֣����巵��ֵ��������������䵱"����"�������������"���ӷ���"
	 * 
	 * �����Ƿ��������(���Ƿ�ִ��add()����)
	 * @return
	 */
	protected boolean isAdd() {
		return true;
	}
	
}
