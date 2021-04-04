package edu.hebeu.project;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 假设有需求：
 * 	一个注解叫 MustHasIdPropertityAnnotation，
 * 当这个注解只能出现在类上，但它出现在类上就要求这个类必须有 int类型的 名为id的属性，
 * 如果没有这个id属性，就会在运行时报异常；反之，程序正常执行；
 * @author 13651
 *
 */

// 这个注解只能出现在类上
@Target(ElementType.TYPE)
// 保持性策略，该注解可以被反射机制读取到
@Retention(RetentionPolicy.RUNTIME)
public @interface MustHasIdPropertityAnnotation {
	
}
