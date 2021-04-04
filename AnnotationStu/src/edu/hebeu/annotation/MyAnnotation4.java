package edu.hebeu.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 这个例子供注解使用反射机制使用
 * @author 13651
 *
 */

@Target(value = {ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME) // 标识该注解可以通过反射机制调用
public @interface MyAnnotation4 {
	String address() default "江苏省";
	String describe();
}
