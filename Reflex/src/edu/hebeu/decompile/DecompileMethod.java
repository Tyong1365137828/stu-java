package edu.hebeu.decompile;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

/**
 * �������չʾ�����뷽��
 * @author 13651
 *
 */
public class DecompileMethod {
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
		
		Method[] methods = cClass.getDeclaredMethods(); // ��ȡ������ȫ��Method����
		for(Method m : methods) {
			cString.append("\t");
			int modifiersCode = m.getModifiers(); // ��ȡ������Զ�������η��б��int����
			String modifiersName = Modifier.toString(modifiersCode); // ͨ�������int���ֻ�ȡ���int���ֶ�Ӧ��String�������η��б�
			cString.append(modifiersName);
			cString.append(" ");
			
			Class<?> methodReturnTypeClass = m.getReturnType(); // ��ȡ�����������ķ���ֵ��Class���͵�������
			String methodReturnTypeName = methodReturnTypeClass.getSimpleName(); // ͨ��Class���͵���������ȡ���͵�����
			cString.append(methodReturnTypeName);
			cString.append(" ");
			
			String methodName = m.getName(); // ��ȡ�����������(Method����)������
			cString.append(methodName);
			cString.append("(");
			
			Class[] paramClassTypes = m.getParameterTypes(); // ��ȡ����������β����ͣ�Class������ʽ����
			for(Class paramClassType : paramClassTypes) {
				cString.append(paramClassType.getSimpleName());
				cString.append(",");
			}
			int commaSubScript = cString.lastIndexOf(",");  // ��ȡ���һ�� "," ���±꣬���û�� "," �ͷ��� -1
			if(commaSubScript != -1) cString.deleteCharAt(commaSubScript); // ��ȡ��������һλ���±�(����ȡ������ "," 1λ�ַ�)
			
			cString.append(") {}\n");
		}
		
		cString.append("}");
		
		System.out.println(cString);
	}
}
