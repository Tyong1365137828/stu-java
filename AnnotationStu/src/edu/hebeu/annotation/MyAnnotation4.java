package edu.hebeu.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ������ӹ�ע��ʹ�÷������ʹ��
 * @author 13651
 *
 */

@Target(value = {ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME) // ��ʶ��ע�����ͨ��������Ƶ���
public @interface MyAnnotation4 {
	String address() default "����ʡ";
	String describe();
}
