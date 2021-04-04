package edu.hebeu.project;

import java.lang.reflect.Field;

/**
 * �������������
 * @author 13651
 *
 */
public class Test {
	public static void main(String[] args) {
		Class cClass = null;
		boolean isLegal = false; // ���Ƿ�Ϸ��ı�־��Ĭ��Ϊfalse�������Ϸ�
		
		try {
			cClass =  Class.forName("edu.hebeu.project.MyClass");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(cClass.isAnnotationPresent(MustHasIdPropertityAnnotation.class)) { // ���MyClass���ϴ���MustHasIdPropertityAnnotationע��
//			MustHasIdPropertityAnnotation mustHasIdPropertityAnnotation = (MustHasIdPropertityAnnotation) cClass.getAnnotation(MustHasIdPropertityAnnotation.class); // ��ȡ���ϵ�MustHasIdPropertityAnnotation����
			
			Field[] fields = cClass.getDeclaredFields(); // ��ȡMyClass���ȫ������
			for(Field f : fields) {
				if("id".equals(f.getName()) && "int".equals(f.getType().getSimpleName())) { // ���ĳ�����Ե�������id���Ҹ�������int
					isLegal = true; // ������Ƿ�Ϸ���־����Ϊtrue
					break;
				}
			}
			
			if(!isLegal) { // ��������Ϸ��ı�־Ϊfalse�����಻�Ϸ�(����û��int���͵�id����)
				throw new MustHasIdPropertityAnnotationExpection();
			}
		}
		
		
		
	}
}
