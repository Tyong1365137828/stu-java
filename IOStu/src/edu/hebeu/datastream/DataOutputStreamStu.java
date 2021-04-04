package edu.hebeu.datastream;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * java.io.DataOutputStream：
 * 	这个流可以将数据连同数据类型一并写入文件当中。
 * 	注意：这个写入的文件不是普通文本文档(记事本打不开，打开之后是乱码的)
 * @author 13651
 *
 */
public class DataOutputStreamStu {
	public static void main(String[] args) {
		DataOutputStream dos = null;
		
		try {
			dos = new DataOutputStream(new FileOutputStream("data\\dataStreamData\\写入数据"));
			
			/**
			 * 写入操作
			 */
			byte b = 98;
			short s = 101;
			int i = 1111;
			long l = 3045655L;
			float f = 3.1F;
			double d = 3.1415926;
			boolean bo = false;
			char c = 't';
			
			// 写入各种类型的数据
			dos.writeByte(b);
			dos.writeShort(s);
			dos.writeInt(i);
			dos.writeLong(l);
			dos.writeFloat(f);
			dos.writeDouble(d);
			dos.writeBoolean(bo);
			dos.writeChar(c);
			
			
			dos.flush(); // 写入操作完成后调用刷新方法，清空管道
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
