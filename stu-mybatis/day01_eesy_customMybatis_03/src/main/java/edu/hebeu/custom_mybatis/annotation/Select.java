package edu.hebeu.custom_mybatis.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) // 使此注解被保存在class文件中，并且能够被反射机制读取到
@Target(ElementType.METHOD) // 使此注解只能出现在方法上
public @interface Select {

    /**
     * 这个value表示一条SQL语句
     * @return 一条SQL语句
     */
    String value();
}
