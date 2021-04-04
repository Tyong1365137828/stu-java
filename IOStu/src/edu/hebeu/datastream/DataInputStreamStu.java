package edu.hebeu.datastream;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * java.io.DataInputStream:
 * 	数据字节输入流；
 * 	DataOutputStream写的文件只能用DataInputStream读，并且要提前知道写入的顺序；
 * 	加密方式一致(读的顺序与写的顺序要一致)，才可以正常读取出数据
 * @author 13651
 *
 */
public class DataInputStreamStu {
	public static void main(String[] args) {
		DataInputStream dis = null;
		
		try {
			dis = new DataInputStream(new FileInputStream("data//dataStreamData//写入数据")); // 创建DataInputStream读文件对象
			
			/**
			 * 进行读操作
			 */
			byte b = dis.readByte();
			short s = dis.readShort();
			int i = dis.readInt();
			long l = dis.readLong();
			float f = dis.readFloat();
			double d = dis.readDouble();
			boolean boo = dis.readBoolean();
			char c = dis.readChar();
			
			System.out.println(b);
			System.out.println(s);
			System.out.println(i);
			System.out.println(l);
			System.out.println(f);
			System.out.println(d);
			System.out.println(boo);
			System.out.println(c);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(dis != null) {
				try {
					dis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
