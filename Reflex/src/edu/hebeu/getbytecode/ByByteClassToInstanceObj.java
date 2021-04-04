package edu.hebeu.getbytecode;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import edu.hebeu.entity.User;

/**
 * �������չʾ���ͨ���ֽ���(Class����)��������
 * 
 * �ؼ�������
 * 	Class�ľ�̬������
 * 		Class forName(classInfoOfName); // ��������ᵼ�´������������ ����أ��������������ֽ���
 * 			// ע�⣺����ػᵼ�¾�̬�����ִ�У����Ҿ�̬�����ִֻ��һ�Σ�
 * 
 * 	Class���ʵ��������
 * 		E newInstance(); // �������������ֽ����Ӧ����޲ι��췽�����д�������E��Classָ���ķ��ͣ�δָ��ΪObject
 * 
 * ������Ĵ���(ͨ����ȡ�����ļ�����Ϣ���������)��������Java�Ĵ���дһ�飬��֮�󲻸ı�JavaԴ����Ļ���֮�ϣ�
 * ֱ���޸����������ļ����ݣ�������ͬ�����ʵ�������ǳ�������OCP����ԭ��(����չ���ţ����޸Ĺر�)
 * @author 13651
 *
 */
public class ByByteClassToInstanceObj {
	public static void main(String[] args) {
		/**��ȡ����Ϣ ���������ļ� classInfo.properties*/
		FileReader fr = null; // ����Reader��ȡ��
		Properties classProperties = null; // ������������ݵ�Map���� Properties
		try {
			fr = new FileReader("data\\classInfo.properties");
			
			/**����ȡ������Ϣ���ص�Map���� Properties*/
			classProperties = new Properties();
			try {
				classProperties.load(fr); // ����������Map���� Properties
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			if(null != fr) {
				try {
					fr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		/**��ȡMap�����ڴ�ŵ���Ϣ*/
		String classInfoOfName = classProperties.getProperty("className");
		
		try {
//			Class cClass = Class.forName("edu.hebeu.entity.User"); // ��ȡedu.hebeu.entity.User����ֽ���
//			Class.forName(classInfoOfName); // ִ����������ᵼ�´������������ ����أ�����ػᵼ�¾�̬�����ִ�У����Ҿ�̬�����ִֻ��һ��
			Class cClass = Class.forName(classInfoOfName);
			Object userObj = cClass.newInstance();
			
//			Class<User> userClass = (Class<User>)Class.forName("edu.hebeu.entity.User");
//			User userObj = userClass.newInstance();
			
			System.out.println(userObj);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
