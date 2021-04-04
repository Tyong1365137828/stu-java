package edu.hebeu.combination;

public class Client {
	public static void main(String[] args) {
		
		// ͨ��OrganizationComponent����һ����ѧ
		OrganizationComponent university = new University("�ӱ����̴�ѧ", "λ�ںӱ�������һ����ѧ");
		
		// ͨ��OrganizationComponent����һ��Ժϵ
		OrganizationComponent softWareCollege = new College("�ŵ�ѧԺ", "��Ϣ��ѧ���������ѧԺ");
		OrganizationComponent materialCollege = new College("����ѧԺ", "����");
		
		// ��Ժϵ�����ѧԺ
		university.add(softWareCollege);
		university.add(materialCollege);
		
		// ��Ժϵ���רҵ
		softWareCollege.add(new Department("�������", "����Ŀ�������"));
		softWareCollege.add(new Department("�������ѧ�뼼��", "�����רҵ"));
		
		materialCollege.add(new Department("ұ�𹤳�", "������ұ��"));
		materialCollege.add(new Department("����", "���̿��ƹ���"));
		
//		softWareCollege.print(); // ��ӡרҵ����Ϣ
		university.print(); // ��ӡѧУ����Ϣ
		
		
		
	}
}
