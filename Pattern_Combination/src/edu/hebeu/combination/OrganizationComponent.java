package edu.hebeu.combination;

/*
 *  ������൱��Component�࣬������źͳ�ȡҶ�ӽڵ�ͷ�Ҷ�ӽڵ�Ĺ���
 */
public abstract class OrganizationComponent {
	
	private String name; // ����
	private String desc; // ����
	
	public OrganizationComponent(String name, String desc) {
		this.name = name;
		this.desc = desc;
	}

	protected void add(OrganizationComponent organizationComponent) {
		/*Ĭ��ʵ�ָ÷�������ΪDepartment���ǲ�����add()�����ģ��������������Ĭ��ʵ�֣�����Ҫ��
		 * �������������ȥ���£�����Ҫ�ľͲ��ù�ע
		 */
		new UnsupportedOperationException(); // �׳�һ����֧�ֲ������쳣
	}
	
	protected void remove(OrganizationComponent organizationComponent) {
		/*Ĭ��ʵ�ָ÷�������ΪDepartment���ǲ�����remove()�����ģ��������������Ĭ��ʵ�֣�����Ҫ
		 * �õ������������ȥ���£�����Ҫ�ľͲ��ù�ע
		 */
		new UnsupportedOperationException(); // �׳�һ����֧�ֲ������쳣		
	}
	
	/**
	 * ������������ɳ���ģ���Ϊ���е��඼���������ȥ��ӡ��Ϣ�����Խ������������Ϊ����ģ���
	 * ��Ӧ������ȥʵ�ָ÷���
	 */
	protected abstract void print();
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
