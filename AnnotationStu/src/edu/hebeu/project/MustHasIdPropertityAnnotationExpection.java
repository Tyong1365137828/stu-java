package edu.hebeu.project;

/**
 * MustHasIdPropertityAnnotationע����쳣��
 * @author 13651
 *
 */
public class MustHasIdPropertityAnnotationExpection extends RuntimeException {
	public MustHasIdPropertityAnnotationExpection() {
		System.err.println("��MustHasIdPropertityAnnotationע���ע�����쳣����Ҫһ��int���͵�id���ԣ�");
	}
	
	public MustHasIdPropertityAnnotationExpection(String s) {
		System.err.println("��MustHasIdPropertityAnnotationע���ע�����쳣����Ҫһ��int���͵�id���ԣ�");
		System.err.println("��ʾ��Ϣ��" + s);
	}
}
