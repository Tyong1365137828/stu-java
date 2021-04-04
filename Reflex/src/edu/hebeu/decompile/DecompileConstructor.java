package edu.hebeu.decompile;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.Scanner;

/**
 * �������չʾ�����빹�췽��
 * @author 13651
 *
 */
public class DecompileConstructor {
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
		
		/**��ȡ������η��б�*/
		cString.append(Modifier.toString(cClass.getModifiers())); // ��ȡ������η���Ϣ
		cString.append(" class ");
		/**��ȡ��ļ�д��*/
		cString.append(cClass.getSimpleName()); // ��ȡ��ļ�д����(����������)
		cString.append(" {\n");
		
		/**��ȡ���еĹ��췽��*/
		Constructor[] constructors = cClass.getDeclaredConstructors();
		for(Constructor c : constructors) {
			cString.append("\t");
			
			/**��ȡ���췽�������η��б�*/
			int modifiersCode = c.getModifiers();
			String modifiers = Modifier.toString(modifiersCode);
			cString.append(modifiers);
			cString.append(" ");
			
			/**��ȡ���췽����(���췽����������ļ�д��)*/
			String constructorName = cClass.getSimpleName();
			cString.append(constructorName);
			cString.append(" ");
			
			/**��ȡ�β��б�*/
			cString.append("(");
			Class[] paramTypesClass = c.getParameterTypes();
			for(Class<?> paramTypeClass : paramTypesClass) {
				String paramType = paramTypeClass.getSimpleName(); // ��ȡ�������ͼ�д��
				cString.append(paramType);
				cString.append(",");
			}
			int endCommaSubScript = cString.lastIndexOf(",");  // ��ȡ���һ�� "," ���±꣬���û�� "," �ͷ��� -1
			if(endCommaSubScript != -1) cString.deleteCharAt(endCommaSubScript); // ��ȡ��������һλ���±�(����ȡ������ "," 1λ�ַ�)
			
			cString.append(") {}\n");
		}
		
		cString.append("}");
		
		System.out.println(cString);
		
	}
}
