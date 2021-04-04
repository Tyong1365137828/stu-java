package edu.hebeu.objectstream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * ���л���ʹ��ObjectOutputStream��ʵ�֣�
 * 
 * 	�������л��ͷ����л��������ʵ��Serializable�ӿڣ����������쳣��java.io.NotSerializableException;(���������л�)
 * 
 * 	ע�⣺ͨ��Դ���뷢�֣�Serializable�ӿ�ֻ��һ����־�ӿڣ��ڲ�ʲô����Ҳû�У��𵽱�ʶ�����ã�Java��������ܻ����������������
 * Serializable����ӿ��Ǹ�Java������ο��ģ�Java�������������ӿ�֮�󣬻�Ϊ�����Զ�����һ�����л��汾�ţ�
 * 
 * ���л��汾�ŵ����ã�
 * 	
 * 
 * @author 13651
 *
 */
public class ObjectOutputStreamStu {
	public static void main(String[] args) {
		ObjStudent os = new ObjStudent("1365", "test", 20);
		ObjectOutputStream oos = null; // ����ObjectOutputStream����
		
		try {
			oos = new ObjectOutputStream(new FileOutputStream("data\\serializable\\student"));// ����ObjectOutputStream����
			
			oos.writeObject(os); // ���л�����(���л�һ��)
			
			oos.flush(); // ʹ���������֮��Ҫˢ�£���չܵ�
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
			}
		}
	}
}
