package edu.hebeu.entity;

/**
 * ������ӹ����Է��䷽��ʹ��
 * @author 13651
 *
 */
public class MethodEntity {
	
	/**
	 * ��¼
	 * @param username �û���
	 * @param password ����
	 * @return ��¼�ɹ� ? true : false
	 */
	public boolean login(String username, String password) {
		if("1365137828".equals(username) && "0727316052".equals(password)) return true;
		/**����ִ�е��ˣ�˵���û��������벻��ȷ������¼ʧ��*/
		return false;
	}
	
	/**
	 * �˳�����
	 */
	public void exit() {
		System.out.println("�ɹ��˳�!");
	}
	
}
