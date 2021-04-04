package edu.hebeu.project;

import java.lang.reflect.Field;

/**
 * 这个类用来测试
 * @author 13651
 *
 */
public class Test {
	public static void main(String[] args) {
		Class cClass = null;
		boolean isLegal = false; // 类是否合法的标志，默认为false，即不合法
		
		try {
			cClass =  Class.forName("edu.hebeu.project.MyClass");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(cClass.isAnnotationPresent(MustHasIdPropertityAnnotation.class)) { // 如果MyClass类上存在MustHasIdPropertityAnnotation注解
//			MustHasIdPropertityAnnotation mustHasIdPropertityAnnotation = (MustHasIdPropertityAnnotation) cClass.getAnnotation(MustHasIdPropertityAnnotation.class); // 获取类上的MustHasIdPropertityAnnotation对象
			
			Field[] fields = cClass.getDeclaredFields(); // 获取MyClass类的全部属性
			for(Field f : fields) {
				if("id".equals(f.getName()) && "int".equals(f.getType().getSimpleName())) { // 如果某个属性的名字是id，且该类型是int
					isLegal = true; // 将类的是否合法标志更改为true
					break;
				}
			}
			
			if(!isLegal) { // 如果这个类合法的标志为false，即类不合法(类中没有int类型的id属性)
				throw new MustHasIdPropertityAnnotationExpection();
			}
		}
		
		
		
	}
}
