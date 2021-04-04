package edu.hebeu.aboutpath;

import java.util.ResourceBundle;

/**
 * ������ӽ���Sun��˾�ṩ��ResourceBundle��Դ������ʹ��
 * 	ResourceBundle��
 * 		��java.util���£�
 * 		ʹ�����ַ�ʽ��ȡ��Դʱ��Ҫ��:
 * 			1������ļ���������properties��β�ģ�
 * 			2������ļ���������·����(src��)��
 * 			3������xxx.properties�ļ�ʱ��д·��ֻ��д�� xxx����׺ properties����д��
 * 
 * @author 13651
 *
 */
public class ResourceBundleStu {
	public static void main(String[] args) {
		ResourceBundle bundle = ResourceBundle.getBundle("info\\classInfo"); // ע��д���ļ������־����ˣ�����д��׺
		
		String classInfoOfClassName = bundle.getString("className"); // ͨ��properties�ļ��� = ��ߵ�����ֵ(key)����ȡ = �ұߵ�����ֵ(value)
		System.out.println(classInfoOfClassName);
		
	}
}
