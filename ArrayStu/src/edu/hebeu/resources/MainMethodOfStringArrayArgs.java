package edu.hebeu.resources;

/**
 * �������չʾmain������ String[] args ������ʹ��
 * @author tyong
 *
 */
public class MainMethodOfStringArrayArgs {
	public static void main(String[] args) {
		if(args.length != 2) {
			System.err.println("�������û��������룬�磺root tyong");
			return;
		}
		if(args[0].equals("root") & args[1].equals("tyong")) System.out.println("�����֤�ɹ�����ӭ����username = " + args[0] + ", password = " + args[1]);
		else System.out.println("�����֤ʧ�ܣ�");
	}
}
