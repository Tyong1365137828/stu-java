package edu.hebeu.fileclass;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * File��������Ĵ����û�й�ϵ�������䲻������ļ��Ķ�д��
 * 	
 * 	File�����ʾʲô��
 * 		File��һ���ļ���Ŀ¼·�����ĳ����ʾ��ʽ��
 * 		D:\programme ��һ��File����
 * 		C:\index.txt Ҳ��һ������
 * 		File�����п�����Ŀ¼��Ҳ�������ļ���Fileֻ��һ��·���ĳ����ʾ��ʽ
 * 
 * 	File�ೣ�õķ���:
 * 		boolean exists(); // �ж��Ƿ����File����
 * 		void createNewFile(); // ���ļ�����ʽ������File����(����File�����ָ��·���´����ļ�)
 * 		void mkdir(); // ��Ŀ¼����ʽ������File����(����File�����ָ��·���´����ļ�)
 * 		void mkdirs(); // �Զ���Ŀ¼����ʽ������File����(����File�����ָ��·���´����ļ�)
 * 		String getParent(); // ��ȡ��ǰFile����ĸ�·��
 * 		File getParentFlie(); // ��ȡ��ǰFile����ĸ�File����
 * 		String getAbsolutePath(); // ��ȡ��ǰFile����ľ���·��
 * 		boolean delete(); // ɾ����ǰFile����(��File����ָ�����ļ���Ŀ¼)
 * 		String getName(); // ��ȡ��ǰFile������ļ���
 * 		boolean isDirectory(); // �жϵ�ǰFile�����Ƿ�ΪĿ¼
 * 		boolean isFile(); // �жϵ�ǰFile�����Ƿ�Ϊ�ļ�
 * 		boolean isHidden(); // �жϵ�ǰFile�����Ƿ�Ϊ�����ļ�
 * 		long lastModified(); // ��ȡ��ǰFile�������һ�ε��޸�ʱ��(���룺1970-1-1 0:0:0 000��ʼ�����ڵĺ�����)
 * 		long length(); // ��ȡ��ǰFile����Ĵ�С(�ֽ�)
 *		boolean renameTo(File dest); // ��������ǰFile�����·�� �� dest·��
 *		File[] listFiles(); // ��ȡ��ǰFile�����µ��������ļ�����
 *		
 *		
 * @author 13651
 *
 */
public class FileStu {
	public static void main(String[] args) {
		File file = new File("D:\\programme\\code\\java\\neon\\IOStu\\data\\file\\����1"); // ·��������Ŀ¼��Ҳ�������ļ�
		
		/**�ж��Ƿ���ڴ�File����(���ж��Ƿ���ڴ�·��)*/
		boolean existsFlag = file.exists();
		System.out.println("���ڴ�File����(·��)��?" + existsFlag);
		
		
			if(!existsFlag) { // ���û�д�File����ָ����·��
					try {
						/**����File�����·�����ļ�����ʽ����*/
						file.createNewFile();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
				/**����File�����·����Ŀ¼����ʽ����*/
//				file.mkdir();				
			}
			
			
			File file2 = new File("D:\\programme\\code\\java\\neon\\IOStu\\data\\file\\a\\b\\c\\d");
			if(!file2.exists()) {
				/**����File�����·���Զ���Ŀ¼����ʽ����*/
				file2.mkdirs();
			}
			
			
			File file3 = new File("D:\\programme\\code\\java\\neon\\IOStu\\data\\file\\����1");
			String parentPath = file3.getParent(); /**��ȡ��ǰFile����ĸ�·��*/
			System.out.println("��ȡ����ǰFile����ĸ�·����" + parentPath + "; ��ǰFile����ľ���·����" + file3.getAbsolutePath());
			File parentFile = file3.getParentFile(); /**��ȡ��ǰFile����ĸ�File����*/
			System.out.println("��ȡ����ǰFile����,�ɸ������ȡ����·����" + parentFile.getAbsolutePath());
			
			System.out.println("��ǰFile������ļ�����" + file3.getName() + "; ��ǰFile�������һ���޸ĵ�ʱ�䣺" + new Date(file3.lastModified()));
			System.out.println("��ǰFile�����Ƿ�ΪĿ¼��" + file3.isDirectory() + "; ��ǰFile�����Ƿ�Ϊ�ļ���" + file3.isFile() + "; ��ǰFile�����Ƿ������صģ�" + file3.isHidden());
			System.out.println("��ǰFile������ļ���С��" + file3.length() + "byte");
			
			/**��ȡ��ǰFile�����µ��������ļ�*/
			File file4 = new File("D:\\programme\\code\\java\\neon\\IOStu\\data\\file");
			File[] files = file4.listFiles();
			System.out.println("��ǰFile������������ļ��ľ���·����");
			for(File f : files) {
				System.out.println(f.getAbsolutePath());
			}
	}
}
