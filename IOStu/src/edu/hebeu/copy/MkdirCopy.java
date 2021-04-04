package edu.hebeu.copy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MkdirCopy {
	public static void main(String[] args) {
		File srcFile = new File("F:\\ѧϰ\\C++"); // ��������Դ����
		File destFile = new File("D:\\programme\\code\\java\\neon\\IOStu\\data\\mkdir\\dest"); // ��������Ŀ��
		
		copyMkdir(srcFile, destFile); // ���ÿ���Ŀ¼��̬����
	}
	
	/**
	 * ����Ŀ¼����
	 * @param srcFile ����Դ
	 * @param destFile ����Ŀ��
	 */
	public static void copyMkdir(File srcFile, File destFile) {
		if(srcFile.isFile()) { /**�������Դ�ļ����ļ�*/
			/**���п����ļ�*/
			FileInputStream fis = null;
			FileOutputStream fos = null;
			
			try {
				fis = new FileInputStream(srcFile); // ͨ������Դ��File���󴴽�FileInputStream�ֽ�����������
				String destFilePath = (destFile.getAbsolutePath().endsWith("\\") ? destFile.getAbsolutePath() : destFile.getAbsoluteFile() + "\\") + srcFile.getAbsolutePath().substring(3);// ��ȡ������Ŀ���ļ�·����substring(3)��ʾ������Դ�ļ������·���ӵ�3λ��ʼ��ȡ(��������ת�������ȡ�̷������ȡ��" D:/ ")
				fos = new FileOutputStream(destFilePath); // ͨ������Ŀ���File���󴴽�FileOutputStream�ֽ����������
				byte[] bytes = new byte[1024 * 1024]; // һ������ȡ1MB�ֽ�
				int readBytesCount = 0; // �洢ÿ�ζ�ȡ���ֽ�������ֽ���
				while((readBytesCount = fis.read(bytes)) != -1) {
					fos.write(bytes, 0, readBytesCount); // ����д����
				}
				
				fos.flush(); // ���������֮�����ˢ�£���չܵ�
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if(fis != null) {
					try {
						fis.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(fos != null) {
					try {
						fos.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			return; // �����ݹ�
		}

		System.out.println("����============��");
		/**����ִ�е���˵������Դ��Ŀ¼*/
		File[] childFiles = srcFile.listFiles();
		System.out.println("���ȣ�" + childFiles.length);
		for(File childFile : childFiles) { // ��ȡ����ԴĿ¼�����ļ�����

//			System.out.println(childFile.getAbsolutePath());
			if(childFile.isDirectory()) { // �������Դ�ļ���������ļ���Ŀ¼
				// �½���ӦĿ¼
				String srcMkdir = childFile.getAbsolutePath(); // ��ȡ������ԴĿ¼
				String destMkdir = (destFile.getAbsolutePath().endsWith("\\") ? destFile.getAbsolutePath() : destFile.getAbsoluteFile() + "\\") + srcMkdir.substring(3); // ��ȡ������Ŀ��Ŀ¼��substring(3)��ʾ������Դ�ļ������·���ӵ�3λ��ʼ��ȡ(��������ת�������ȡ�̷������ȡ��" D:/ ")
				File newFile = new File(destMkdir); // ͨ��Ŀ��Ŀ¼����File����
				if(!newFile.exists()) { // ������File���󲻴���
					newFile.mkdirs(); // ͨ�����File���󴴽�Ŀ¼
				}
			}
			
			copyMkdir(childFile, destFile); // ���еݹ�
		}
	}
}
