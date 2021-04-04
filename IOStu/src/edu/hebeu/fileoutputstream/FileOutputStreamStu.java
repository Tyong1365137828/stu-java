package edu.hebeu.fileoutputstream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * ͨ���������ѧϰFileOutputStream��
 * 	
 * @author 13651
 *
 */
public class FileOutputStreamStu {
	public static void main(String[] args) {
		FileOutputStream fos = null;
		try {
			/**���ֹ��췽�������Ķ�����д���ļ�ʱ�����Ƚ�ԭ�ļ���յ����ڽ�������д���ļ�**/
//			fos = new FileOutputStream("data/д������"); // д���ļ�ʱ��������ڴ��ļ����Զ�����
			
			/**���ֹ��췽�������Ķ�����д���ļ�ʱ���ὲ��д������׷�ӵ�ԭ�ļ�ĩβ���������ԭ�ļ�����**/
			fos = new FileOutputStream("data/streamData/д������", true); // 
			
			/**д�����**/
			// 1.1��ͨ��int���͵�����(��byte��ֵ)д���ļ�
			/*fos.write(98);*/
			
			// 1.2������byte����д���ļ�(��byte����ȫ��д��)
			/*byte[] bytes = {97, 98, 99, 100, 101, 102, 103, 104};
			fos.write(bytes); // ��������д���ļ�
			*/
			
			// 1.3����byte���鲿��д���ļ�
			/*byte[] bytes = {97, 98, 99, 100, 101, 102, 103, 104};
			fos.write(bytes, 0, 3); // ��ʾ��byte������±�Ϊ0��λ�ã�д�볤����3��д���ļ�
			*/
			
			String s = "��ã���Ҫ�ɹ��ˣ�����";
			byte[] bytes = s.getBytes(); // ��String�ַ���ת��Ϊbyte����
			fos.write(bytes); // ���ַ���ת���ɵ�byte����д�뵽�ļ���
			
			
			
			// д��֮��һ��Ҫˢ��һ�£�����չܵ�
			fos.flush();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
