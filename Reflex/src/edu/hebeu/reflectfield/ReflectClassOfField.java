package edu.hebeu.reflectfield;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * �������չʾ���ͨ��������Ʒ�������ֶ�(����)
 * @author 13651
 *
 */
public class ReflectClassOfField {
	public static void main(String[] args) {
		
		Class fieldEntityClass = null;
		try {
			fieldEntityClass = Class.forName("edu.hebeu.entity.FieldEntity"); // ��ȡ�������ֽ���
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/**
		 * ��ȡ�ֽ�������������
		 * 	String fullName getName(); // ��ȡClass�����ȫ����(��������)
		 * 	String simpleName getSimpleName(); // ��ȡClass����ļ�д����(����������)
		 */
		String fieldEntityClassName = fieldEntityClass.getName();
		String fieldEntityClassSimpleName = fieldEntityClass.getSimpleName();
		System.out.println("�ֽ�������������" + fieldEntityClassName + ";Simple������" + fieldEntityClassSimpleName);
		
		/**
		 * Class�ķ�����
		 * ��ȡ����������е���public���ε������ֶΣ�Field[] getFields();
		 */
		Field[] fields = fieldEntityClass.getFields();
		System.out.println("ͨ��getFields()������ȡ���е�public���Գ��ȣ�" + fields.length);
		for(Field f : fields) {
			/**
			 * Field��ķ�����
			 * 	��ȡField�������������String getName()��
			 * 	��ȡField������������ͣ�Class getType();
			 * 	��ȡField������������η��б�int getModifiers();
			 * 
			 * Modifier��ķ�����
			 * 	ͨ�����η���int������ת��ΪString���͵����η�����String static toString(int modifierCode);
			 * 		�磺String modifierName = Modifier.toString(1); // public
			 * 
			 */
			String fieldName = f.getName();
			Class fieldTypeclass = f.getType();
			String fieldTypeName = fieldTypeclass.getSimpleName();
			int modifierCode = f.getModifiers();
			
			System.out.print("������:" + fieldName + ",��������:" + fieldTypeName + ",�������η��б���" + Modifier.toString(modifierCode) + "��;		");
		}System.out.println();
		
		/**
		 * Class��ķ�����
		 * 	��ȡ��������е������ֶΣ�Field[] getDeclaredFields();
		 */
		Field[] fields2 = fieldEntityClass.getDeclaredFields();
		System.out.println("ͨ��getDeclaredFields()������ȡ���е������ֶγ��ȣ�" + fields2.length);
		for(Field f : fields2) {
			/**
			 * Field��ķ�����
			 * 	��ȡField�������������String getName();
			 * 	��ȡField��������ͣ�Class getType();
			 * 	��ȡField������������η��б�int getModifiers();
			 * 
			 * Modifier��ķ�����
			 * 	ͨ�����η���int������ת��ΪString���͵����η�����String static toString(int modifierCode);
			 * 		�磺String modifierName = Modifier.toString(2); // private
			 */
			String fieldName = f.getName();
			Class fieldTypeclass = f.getType();
			String fieldTypeName = fieldTypeclass.getSimpleName();
			int modifierCode = f.getModifiers();
			
			System.out.print("������:" + fieldName + ",��������:" + fieldTypeName + ",�������η��б���" + Modifier.toString(modifierCode) + "��;		");
		}System.out.println();
		
	}
}
