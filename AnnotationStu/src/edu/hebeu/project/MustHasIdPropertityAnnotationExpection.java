package edu.hebeu.project;

/**
 * MustHasIdPropertityAnnotation注解的异常类
 * @author 13651
 *
 */
public class MustHasIdPropertityAnnotationExpection extends RuntimeException {
	public MustHasIdPropertityAnnotationExpection() {
		System.err.println("被MustHasIdPropertityAnnotation注解标注的类异常，需要一个int类型的id属性！");
	}
	
	public MustHasIdPropertityAnnotationExpection(String s) {
		System.err.println("被MustHasIdPropertityAnnotation注解标注的类异常，需要一个int类型的id属性！");
		System.err.println("提示信息：" + s);
	}
}
