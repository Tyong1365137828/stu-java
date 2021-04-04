package edu.hebeu.staticproxy;

/**
 * ���������ʾ��̬����ģʽ
 * @author 13651
 *
 */
public class TeacherProxy implements ITeacherDao{
	
	private ITeacherDao target; // �������Ŀ�����
	
	public TeacherProxy(ITeacherDao target) {
		this.target = target;
	}

	@Override
	public String teacher() {
		System.out.println("��̬����ʼ��...");
		
		String s = target.teacher(); // �������������ķ���
		
		System.out.println("��̬�������");
		return s;
	}
}
