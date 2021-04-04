package edu.hebeu.decompile;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Scanner;

/**
 * �������չʾ���ͨ���������ʵ�ַ������ֽ����ļ��е�Field
 * @author 13651
 *
 */
public class DecompileField {
	public static void main(String[] args) {
		
		StringBuilder cString = new StringBuilder(); // ����һ��StringBuilder����������ŷ�����class�ļ�֮����ַ�����Ϣ
		
		Class<?> cClass = null; // ����һ������ֽ���
		
		Scanner scanner = null;
		try {
			scanner = new Scanner(System.in);
			System.out.print("������Ҫ��������ࣺ");
			String className = scanner.next();
			cClass = Class.forName(className); // ��ȡ��������ֽ���
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(null != scanner) {
				scanner.close();
			}
		}
		
		cString.append(Modifier.toString(cClass.getModifiers())); // ��ȡ������η���Ϣ
		cString.append(" class ");
		cString.append(cClass.getSimpleName()); // ��ȡ��ļ�д����(����������)
		cString.append(" {\n");
		
		Field[] fields = cClass.getDeclaredFields(); // ��ȡ������ȫ��Field����
		for(Field f : fields) {
			cString.append("\t");
			int modifiersCode = f.getModifiers(); // ��ȡ������Զ�������η��б��int����
			String modifiersName = Modifier.toString(modifiersCode); // ͨ�������int���ֻ�ȡ���int���ֶ�Ӧ��String�������η��б�
			cString.append(modifiersName);
			cString.append(" ");
			
			Class<?> fieldTypeClass = f.getType(); // ��ȡ������Զ����Class���͵�������
			String fieldTypeName = fieldTypeClass.getSimpleName(); // ͨ��Class���͵���������ȡ���͵�����
			cString.append(fieldTypeName);
			cString.append(" ");
			
			String fieldName = f.getName(); // ��ȡ������Զ��������
			cString.append(fieldName);
			cString.append(";\n");
		}
		
		cString.append("}");
		
		System.out.println(cString);
		
	}
}
