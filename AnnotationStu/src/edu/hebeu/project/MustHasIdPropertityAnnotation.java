package edu.hebeu.project;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ����������
 * 	һ��ע��� MustHasIdPropertityAnnotation��
 * �����ע��ֻ�ܳ��������ϣ��������������Ͼ�Ҫ������������ int���͵� ��Ϊid�����ԣ�
 * ���û�����id���ԣ��ͻ�������ʱ���쳣����֮����������ִ�У�
 * @author 13651
 *
 */

// ���ע��ֻ�ܳ���������
@Target(ElementType.TYPE)
// �����Բ��ԣ���ע����Ա�������ƶ�ȡ��
@Retention(RetentionPolicy.RUNTIME)
public @interface MustHasIdPropertityAnnotation {
	
}
