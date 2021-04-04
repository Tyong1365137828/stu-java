package edu.hebeu.datastream;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * java.io.DataOutputStream��
 * 	��������Խ�������ͬ��������һ��д���ļ����С�
 * 	ע�⣺���д����ļ�������ͨ�ı��ĵ�(���±��򲻿�����֮���������)
 * @author 13651
 *
 */
public class DataOutputStreamStu {
	public static void main(String[] args) {
		DataOutputStream dos = null;
		
		try {
			dos = new DataOutputStream(new FileOutputStream("data\\dataStreamData\\д������"));
			
			/**
			 * д�����
			 */
			byte b = 98;
			short s = 101;
			int i = 1111;
			long l = 3045655L;
			float f = 3.1F;
			double d = 3.1415926;
			boolean bo = false;
			char c = 't';
			
			// д��������͵�����
			dos.writeByte(b);
			dos.writeShort(s);
			dos.writeInt(i);
			dos.writeLong(l);
			dos.writeFloat(f);
			dos.writeDouble(d);
			dos.writeBoolean(bo);
			dos.writeChar(c);
			
			
			dos.flush(); // д�������ɺ����ˢ�·�������չܵ�
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(dos != null) {
				try {
					dos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
